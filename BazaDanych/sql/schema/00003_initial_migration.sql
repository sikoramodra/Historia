-- +goose Up
-- +goose StatementBegin
ALTER TABLE people RENAME TO person;

CREATE TABLE place (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE cemetery (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    burial_place_id INTEGER REFERENCES place(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE quarter (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    cemetery_id INTEGER REFERENCES cemetery(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE row (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quarter_id INTEGER REFERENCES quarter(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE grave (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    row_id INTEGER REFERENCES row(id) ON DELETE CASCADE NOT NULL
);


CREATE TABLE rank (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- arrays of FK are not supported https://commitfest.postgresql.org/17/1252/
CREATE TABLE person_rank (
    person_id INTEGER REFERENCES person(id) ON DELETE CASCADE,
    rank_id INTEGER REFERENCES rank(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, rank_id)
);


CREATE TABLE badge (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE sub_badge (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    badge_id INTEGER REFERENCES badge(id) ON DELETE CASCADE
);

CREATE TABLE person_sub_badge (
    person_id INTEGER REFERENCES person(id) ON DELETE CASCADE,
    sub_badge_id INTEGER REFERENCES sub_badge(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, sub_badge_id)
);

ALTER TABLE person
    ADD COLUMN inscription VARCHAR(255),
    ADD COLUMN other_names VARCHAR(255)[],
    ADD COLUMN code_names VARCHAR(255)[],
    ADD COLUMN birth_date DATE,
    ADD COLUMN birth_place_id INTEGER REFERENCES place(id) ON DELETE SET NULL,
    ADD COLUMN death_date DATE,
    ADD COLUMN death_place_id INTEGER REFERENCES place(id) ON DELETE SET NULL,
    ADD COLUMN grave_id INTEGER REFERENCES grave(id) ON DELETE SET NULL,
    ADD COLUMN description TEXT,
    ADD COLUMN sources TEXT;


CREATE TABLE activity (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE sub_activity (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    activity_id INTEGER REFERENCES activity(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    sub_activity_id INTEGER REFERENCES sub_activity(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE person_activity (
    person_id INTEGER REFERENCES person(id) ON DELETE CASCADE,
    event_id INTEGER REFERENCES event(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, event_id)
);
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
ALTER TABLE person RENAME TO people;

ALTER TABLE people
    DROP COLUMN inscription,
    DROP COLUMN other_names,
    DROP COLUMN code_names,
    DROP COLUMN birth_date,
    DROP COLUMN birth_place_id,
    DROP COLUMN death_date,
    DROP COLUMN death_place_id,
    DROP COLUMN grave_id,
    DROP COLUMN description,
    DROP COLUMN sources;

DROP TABLE place, grave, row, quarter, cemetery,
    rank, person_rank, sub_badge, badge, person_sub_badge,
    event, sub_activity, activity, person_activity;
-- +goose StatementEnd
