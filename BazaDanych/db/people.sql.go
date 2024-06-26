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

const createPersonEvent = `-- name: CreatePersonEvent :exec
INSERT INTO person_event (person_id, event_id)
VALUES ($1, $2)
`

type CreatePersonEventParams struct {
	PersonID int32 `json:"person_id"`
	EventID  int32 `json:"event_id"`
}

func (q *Queries) CreatePersonEvent(ctx context.Context, arg CreatePersonEventParams) error {
	_, err := q.db.Exec(ctx, createPersonEvent, arg.PersonID, arg.EventID)
	return err
}

const createPersonRank = `-- name: CreatePersonRank :exec
INSERT INTO person_rank (person_id, rank_id)
VALUES ($1, $2)
`

type CreatePersonRankParams struct {
	PersonID int32 `json:"person_id"`
	RankID   int32 `json:"rank_id"`
}

func (q *Queries) CreatePersonRank(ctx context.Context, arg CreatePersonRankParams) error {
	_, err := q.db.Exec(ctx, createPersonRank, arg.PersonID, arg.RankID)
	return err
}

const createPersonSubBadge = `-- name: CreatePersonSubBadge :exec
INSERT INTO person_sub_badge (person_id, sub_badge_id)
VALUES ($1, $2)
`

type CreatePersonSubBadgeParams struct {
	PersonID   int32 `json:"person_id"`
	SubBadgeID int32 `json:"sub_badge_id"`
}

func (q *Queries) CreatePersonSubBadge(ctx context.Context, arg CreatePersonSubBadgeParams) error {
	_, err := q.db.Exec(ctx, createPersonSubBadge, arg.PersonID, arg.SubBadgeID)
	return err
}

const deletePerson = `-- name: DeletePerson :exec
DELETE
FROM person
WHERE id = $1
`

func (q *Queries) DeletePerson(ctx context.Context, id int32) error {
	_, err := q.db.Exec(ctx, deletePerson, id)
	return err
}

const deletePersonEvent = `-- name: DeletePersonEvent :exec
DELETE
FROM person_event
WHERE person_id = $1
  AND event_id = $2
`

type DeletePersonEventParams struct {
	PersonID int32 `json:"person_id"`
	EventID  int32 `json:"event_id"`
}

func (q *Queries) DeletePersonEvent(ctx context.Context, arg DeletePersonEventParams) error {
	_, err := q.db.Exec(ctx, deletePersonEvent, arg.PersonID, arg.EventID)
	return err
}

const deletePersonRank = `-- name: DeletePersonRank :exec
DELETE
FROM person_rank
WHERE person_id = $1
  AND rank_id = $2
`

type DeletePersonRankParams struct {
	PersonID int32 `json:"person_id"`
	RankID   int32 `json:"rank_id"`
}

func (q *Queries) DeletePersonRank(ctx context.Context, arg DeletePersonRankParams) error {
	_, err := q.db.Exec(ctx, deletePersonRank, arg.PersonID, arg.RankID)
	return err
}

const deletePersonSubBadge = `-- name: DeletePersonSubBadge :exec
DELETE
FROM person_sub_badge
WHERE person_id = $1
  AND sub_badge_id = $2
`

type DeletePersonSubBadgeParams struct {
	PersonID   int32 `json:"person_id"`
	SubBadgeID int32 `json:"sub_badge_id"`
}

func (q *Queries) DeletePersonSubBadge(ctx context.Context, arg DeletePersonSubBadgeParams) error {
	_, err := q.db.Exec(ctx, deletePersonSubBadge, arg.PersonID, arg.SubBadgeID)
	return err
}

const getPeople = `-- name: GetPeople :many
SELECT id, name, inscription, other_names, code_names, birth_date, birth_place, death_date, death_place, burial_place, cemetery, quarter, row, grave, ranks, badges, activity, description, sources, status
FROM main_view
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
			&i.Status,
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
SELECT id, name, inscription, other_names, code_names, birth_date, birth_place, death_date, death_place, burial_place, cemetery, quarter, row, grave, ranks, badges, activity, description, sources, status
FROM main_view
WHERE id = $1
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
		&i.Status,
	)
	return i, err
}

const getPersonEvents = `-- name: GetPersonEvents :many
SELECT pe.event_id AS id,
       e.name      AS event_name,
       sa.name     AS sub_activity_name,
       a.name      AS activity_name
FROM activity a
         LEFT JOIN sub_activity sa ON a.id = sa.activity_id
         LEFT JOIN event e ON sa.id = e.sub_activity_id
         LEFT JOIN person_event pe ON e.id = pe.event_id
WHERE pe.person_id = $1
`

type GetPersonEventsRow struct {
	ID              *int32  `json:"id"`
	EventName       *string `json:"event_name"`
	SubActivityName *string `json:"sub_activity_name"`
	ActivityName    string  `json:"activity_name"`
}

func (q *Queries) GetPersonEvents(ctx context.Context, personID int32) ([]GetPersonEventsRow, error) {
	rows, err := q.db.Query(ctx, getPersonEvents, personID)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	var items []GetPersonEventsRow
	for rows.Next() {
		var i GetPersonEventsRow
		if err := rows.Scan(
			&i.ID,
			&i.EventName,
			&i.SubActivityName,
			&i.ActivityName,
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

const getPersonRanks = `-- name: GetPersonRanks :many
SELECT r.id   AS id,
       r.name AS rank
FROM rank r
         LEFT JOIN person_rank pr ON r.id = pr.rank_id
WHERE pr.person_id = $1
`

type GetPersonRanksRow struct {
	ID   int32  `json:"id"`
	Rank string `json:"rank"`
}

func (q *Queries) GetPersonRanks(ctx context.Context, personID int32) ([]GetPersonRanksRow, error) {
	rows, err := q.db.Query(ctx, getPersonRanks, personID)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	var items []GetPersonRanksRow
	for rows.Next() {
		var i GetPersonRanksRow
		if err := rows.Scan(&i.ID, &i.Rank); err != nil {
			return nil, err
		}
		items = append(items, i)
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const getPersonSubBadges = `-- name: GetPersonSubBadges :many
SELECT pb.sub_badge_id AS id,
       sb.name         AS sub_badge,
       b.name          AS badge
FROM badge b
         LEFT JOIN sub_badge sb ON b.id = sb.badge_id
         LEFT JOIN person_sub_badge pb ON sb.id = pb.sub_badge_id
WHERE pb.person_id = $1
`

type GetPersonSubBadgesRow struct {
	ID       *int32  `json:"id"`
	SubBadge *string `json:"sub_badge"`
	Badge    string  `json:"badge"`
}

func (q *Queries) GetPersonSubBadges(ctx context.Context, personID int32) ([]GetPersonSubBadgesRow, error) {
	rows, err := q.db.Query(ctx, getPersonSubBadges, personID)
	if err != nil {
		return nil, err
	}
	defer rows.Close()
	var items []GetPersonSubBadgesRow
	for rows.Next() {
		var i GetPersonSubBadgesRow
		if err := rows.Scan(&i.ID, &i.SubBadge, &i.Badge); err != nil {
			return nil, err
		}
		items = append(items, i)
	}
	if err := rows.Err(); err != nil {
		return nil, err
	}
	return items, nil
}

const updatePerson = `-- name: UpdatePerson :one
UPDATE person
SET name           = $2,
    inscription    = $3,
    other_names    = $4,
    code_names     = $5,
    birth_date     = $6,
    birth_place_id = $7,
    death_date     = $8,
    death_place_id = $9,
    grave_id       = $10,
    description    = $11,
    sources        = $12
WHERE id = $1
RETURNING id
`

type UpdatePersonParams struct {
	ID           int32       `json:"id"`
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

func (q *Queries) UpdatePerson(ctx context.Context, arg UpdatePersonParams) (int32, error) {
	row := q.db.QueryRow(ctx, updatePerson,
		arg.ID,
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
