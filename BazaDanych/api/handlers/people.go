package handlers

import (
	"context"
	"net/http"

	"API/db"

	"github.com/labstack/echo/v4"
)

func (h *Handler) GetPeople(c echo.Context) error {
	p, err := h.DB.GetPeople(context.Background())
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, p)
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
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	p, err := h.DB.GetPerson(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, p)
}

func (h *Handler) UpdatePerson(c echo.Context) error {
	pId, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}
	p := new(db.UpdatePersonParams)
	if err := c.Bind(p); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	p.ID = pId

	id, err := h.DB.UpdatePerson(context.Background(), *p)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err.Error())
	}

	return c.JSON(http.StatusOK, id)
}

func (h *Handler) DeletePerson(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	err = h.DB.DeletePerson(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetPersonRanks(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pr, err := h.DB.GetPersonRanks(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, pr)
}

func (h *Handler) CreatePersonRank(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pr := new(db.CreatePersonRankParams)
	if err := c.Bind(pr); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pr.PersonID = id

	err = h.DB.CreatePersonRank(context.Background(), *pr)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) DeletePersonRank(c echo.Context) error {
	personId, err := h.GetParamByName(c, "pid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	rankId, err := h.GetParamByName(c, "rid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pr := &db.DeletePersonRankParams{
		PersonID: personId,
		RankID:   rankId,
	}

	err = h.DB.DeletePersonRank(context.Background(), *pr)

	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetPersonSubBadges(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pb, err := h.DB.GetPersonSubBadges(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, pb)
}

func (h *Handler) CreatePersonSubBadge(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pb := new(db.CreatePersonSubBadgeParams)
	if err := c.Bind(pb); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pb.PersonID = id

	err = h.DB.CreatePersonSubBadge(context.Background(), *pb)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) DeletePersonSubBadge(c echo.Context) error {
	personId, err := h.GetParamByName(c, "pid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	subBadgeId, err := h.GetParamByName(c, "bid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pb := &db.DeletePersonSubBadgeParams{
		PersonID:   personId,
		SubBadgeID: subBadgeId,
	}

	err = h.DB.DeletePersonSubBadge(context.Background(), *pb)

	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) GetPersonEvents(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pe, err := h.DB.GetPersonEvents(context.Background(), id)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.JSON(http.StatusOK, pe)
}

func (h *Handler) CreatePersonEvent(c echo.Context) error {
	id, err := h.GetParamByName(c, "id")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pe := new(db.CreatePersonEventParams)
	if err := c.Bind(pe); err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pe.PersonID = id

	err = h.DB.CreatePersonEvent(context.Background(), *pe)
	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}

func (h *Handler) DeletePersonEvent(c echo.Context) error {
	personId, err := h.GetParamByName(c, "pid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	eventId, err := h.GetParamByName(c, "eid")
	if err != nil {
		return c.JSON(http.StatusBadRequest, err)
	}

	pe := &db.DeletePersonEventParams{
		PersonID: personId,
		EventID:  eventId,
	}

	err = h.DB.DeletePersonEvent(context.Background(), *pe)

	if err != nil {
		return c.JSON(http.StatusInternalServerError, err)
	}

	return c.NoContent(http.StatusOK)
}
