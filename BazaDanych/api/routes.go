package api

import (
	"net/http"

	"API/api/handlers"

	"github.com/labstack/echo/v4"
)

func SetRoutes(e *echo.Echo, h *handlers.Handler) {
	e.GET("/", func(c echo.Context) error {
		return c.String(http.StatusOK, "test")
	})

	people := e.Group("/people")
	people.GET("", h.GetPeople)
	people.POST("", h.CreatePerson)
	people.GET("/:id", h.GetPerson)
	people.PUT("/:id", h.UpdatePerson)
	people.DELETE("/:id", h.DeletePerson)

	people.GET("/:id/ranks", h.GetPersonRanks)
	people.POST("/:id/ranks", h.CreatePersonRank)
	people.DELETE("/:pid/ranks/:rid", h.DeletePersonRank)

	people.GET("/:id/sub_badges", h.GetPersonSubBadges)
	people.POST("/:id/sub_badges", h.CreatePersonSubBadge)
	people.DELETE("/:pid/sub_badges/:bid", h.DeletePersonSubBadge)

	people.GET("/:id/events", h.GetPersonEvents)
	people.POST("/:id/events", h.CreatePersonEvent)
	people.DELETE("/:pid/events/:eid", h.DeletePersonEvent)

	places := e.Group("/places")
	places.GET("", h.GetPlaces)
	places.POST("", h.CreatePlace)
	places.PUT("/:id", h.UpdatePlace)
	places.DELETE("/:id", h.DeletePlace)

	places.GET("/full", h.GetPlacesFull)
}
