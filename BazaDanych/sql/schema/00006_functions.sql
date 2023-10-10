-- +goose Up
-- +goose StatementBegin
CREATE OR REPLACE FUNCTION person_ranks(person INTEGER)
    RETURNS json AS $$
declare
    person_ranks json;
BEGIN
    SELECT coalesce(json_agg(r.name) FILTER (WHERE r.name IS NOT NULL), '[]') INTO person_ranks
    FROM ranks r
             LEFT JOIN public.people_ranks pr on r.id = pr.rank_id
    WHERE pr.person_id = person
    GROUP BY pr.person_id;

    RETURN person_ranks;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION person_badges(person INTEGER)
    RETURNS json AS $$
declare
    person_badges json;
BEGIN
    SELECT json_agg(row_to_json(json)) INTO person_badges
    FROM (SELECT b.name                                                               AS badge,
                 coalesce(json_agg(sb.name) FILTER (WHERE sb.name IS NOT NULL), '[]') AS sub_badges
          FROM people_badges pb
                   LEFT JOIN badges b on pb.badge_id = b.id
                   LEFT JOIN sub_badges sb on b.sub_badge_id = sb.id
          WHERE pb.person_id = person
          GROUP BY b.name) json;

    RETURN person_badges;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION person_activity(person INTEGER)
    RETURNS json AS $$
declare
    person_activity json;
BEGIN
    SELECT json_agg(row_to_json(json)) INTO person_activity
    FROM (SELECT json.activity                                              AS name,
                 json_agg(row_to_json(json)::jsonb - 'activity') AS sub_activity
          FROM (SELECT a.name                                                             AS activity,
                       sa.name                                                            AS name,
                       coalesce(json_agg(e.name) FILTER (WHERE e.name IS NOT NULL), '[]') AS events
                FROM people_activity pa
                         LEFT JOIN public.events e on pa.event_id = e.id
                         LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
                         LEFT JOIN public.activity a on sa.activity_id = a.id
                WHERE pa.person_id = person
                GROUP BY a.name, sa.name) json
          GROUP BY json.activity) json;

    RETURN person_activity;
END;
$$ LANGUAGE plpgsql;

CREATE VIEW main_view AS
SELECT
    p.id,
    p.name AS name,
    p.inscription,
    array_to_json(p.other_names) AS other_names,
    array_to_json(p.code_names) AS code_names,
    p.birth_date,
    p1.name AS birth_place,
    p.death_date,
    p2.name AS death_place,
    bp.name AS burial_place,
    c.name AS cemetery,
    q.name AS quarter,
    r.name AS row,
    g.name AS grave,
    person_ranks(p.id) AS ranks,
    person_badges(p.id) AS badges,
    person_activity(p.id) AS activity

FROM people p

         LEFT JOIN public.places p1 on p.birth_place_id = p1.id
         LEFT JOIN public.places p2 on p.death_place_id = p2.id

         LEFT JOIN public.grave g on p.grave_id = g.id
         LEFT JOIN public.row r on g.row_id = r.id
         LEFT JOIN public.quarter q on r.quarter_id = q.id
         LEFT JOIN public.cemetery c on q.cemetery_id = c.id
         LEFT JOIN public.places bp on c.burial_place_id = bp.id;
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
DROP FUNCTION person_ranks(person INTEGER);
DROP FUNCTION person_badges(person INTEGER);
DROP FUNCTION person_activity(person INTEGER);
DROP VIEW main_view;
-- +goose StatementEnd
