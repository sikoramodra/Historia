FROM golang

WORKDIR /api

RUN go install github.com/cosmtrek/air@latest

COPY . .

RUN go mod tidy
