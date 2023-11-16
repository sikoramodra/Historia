-- +goose Up
-- +goose StatementBegin
ALTER TABLE place ADD UNIQUE (name);
ALTER TABLE cemetery ADD UNIQUE (name, burial_place_id);
ALTER TABLE quarter ADD UNIQUE (name, cemetery_id);
ALTER TABLE row ADD UNIQUE (name, quarter_id);
ALTER TABLE grave ADD UNIQUE (name, row_id);

ALTER TABLE rank ADD UNIQUE (name);

ALTER TABLE badge ADD UNIQUE (name);
ALTER TABLE sub_badge ADD UNIQUE (name, badge_id);

ALTER TABLE activity ADD UNIQUE (name);
ALTER TABLE sub_activity ADD UNIQUE (name, activity_id);
ALTER TABLE event ADD UNIQUE (name, sub_activity_id);
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
ALTER TABLE place DROP CONSTRAINT place_name_key;
ALTER TABLE cemetery DROP CONSTRAINT cemetery_name_burial_place_id_key;
ALTER TABLE quarter DROP CONSTRAINT quarter_name_cemetery_id_key;
ALTER TABLE row DROP CONSTRAINT row_name_quarter_id_key;
ALTER TABLE grave DROP CONSTRAINT grave_name_row_id_key;

ALTER TABLE rank DROP CONSTRAINT rank_name_key;

ALTER TABLE sub_badge DROP CONSTRAINT sub_badge_name_badge_id_key;
ALTER TABLE badge DROP CONSTRAINT badge_name_key;

ALTER TABLE activity DROP CONSTRAINT activity_name_key;
ALTER TABLE sub_activity DROP CONSTRAINT sub_activity_name_activity_id_key;
ALTER TABLE event DROP CONSTRAINT event_name_sub_activity_id_key;
-- +goose StatementEnd
