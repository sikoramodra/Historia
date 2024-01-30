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

func (h *Handler) GetCemeteries(c echo.Context) error {
	ce, err := h.DB.GetCemeteries(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, ce)
}

func (h *Handler) CreateCemetery(c echo.Context) error {
	ce := new(db.CreateCemeteryParams)
	if err := c.Bind(ce); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreateCemetery(context.Background(), *ce)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeleteCemetery(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeleteCemetery(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetQuarters(c echo.Context) error {
	q, err := h.DB.GetQuarters(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, q)
}

func (h *Handler) CreateQuarter(c echo.Context) error {
	q := new(db.CreateQuarterParams)
	if err := c.Bind(q); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreateQuarter(context.Background(), *q)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeleteQuarter(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeleteQuarter(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetRows(c echo.Context) error {
	r, err := h.DB.GetRows(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, r)
}

func (h *Handler) CreateRow(c echo.Context) error {
	r := new(db.CreateRowParams)
	if err := c.Bind(r); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreateRow(context.Background(), *r)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeleteRow(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeleteRow(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetGraves(c echo.Context) error {
	g, err := h.DB.GetGraves(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, g)
}

func (h *Handler) CreateGrave(c echo.Context) error {
	g := new(db.CreateGraveParams)
	if err := c.Bind(g); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	id, err := h.DB.CreateGrave(context.Background(), *g)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeleteGrave(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeleteGrave(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}
