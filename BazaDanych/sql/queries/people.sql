-- name: GetPeople :many
SELECT * FROM people;

-- name: GetPerson :one
SELECT * FROM people WHERE id = $1;

-- name: CreatePerson :exec
INSERT INTO people (name) VALUES ($1);