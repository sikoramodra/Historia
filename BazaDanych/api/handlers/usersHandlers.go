package handlers

import (
	"context"
	"net/http"
	"strconv"

	"API/db"

	"github.com/labstack/echo/v4"
)

type User struct {
	ID   int32  `json:"id"`
	Name string `json:"name"`
}

func (h *DBHandler) GetUsers(c echo.Context) error {
	people, err := h.DB.GetUsers(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, people)
}

func (h *DBHandler) CreateUser(c echo.Context) error {
	u := new(User)
	if err := c.Bind(u); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err := h.DB.CreateUser(context.Background(), u.Name)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *DBHandler) GetUser(c echo.Context) error {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	u, err := h.DB.GetUser(context.Background(), int32(id))
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, u)
}

func (h *DBHandler) UpdateUser(c echo.Context) error {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	u := new(User)
	if err := c.Bind(u); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	data := db.UpdateUserParams{
		ID:   int32(id),
		Name: u.Name,
	}

	err = h.DB.UpdateUser(context.Background(), data)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err.Error())
	}

	return c.NoContent(http.StatusOK)
}

func (h *DBHandler) DeleteUser(c echo.Context) error {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeleteUser(context.Background(), int32(id))
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}
