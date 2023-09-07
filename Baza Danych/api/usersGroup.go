package api

import (
	"API/api/handlers"
	"github.com/labstack/echo/v4"
)

func UsersGroup(e *echo.Group) {
	e.GET("/", handlers.GetUsers)
	//e.POST("/add", handlers.CreateUser)
	e.GET("/:id", handlers.GetUser)
	//e.PUT("/:id", handlers.UpdateUser)
	//e.DELETE("/:id", handlers.DeleteUser)
}
