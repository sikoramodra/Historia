-- +goose Up
-- +goose StatementBegin
CREATE OR REPLACE FUNCTION insert_sub_badge()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO sub_badge (name, badge_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER badges_insert_trigger
    AFTER INSERT ON badge
    FOR EACH ROW
EXECUTE FUNCTION insert_sub_badge();


CREATE OR REPLACE FUNCTION insert_quarter()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO quarter (name, cemetery_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER cemetery_insert_trigger
    AFTER INSERT ON cemetery
    FOR EACH ROW
EXECUTE FUNCTION insert_quarter();


CREATE OR REPLACE FUNCTION insert_row()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO row (name, quarter_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER quarter_insert_trigger
    AFTER INSERT ON quarter
    FOR EACH ROW
EXECUTE FUNCTION insert_row();


CREATE OR REPLACE FUNCTION insert_grave()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO grave (name, row_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER row_insert_trigger
    AFTER INSERT ON row
    FOR EACH ROW
EXECUTE FUNCTION insert_grave();


CREATE OR REPLACE FUNCTION insert_sub_activity()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO sub_activity (name, activity_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER activity_insert_trigger
    AFTER INSERT ON activity
    FOR EACH ROW
EXECUTE FUNCTION insert_sub_activity();


CREATE OR REPLACE FUNCTION insert_event()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO event (name, sub_activity_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER sub_activity_insert_trigger
    AFTER INSERT ON sub_activity
    FOR EACH ROW
EXECUTE FUNCTION insert_event();
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
DROP TRIGGER badges_insert_trigger ON badge;
DROP FUNCTION insert_sub_badge();

DROP TRIGGER cemetery_insert_trigger ON cemetery;
DROP FUNCTION insert_quarter();

DROP TRIGGER quarter_insert_trigger ON quarter;
DROP FUNCTION insert_row();

DROP TRIGGER row_insert_trigger ON row;
DROP FUNCTION insert_grave();

DROP TRIGGER activity_insert_trigger ON activity;
DROP FUNCTION insert_sub_activity();

DROP TRIGGER sub_activity_insert_trigger ON sub_activity;
DROP FUNCTION insert_event();
-- +goose StatementEnd
