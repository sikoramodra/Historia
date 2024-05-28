-- +goose Up
-- +goose StatementBegin
CREATE OR REPLACE FUNCTION insert_cemetery()
    RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO cemetery (name, burial_place_id) VALUES (NULL, NEW.id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER place_insert_trigger
    AFTER INSERT ON place
    FOR EACH ROW
EXECUTE FUNCTION insert_cemetery();
-- +goose StatementEnd

-- +goose Down
-- +goose StatementBegin
DROP TRIGGER place_insert_trigger ON place;
DROP FUNCTION insert_cemetery();
-- +goose StatementEnd
