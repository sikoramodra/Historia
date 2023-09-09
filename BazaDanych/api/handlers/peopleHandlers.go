package handlers

import (
	"context"
	"log"
	"net/http"
	"strconv"

	"github.com/labstack/echo/v4"
)

func (h *DBHandler) GetPeople(c echo.Context) error {
	people, err := h.DB.GetPeople(context.Background())
	if err != nil {
		log.Fatal(err)
	}

	return c.JSON(http.StatusOK, people)
}

func (h *DBHandler) CreatePerson(c echo.Context) error {

	err := h.DB.CreatePerson(context.Background(), "test")
	if err != nil {
		log.Fatal("CreatePerson failed: ", err)
	}

	return c.JSON(http.StatusCreated, "")
}

func (h *DBHandler) GetPerson(c echo.Context) error {
	id, _ := strconv.Atoi(c.Param("id"))
	person, err := h.DB.GetPerson(context.Background(), int32(id))
	if err != nil {
		log.Fatal("GetPerson failed: ", err)
	}

	return c.JSON(http.StatusOK, person)
}

//func UpdatePerson(c echo.Context) error {}

//func DeletePerson(c echo.Context) error {}
