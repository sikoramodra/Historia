package main

import (
	"context"
	"fmt"
	"log"
	"net/http"
	"os"

	"API/api"
	"API/api/handlers"
	"API/db"

	"github.com/jackc/pgx/v5"
	"github.com/joho/godotenv"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

func main() {
	e := echo.New()

	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORS())

	if err := godotenv.Load(".env"); err != nil {
		log.Fatal("Could not load the environment")
	}

	conn, err := pgx.Connect(context.Background(), os.Getenv("DB_URL_DOCKER"))
	if err != nil {
		log.Fatal("Database URL is not found in the environment", err)
	}
	DB := &handlers.DBHandler{
		DB: db.New(conn),
	}

	usersGroup := e.Group("/users")
	api.UsersGroup(usersGroup)
	peopleGroup := e.Group("/people")
	api.PeopleGroup(peopleGroup, DB)

	// test endpoint
	e.GET("/", func(c echo.Context) error {
		return c.String(http.StatusOK, "test")
	})

	e.Logger.Fatal(e.Start(fmt.Sprintf(":%s", os.Getenv("PORT"))))
}
