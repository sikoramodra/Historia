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
SELECT json.p_id                                                                                    AS id,
       json.p_name                                                                                  AS name,
       json_agg(json_build_object('id', json.c_id, 'name', json.c_name, 'quarters', json.quarters)) AS cemeteries
FROM (SELECT json.p_id,
             json.p_name,
             json.c_id,
             json.c_name,
             json_agg(json_build_object('id', json.q_id, 'name', json.q_name, 'rows', json.rows)) AS quarters
      FROM (SELECT json.p_id,
                   json.p_name,
                   json.c_id,
                   json.c_name,
                   json.q_id,
                   json.q_name,
                   json_agg(json_build_object('id', json.r_id, 'name', json.r_name, 'graves', json.graves)) AS rows
            FROM (SELECT p.id                                                    AS p_id,
                         p.name                                                  AS p_name,
                         c.id                                                    AS c_id,
                         c.name                                                  AS c_name,
                         q.id                                                    AS q_id,
                         q.name                                                  AS q_name,
                         r.id                                                    AS r_id,
                         r.name                                                  AS r_name,
                         json_agg(json_build_object('id', g.id, 'name', g.name)) AS graves
                  FROM place p
                           LEFT JOIN cemetery c ON p.id = c.burial_place_id
                           LEFT JOIN quarter q ON c.id = q.cemetery_id
                           LEFT JOIN row r ON q.id = r.quarter_id
                           LEFT JOIN grave g ON r.id = g.row_id
                  GROUP BY p.id, c.id, q.id, r.id) json
            GROUP BY json.p_id, json.p_name, json.c_id, json.c_name, json.q_id, json.q_name) json
      GROUP BY json.p_id, json.p_name, json.c_id, json.c_name) json
GROUP BY json.p_id, json.p_name;


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
