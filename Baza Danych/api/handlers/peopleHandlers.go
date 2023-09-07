package handlers

import (
	"github.com/labstack/echo/v4"
	"net/http"
	"strconv"
)

type Person struct {
	ID   int32  `json:"id"`
	Name string `json:"name"`
}

var People = []Person{
	{1, "Person1"},
	{2, "Person2"},
	{3, "Person3"},
}

func GetPeople(c echo.Context) error {
	return c.JSON(http.StatusOK, People)
}

//func CreatePerson(c echo.Context) error {}

func GetPerson(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	return c.JSON(http.StatusOK, People[id])
}

//func UpdatePerson(c echo.Context) error {}

//func DeletePerson(c echo.Context) error {}
