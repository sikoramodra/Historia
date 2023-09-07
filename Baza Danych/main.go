package main

import (
	"fmt"
	"github.com/joho/godotenv"
	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
	"log"
	"net/http"
	"os"
)

func main() {
	e := echo.New()

	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(middleware.CORS())

	if err := godotenv.Load(".env"); err != nil {
		log.Fatal(err)
	}

	//usersGroup := e.Group("/users")
	//peopleGroup := e.Group("/people")

	// test endpoint
	e.GET("/", func(c echo.Context) error {
		return c.String(http.StatusOK, "test")
	})

	e.Logger.Fatal(e.Start(fmt.Sprintf(":%s", os.Getenv("PORT"))))
}
