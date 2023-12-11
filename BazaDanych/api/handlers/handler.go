package handlers

import (
	"strconv"

	"API/db"

	"github.com/labstack/echo/v4"
)

type Handler struct {
	DB *db.Queries
}

func (h *Handler) GetParamId(c echo.Context) (int32, error) {
	id, err := strconv.ParseInt(c.Param("id"), 10, 32)
	if err != nil {
		return -1, err
	}

	id32 := int32(id)
	return id32, nil
}
