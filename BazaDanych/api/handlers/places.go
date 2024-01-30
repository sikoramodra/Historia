package handlers

import (
	"context"
	"net/http"

	"API/db"

	"github.com/labstack/echo/v4"
)

func (h *Handler) GetPlaces(c echo.Context) error {
	p, err := h.DB.GetPlaces(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, p)
}

func (h *Handler) CreatePlace(c echo.Context) error {
	p := new(string)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreatePlace(context.Background(), *p)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) UpdatePlace(c echo.Context) error {
	pId, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	p := new(db.UpdatePlaceParams)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	p.ID = pId

	id, err := h.DB.UpdatePlace(context.Background(), *p)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err.Error())
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeletePlace(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeletePlace(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetPlacesFull(c echo.Context) error {
	p, err := h.DB.GetPlacesFull(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, p)
}
