package handlers

import (
	"context"
	"net/http"
	"strconv"

	"API/db"

	"github.com/labstack/echo/v4"
)

func (h *Handler) GetPeople(c echo.Context) error {
	people, err := h.DB.GetPeople(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, people)
}

func (h *Handler) CreatePerson(c echo.Context) error {
	p := new(db.CreatePersonParams)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreatePerson(context.Background(), *p)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) GetPerson(c echo.Context) error {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	p, err := h.DB.GetPerson(context.Background(), int32(id))
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, p)
}

func (h *Handler) UpdatePerson(c echo.Context) error {
	pId, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	p := new(db.UpdatePersonParams)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	p.ID = int32(pId)

	id, err := h.DB.UpdatePerson(context.Background(), *p)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err.Error())
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeletePerson(c echo.Context) error {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeletePerson(context.Background(), int32(id))
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}
