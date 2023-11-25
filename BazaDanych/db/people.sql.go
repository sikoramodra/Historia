// Code generated by sqlc. DO NOT EDIT.
// versions:
//   sqlc v1.21.0
// source: people.sql

package db

import (
	"context"

	"github.com/jackc/pgx/v5/pgtype"
)

const createPerson = `-- name: CreatePerson :one
INSERT INTO person (name, inscription, other_names, code_names, birth_date, birth_place_id, death_date, death_place_id,
                    grave_id, description, sources)
VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11)
RETURNING id
`

type CreatePersonParams struct {
	Name         string      `json:"name"`
	Inscription  *string     `json:"inscription"`
	OtherNames   []string    `json:"other_names"`
	CodeNames    []string    `json:"code_names"`
	BirthDate    pgtype.Date `json:"birth_date"`
	BirthPlaceID *int32      `json:"birth_place_id"`
	DeathDate    pgtype.Date `json:"death_date"`
	DeathPlaceID *int32      `json:"death_place_id"`
	GraveID      *int32      `json:"grave_id"`
	Description  *string     `json:"description"`
	Sources      *string     `json:"sources"`
}

func (q *Queries) CreatePerson(ctx context.Context, arg CreatePersonParams) (int32, error) {
	row := q.db.QueryRow(ctx, createPerson,
		arg.Name,
		arg.Inscription,
		arg.OtherNames,
		arg.CodeNames,
		arg.BirthDate,
		arg.BirthPlaceID,
		arg.DeathDate,
		arg.DeathPlaceID,
		arg.GraveID,
		arg.Description,
		arg.Sources,
	)
	var id int32
	err := row.Scan(&id)
	return id, err
}

const deletePerson = `-- name: DeletePerson :exec
DELETE FROM person WHERE id = $1
`

func (q *Queries) DeletePerson(ctx context.Context, id int32) error {
	_, err := q.db.Exec(ctx, deletePerson, id)
	return err
}

const getPeople = `-- name: GetPeople :many
SELECT id, name, inscription, other_names, code_names, birth_date, birth_place, death_date, death_place, burial_place, cemetery, quarter, row, grave, ranks, badges, activity, description, sources FROM main_view
`

func (q *Queries) GetPeople(ctx context.Context) ([]MainView, error) {
	rows, err := q.db.Query(ctx, getPeople)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	var items []MainView
	for rows.Next() {
		var i MainView
		if err := rows.Scan(
			&i.ID,
			&i.Name,
			&i.Inscription,
			&i.OtherNames,
			&i.CodeNames,
			&i.BirthDate,
			&i.BirthPlace,
			&i.DeathDate,
			&i.DeathPlace,
			&i.BurialPlace,
			&i.Cemetery,
			&i.Quarter,
			&i.Row,
			&i.Grave,
			&i.Ranks,
			&i.Badges,
			&i.Activity,
			&i.Description,
			&i.Sources,
		); err != nil {
			return nil, err
		}
		items = append(items, i)
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const getPerson = `-- name: GetPerson :one
SELECT id, name, inscription, other_names, code_names, birth_date, birth_place, death_date, death_place, burial_place, cemetery, quarter, row, grave, ranks, badges, activity, description, sources FROM main_view WHERE id = $1
`

func (q *Queries) GetPerson(ctx context.Context, id int32) (MainView, error) {
	row := q.db.QueryRow(ctx, getPerson, id)
	var i MainView
	err := row.Scan(
		&i.ID,
		&i.Name,
		&i.Inscription,
		&i.OtherNames,
		&i.CodeNames,
		&i.BirthDate,
		&i.BirthPlace,
		&i.DeathDate,
		&i.DeathPlace,
		&i.BurialPlace,
		&i.Cemetery,
		&i.Quarter,
		&i.Row,
		&i.Grave,
		&i.Ranks,
		&i.Badges,
		&i.Activity,
		&i.Description,
		&i.Sources,
	)
	return i, err
}

const updatePerson = `-- name: UpdatePerson :exec
UPDATE person SET name = $2 WHERE id = $1
`

type UpdatePersonParams struct {
	ID   int32  `json:"id"`
	Name string `json:"name"`
}

func (q *Queries) UpdatePerson(ctx context.Context, arg UpdatePersonParams) error {
	_, err := q.db.Exec(ctx, updatePerson, arg.ID, arg.Name)
	return err
}
