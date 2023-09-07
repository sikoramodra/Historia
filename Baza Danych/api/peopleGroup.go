package api

import (
	"API/api/handlers"
	"github.com/labstack/echo/v4"
)

func PeopleGroup(e *echo.Group) {
	e.GET("/", handlers.GetPeople)
	//e.POST("/add", handlers.CreatePerson)
	e.GET("/:id", handlers.GetPerson)
	//e.PUT("/:id", handlers.UpdatePerson)
	//e.DELETE("/:id", handlers.DeletePerson)
}
