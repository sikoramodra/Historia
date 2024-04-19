package handlers

import (
	"context"
	"github.com/labstack/echo/v4"
	"net/http"
)

func (h *Handler) GetBadges(c echo.Context) error {
	r, err := h.DB.GetBadges(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, r)
}
