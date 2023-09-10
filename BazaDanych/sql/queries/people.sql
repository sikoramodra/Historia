-- name: GetPeople :many
SELECT * FROM people;

-- name: GetPerson :one
SELECT * FROM people WHERE id = $1;

-- name: CreatePerson :exec
INSERT INTO people (name) VALUES ($1);

-- name: UpdatePerson :exec
UPDATE people SET name = $2 WHERE id = $1;

-- name: DeletePerson :exec
DELETE FROM people WHERE id = $1;
