-- name: GetPeople :many
SELECT * FROM main_view;

-- name: GetPerson :one
SELECT * FROM main_view WHERE id = $1;

-- name: CreatePerson :one
INSERT INTO person (name, inscription, other_names, code_names, birth_date, birth_place_id, death_date, death_place_id,
                    grave_id, description, sources)
VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11)
RETURNING id;

-- name: UpdatePerson :exec
UPDATE person SET name = $2 WHERE id = $1;

-- name: DeletePerson :exec
DELETE FROM person WHERE id = $1;
