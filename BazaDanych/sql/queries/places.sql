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


-- name: GetCemeteries :many
SELECT * FROM cemetery;

-- name: CreateCemetery :one
INSERT INTO cemetery (name, burial_place_id)
VALUES ($1, $2)
RETURNING id;

-- name: DeleteCemetery :exec
DELETE
FROM cemetery
WHERE id = $1;


-- name: GetQuarters :many
SELECT * FROM quarter;

-- name: CreateQuarter :one
INSERT INTO quarter (name, cemetery_id)
VALUES ($1, $2)
RETURNING id;

-- name: DeleteQuarter :exec
DELETE
FROM quarter
WHERE id = $1;


-- name: GetRows :many
SELECT * FROM row;

-- name: CreateRow :one
INSERT INTO row (name, quarter_id)
VALUES ($1, $2)
RETURNING id;

-- name: DeleteRow :exec
DELETE
FROM row
WHERE id = $1;


-- name: GetGraves :many
SELECT * FROM grave;

-- name: CreateGrave :one
INSERT INTO grave (name, row_id)
VALUES ($1, $2)
RETURNING id;

-- name: DeleteGrave :exec
DELETE
FROM grave
WHERE id = $1;
