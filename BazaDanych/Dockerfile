FROM golang

WORKDIR /api

RUN go install github.com/cosmtrek/air@latest
RUN go install github.com/sqlc-dev/sqlc/cmd/sqlc@latest

COPY . .

RUN sqlc generate

RUN go mod tidy
