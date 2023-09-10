package api

import (
	"API/api/handlers"

	"github.com/labstack/echo/v4"
)

func UsersGroup(g *echo.Group, h *handlers.DBHandler) {
	g.GET("/", h.GetUsers)
	g.POST("/", h.CreateUser)
	g.GET("/:id", h.GetUser)
	g.PUT("/:id", h.UpdateUser)
	g.DELETE("/:id", h.DeleteUser)
}
