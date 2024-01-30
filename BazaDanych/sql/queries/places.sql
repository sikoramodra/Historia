-- name: GetPlaces :many
SELECT * FROM place;

-- name: CreatePlace :one
INSERT INTO place (name)
VALUES ($1)
RETURNING id;

-- name: UpdatePlace :one
UPDATE place
SET name = $2
WHERE id = $1
RETURNING id;

-- name: DeletePlace :exec
DELETE
FROM place
WHERE id = $1;

-- name: GetPlacesFull :many
SELECT g.id   AS id,
       g.name AS grave,
       r.name AS row,
       q.name AS quarter,
       c.name AS cementery,
       p.name AS place
FROM place p
         INNER JOIN cemetery c ON p.id = c.burial_place_id
         INNER JOIN quarter q ON c.id = q.cemetery_id
         INNER JOIN row r ON q.id = r.quarter_id
         INNER JOIN grave g ON r.id = g.row_id;
