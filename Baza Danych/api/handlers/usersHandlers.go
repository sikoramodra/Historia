package handlers

import (
	"github.com/labstack/echo/v4"
	"net/http"
	"strconv"
)

type User struct {
	ID   int32  `json:"id"`
	Name string `json:"name"`
}

var Users = []Person{
	{1, "User1"},
	{2, "User2"},
	{3, "User3"},
}

func GetUsers(c echo.Context) error {
	return c.JSON(http.StatusOK, Users)
}

//func CreateUser(c echo.Context) error {}

func GetUser(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	return c.JSON(http.StatusOK, Users[id])
}

//func UpdateUser(c echo.Context) error {}

//func DeleteUser(c echo.Context) error {}
