package main

import (
	"database/sql"
	"fmt"
	"log"
	"net/http"
	"os"

	"API/api"
	"API/api/handlers"
	"API/db"

	_ "github.com/jackc/pgx/v5/stdlib" // load pgx driver (goose supports only *sql.DB)
	"github.com/joho/godotenv"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"github.com/pressly/goose/v3"
)

func main() {
	e := echo.New()

	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORS())

	if err := godotenv.Load(".env"); err != nil {
		log.Fatal("Could not load the environment")
	}

	conn, err := sql.Open("pgx", os.Getenv("DB_URL_DOCKER"))
	if err != nil {
		log.Fatal("Database URL is not found in the environment", err)
	}

	err = goose.Up(conn, "sql/schema/")
	if err != nil {
		log.Fatal("Failed to migrate the database")
	}
	DB := &handlers.DBHandler{
		DB: db.New(conn),
	}

	usersGroup := e.Group("/users")
	api.UsersGroup(usersGroup, DB)
	peopleGroup := e.Group("/people")
	api.PeopleGroup(peopleGroup, DB)

	e.GET("/", func(c echo.Context) error {
		return c.NoContent(http.StatusOK)
	})

	e.Logger.Fatal(e.Start(fmt.Sprintf(":%s", os.Getenv("PORT"))))
}
