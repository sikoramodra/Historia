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
SELECT rank_name AS ranks
FROM show_peoples_ranks
WHERE person_id = $1;

-- name: CreatePersonRank :exec
INSERT INTO person_rank (person_id, rank_id)
VALUES ($1, $2);

-- name: DeletePersonRank :exec
DELETE
FROM person_rank
WHERE person_id = $1
  AND rank_id = $2;
