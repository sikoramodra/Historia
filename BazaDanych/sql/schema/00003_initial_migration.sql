-- +goose Up
-- +goose StatementBegin
CREATE TABLE places (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE cemetery (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    burial_place_id INTEGER REFERENCES places(id) ON DELETE CASCADE NOT NULL
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


CREATE TABLE ranks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- arrays of FK are not supported https://commitfest.postgresql.org/17/1252/
CREATE TABLE people_ranks (
    person_id INTEGER REFERENCES people(id) ON DELETE CASCADE,
    rank_id INTEGER REFERENCES ranks(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, rank_id)
);


CREATE TABLE sub_badges (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE badges (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sub_badge_id INTEGER REFERENCES sub_badges(id) ON DELETE CASCADE
);

CREATE TABLE people_badges (
    person_id INTEGER REFERENCES people(id) ON DELETE CASCADE,
    badge_id INTEGER REFERENCES badges(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, badge_id)
);

ALTER TABLE people
    ADD COLUMN inscription VARCHAR(255),
    ADD COLUMN other_names VARCHAR(255)[],
    ADD COLUMN code_names VARCHAR(255)[],
    ADD COLUMN birth_date DATE,
    ADD COLUMN birth_place_id INTEGER REFERENCES places(id) ON DELETE SET NULL,
    ADD COLUMN death_date DATE,
    ADD COLUMN death_place_id INTEGER REFERENCES places(id) ON DELETE SET NULL,
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

CREATE TABLE events (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    sub_activity_id INTEGER REFERENCES sub_activity(id) ON DELETE CASCADE NOT NULL
);

CREATE TABLE people_activity (
    person_id INTEGER REFERENCES people(id) ON DELETE CASCADE,
    event_id INTEGER REFERENCES events(id) ON DELETE CASCADE,
    PRIMARY KEY (person_id, event_id)
);
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
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

DROP TABLE places, grave, row, quarter, cemetery,
    ranks, people_ranks, sub_badges, badges, people_badges,
    events, sub_activity, activity, people_activity;
-- +goose StatementEnd
