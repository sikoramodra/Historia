-- +goose Up
-- +goose StatementBegin
CREATE TYPE status AS ENUM ('unverified', 'verified');

ALTER TABLE person
    ADD status status DEFAULT 'unverified';

DROP VIEW main_view;

CREATE VIEW main_view AS
SELECT
    p.id,
    p.name AS name,
    p.inscription AS inscription,
    p.other_names AS other_names,
    p.code_names AS code_names,
    p.birth_date AS birth_date,
    p1.name AS birth_place,
    p.death_date AS death_date,
    p2.name AS death_place,
    bp.name AS burial_place,
    c.name AS cemetery,
    q.name AS quarter,
    r.name AS row,
    g.name AS grave,
    person_ranks(p.id) AS ranks,
    person_badges(p.id) AS badges,
    person_activity(p.id) AS activity,
    p.description AS description,
    p.sources AS sources,
    p.status AS status

FROM person p
         LEFT JOIN public.place p1 on p.birth_place_id = p1.id
         LEFT JOIN public.place p2 on p.death_place_id = p2.id
         LEFT JOIN public.grave g on p.grave_id = g.id
         LEFT JOIN public.row r on g.row_id = r.id
         LEFT JOIN public.quarter q on r.quarter_id = q.id
         LEFT JOIN public.cemetery c on q.cemetery_id = c.id
         LEFT JOIN public.place bp on c.burial_place_id = bp.id;

-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
ALTER TABLE person
    DROP status CASCADE;

DROP TYPE status CASCADE;

CREATE VIEW main_view AS
SELECT
    p.id,
    p.name AS name,
    p.inscription AS inscription,
    p.other_names AS other_names,
    p.code_names AS code_names,
    p.birth_date AS birth_date,
    p1.name AS birth_place,
    p.death_date AS death_date,
    p2.name AS death_place,
    bp.name AS burial_place,
    c.name AS cemetery,
    q.name AS quarter,
    r.name AS row,
    g.name AS grave,
    person_ranks(p.id) AS ranks,
    person_badges(p.id) AS badges,
    person_activity(p.id) AS activity,
    p.description AS description,
    p.sources AS sources

FROM person p
         LEFT JOIN public.place p1 on p.birth_place_id = p1.id
         LEFT JOIN public.place p2 on p.death_place_id = p2.id
         LEFT JOIN public.grave g on p.grave_id = g.id
         LEFT JOIN public.row r on g.row_id = r.id
         LEFT JOIN public.quarter q on r.quarter_id = q.id
         LEFT JOIN public.cemetery c on q.cemetery_id = c.id
         LEFT JOIN public.place bp on c.burial_place_id = bp.id;
-- +goose StatementEnd
