package api

import (
	"API/api/handlers"

	"github.com/labstack/echo/v4"
)

func PeopleGroup(g *echo.Group, h *handlers.DBHandler) {

	g.GET("/", h.GetPeople)
	g.POST("/", h.CreatePerson)
	g.GET("/:id", h.GetPerson)
	g.PUT("/:id", h.UpdatePerson)
	g.DELETE("/:id", h.DeletePerson)
}
