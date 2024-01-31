package handlers

import (
	"strconv"

	"API/db"

	"github.com/labstack/echo/v4"
)

type Handler struct {
	DB *db.Queries
}

func (h *Handler) GetParamByName(c echo.Context, name string) (int32, error) {
	id, err := strconv.Atoi(c.Param(name))
	if err != nil {
		return -1, err
	}

	id32 := int32(id)
	return id32, nil
}
