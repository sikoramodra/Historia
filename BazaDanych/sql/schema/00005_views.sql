-- +goose Up
-- +goose StatementBegin
CREATE VIEW show_all_places AS
SELECT p.id   AS place_id,
       p.name AS place_name
FROM places p;

CREATE VIEW show_all_graves AS
SELECT bp.id   AS burial_place_id,
       bp.name AS burial_place_name,
       c.id    AS cemetery_id,
       c.name  AS cemetery_name,
       q.id    AS quarter_id,
       q.name  AS quarter_name,
       r.id    AS row_id,
       r.name  AS row_name,
       g.id    AS grave_id,
       g.name  AS grave_name
FROM grave g
         LEFT JOIN public.row r on g.row_id = r.id
         LEFT JOIN public.quarter q on r.quarter_id = q.id
         LEFT JOIN public.cemetery c on q.cemetery_id = c.id
         LEFT JOIN public.places bp on c.burial_place_id = bp.id;

CREATE VIEW show_peoples_graves AS
SELECT p.id    AS person_id,
       p.name  AS person_name,
       bp.id   AS burial_place_id,
       bp.name AS burial_place_name,
       c.id    AS cemetery_id,
       c.name  AS cemetery_name,
       q.id    AS quarter_id,
       q.name  AS quarter_name,
       r.id    AS row_id,
       r.name  AS row_name,
       g.id    AS grave_id,
       g.name  AS grave_name
FROM people p
         LEFT JOIN public.grave g on p.grave_id = g.id
         LEFT JOIN public.row r on g.row_id = r.id
         LEFT JOIN public.quarter q on r.quarter_id = q.id
         LEFT JOIN public.cemetery c on q.cemetery_id = c.id
         LEFT JOIN public.places bp on c.burial_place_id = bp.id;

CREATE VIEW show_all_ranks AS
SELECT r.id   AS rank_id,
       r.name AS ramk_name
FROM ranks r;

CREATE VIEW show_peoples_ranks AS
SELECT p.id   AS person_id,
       p.name AS person_name,
       r.id   AS rank_id,
       r.name AS rank_name
FROM ranks r
         LEFT JOIN public.people_ranks pr on r.id = pr.rank_id
         LEFT JOIN public.people p on p.id = pr.person_id;

CREATE VIEW show_all_badges AS
SELECT b.id    AS badge_id,
       b.name  AS badge_name,
       sb.id   AS sub_badge_id,
       sb.name AS sub_badge_name
FROM badges b
         LEFT JOIN public.sub_badges sb on b.sub_badge_id = sb.id;

CREATE VIEW show_peoples_badges AS
SELECT p.id    AS person_id,
       p.name  AS person_name,
       b.id    AS badge_id,
       b.name  AS badge_name,
       sb.id   AS sub_badge_id,
       sb.name AS sub_badge_name
FROM people p
         LEFT JOIN public.people_badges pb on p.id = pb.person_id
         LEFT JOIN public.badges b on pb.badge_id = b.id
         LEFT JOIN public.sub_badges sb on b.sub_badge_id = sb.id;

CREATE VIEW show_all_badges_json AS
SELECT json_agg(to_json(json)) AS badges
FROM (SELECT b.name                                                               AS badge,
             coalesce(json_agg(sb.name) FILTER (WHERE sb.name IS NOT NULL), '[]') AS sub_badges
      FROM badges b
               LEFT JOIN public.sub_badges sb on b.sub_badge_id = sb.id
      GROUP BY b.name) json;

CREATE VIEW show_peoples_badges_json AS
SELECT json.person,
       json_agg(row_to_json(json)::jsonb - 'person') AS badges
FROM (SELECT p.name                                                               AS person,
             b.name                                                               AS badge,
             coalesce(json_agg(sb.name) FILTER (WHERE sb.name IS NOT NULL), '[]') AS sub_badges
      FROM people p
               LEFT JOIN people_badges pb on p.id = pb.person_id
               LEFT JOIN badges b on pb.badge_id = b.id
               LEFT JOIN sub_badges sb on b.sub_badge_id = sb.id
      GROUP BY b.name, p.name) json
GROUP BY json.person;

CREATE VIEW show_all_activity AS
SELECT a.id    AS activity_id,
       a.name  AS activity_name,
       sa.id   AS sub_activity_id,
       sa.name AS sub_activity_name,
       e.id    AS event_id,
       e.name  AS event_name

FROM events e
         LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
         LEFT JOIN public.activity a on sa.activity_id = a.id;

CREATE VIEW show_peoples_activity AS
SELECT p.id    AS person_id,
       p.name  AS person_name,
       a.id    AS activity_id,
       a.name  AS activity_name,
       sa.id   AS sub_activity_id,
       sa.name AS sub_activity_name,
       e.id    AS event_id,
       e.name  AS event_name

FROM people p
         LEFT JOIN public.people_activity pa on p.id = pa.person_id
         LEFT JOIN public.events e on pa.event_id = e.id
         LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
         LEFT JOIN public.activity a on sa.activity_id = a.id;

CREATE VIEW show_all_activity_json AS
SELECT json_agg(to_json(json)) AS activity
FROM (SELECT json.activity,
             json_agg(row_to_json(json)::jsonb - 'activity') AS sub_activity
      FROM (SELECT a.name                                                             AS activity,
                   sa.name                                                            AS name,
                   coalesce(json_agg(e.name) FILTER (WHERE e.name IS NOT NULL), '[]') AS events
            FROM events e
                     LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
                     LEFT JOIN public.activity a on sa.activity_id = a.id
            GROUP BY sa.id, a.id) json
      GROUP BY json.activity) json;

CREATE VIEW show_peoples_activity_json AS
SELECT json.person,
       jsonb_agg(row_to_json(json)::jsonb - 'person') AS activity
FROM (SELECT json.person,
             json.activity                                              AS name,
             json_agg(row_to_json(json)::jsonb - 'person' - 'activity') AS sub_activity
      FROM (SELECT p.name                                                             AS person,
                   a.name                                                             AS activity,
                   sa.name                                                            AS name,
                   coalesce(json_agg(e.name) FILTER (WHERE e.name IS NOT NULL), '[]') AS events
            FROM people p
                     LEFT JOIN public.people_activity pa on p.id = pa.person_id
                     LEFT JOIN public.events e on pa.event_id = e.id
                     LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
                     LEFT JOIN public.activity a on sa.activity_id = a.id
            GROUP BY p.name, a.name, sa.name) json
      GROUP BY json.activity, json.person) json
GROUP BY json.person;
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
DROP VIEW show_all_places,
          show_all_graves,
          show_peoples_graves,
          show_all_ranks,
          show_peoples_ranks,
          show_all_badges,
          show_peoples_badges,
          show_all_badges_json,
          show_peoples_badges_json,
          show_all_activity,
          show_peoples_activity,
          show_all_activity_json,
          show_peoples_activity_json;
-- +goose StatementEnd