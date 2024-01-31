-- name: GetPeople :many
SELECT *
FROM main_view;

-- name: GetPerson :one
SELECT *
FROM main_view
WHERE id = $1;

-- name: CreatePerson :one
INSERT INTO person (name, inscription, other_names, code_names, birth_date, birth_place_id, death_date, death_place_id,
                    grave_id, description, sources)
VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11)
RETURNING id;

-- name: UpdatePerson :one
UPDATE person
SET name           = $2,
    inscription    = $3,
    other_names    = $4,
    code_names     = $5,
    birth_date     = $6,
    birth_place_id = $7,
    death_date     = $8,
    death_place_id = $9,
    grave_id       = $10,
    description    = $11,
    sources        = $12
WHERE id = $1
RETURNING id;

-- name: DeletePerson :exec
DELETE
FROM person
WHERE id = $1;


-- name: GetPersonRanks :many
SELECT r.id   AS id,
       r.name AS rank
FROM rank r
         LEFT JOIN person_rank pr ON r.id = pr.rank_id
WHERE pr.person_id = $1;


-- name: CreatePersonRank :exec
INSERT INTO person_rank (person_id, rank_id)
VALUES ($1, $2);

-- name: DeletePersonRank :exec
DELETE
FROM person_rank
WHERE person_id = $1
  AND rank_id = $2;


-- name: GetPersonSubBadges :many
SELECT pb.sub_badge_id AS id,
       sb.name         AS sub_badge,
       b.name          AS badge
FROM badge b
         LEFT JOIN sub_badge sb ON b.id = sb.badge_id
         LEFT JOIN person_sub_badge pb ON sb.id = pb.sub_badge_id
WHERE pb.person_id = $1;

-- name: CreatePersonSubBadge :exec
INSERT INTO person_sub_badge (person_id, sub_badge_id)
VALUES ($1, $2);

-- name: DeletePersonSubBadge :exec
DELETE
FROM person_sub_badge
WHERE person_id = $1
  AND sub_badge_id = $2;


-- name: GetPersonEvents :many
SELECT pe.event_id AS id,
       e.name      AS event_name,
       sa.name     AS sub_activity_name,
       a.name      AS activity_name
FROM activity a
         LEFT JOIN sub_activity sa ON a.id = sa.activity_id
         LEFT JOIN event e ON sa.id = e.sub_activity_id
         LEFT JOIN person_event pe ON e.id = pe.event_id
WHERE pe.person_id = $1;

-- name: CreatePersonEvent :exec
INSERT INTO person_event (person_id, event_id)
VALUES ($1, $2);

-- name: DeletePersonEvent :exec
DELETE
FROM person_event
WHERE person_id = $1
  AND event_id = $2;
