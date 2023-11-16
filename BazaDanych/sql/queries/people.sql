-- name: GetPeople :many
SELECT * FROM main_view;

-- name: GetPerson :one
SELECT * FROM person WHERE id = $1;

-- name: CreatePerson :exec
INSERT INTO person (name) VALUES ($1);

-- name: UpdatePerson :exec
UPDATE person SET name = $2 WHERE id = $1;

-- name: DeletePerson :exec
DELETE FROM person WHERE id = $1;
