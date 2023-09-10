package api

import (
	"API/api/handlers"

	"github.com/labstack/echo/v4"
)

func UsersGroup(e *echo.Group, h *handlers.DBHandler) {
	e.GET("/", h.GetUsers)
	e.POST("/add", h.CreateUser)
	e.GET("/:id", h.GetUser)
	e.PUT("/:id", h.UpdateUser)
	e.DELETE("/:id", h.DeleteUser)
}
