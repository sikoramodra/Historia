package api

import (
	"API/api/handlers"

	"github.com/labstack/echo/v4"
)

func PeopleGroup(g *echo.Group, h *handlers.DBHandler) {

	g.GET("/", h.GetPeople)
	g.POST("/add", h.CreatePerson)
	g.GET("/:id", h.GetPerson)
	//g.PUT("/:id", handlers.UpdatePerson)
	//g.DELETE("/:id", handlers.DeletePerson)
}
