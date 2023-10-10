-- +goose Up
-- +goose StatementBegin
ALTER TABLE places ADD UNIQUE (name);
ALTER TABLE cemetery ADD UNIQUE (name, burial_place_id);
ALTER TABLE quarter ADD UNIQUE (name, cemetery_id);
ALTER TABLE row ADD UNIQUE (name, quarter_id);
ALTER TABLE grave ADD UNIQUE (name, row_id);

ALTER TABLE ranks ADD UNIQUE (name);

ALTER TABLE sub_badges ADD UNIQUE (name);
ALTER TABLE badges ADD UNIQUE (name, sub_badge_id);

ALTER TABLE activity ADD UNIQUE (name);
ALTER TABLE sub_activity ADD UNIQUE (name, activity_id);
ALTER TABLE events ADD UNIQUE (name, sub_activity_id);
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
ALTER TABLE places DROP CONSTRAINT places_name_key;
ALTER TABLE cemetery DROP CONSTRAINT cemetery_name_burial_place_id_key;
ALTER TABLE quarter DROP CONSTRAINT quarter_name_cemetery_id_key;
ALTER TABLE row DROP CONSTRAINT row_name_quarter_id_key;
ALTER TABLE grave DROP CONSTRAINT grave_name_row_id_key;

ALTER TABLE ranks DROP CONSTRAINT ranks_name_key;

ALTER TABLE sub_badges DROP CONSTRAINT sub_badges_name_key;
ALTER TABLE badges DROP CONSTRAINT badges_name_sub_badge_id_key;

ALTER TABLE activity DROP CONSTRAINT activity_name_key;
ALTER TABLE sub_activity DROP CONSTRAINT sub_activity_name_activity_id_key;
ALTER TABLE events DROP CONSTRAINT events_name_sub_activity_id_key;
-- +goose StatementEnd
