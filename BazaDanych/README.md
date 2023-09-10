## Endpoints Proposal:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### Users (login)

| Endpoint             | Type     | Description        | Status                                       |
|:---------------------|:---------|:-------------------|:---------------------------------------------|
| `GET /users`         |          | Get all users      | ![](https://img.shields.io/badge/WIP-DF8E1D) |
| `POST /users`        |          | Add user           | ![](https://img.shields.io/badge/WIP-DF8E1D) |
| `GET /users/{id}`    | `number` | Get user with {id} | ![](https://img.shields.io/badge/WIP-DF8E1D) |
| `PUT /users/{id}`    | `number` | Update user        | ![](https://img.shields.io/badge/WIP-DF8E1D) |
| `DELETE /users/{id}` | `number` | Delete user        | ![](https://img.shields.io/badge/WIP-DF8E1D) |


#### People

| Endpoint              | Type     | Description          | Status                                        |
|:----------------------|:---------|:---------------------|:----------------------------------------------|
| `GET /people`         |          | Get all people       | ![](https://img.shields.io/badge/Done-40A02B) |
| `POST /people`        |          | Add person           | ![](https://img.shields.io/badge/Done-40A02B) |
| `GET /people/{id}`    | `number` | Get person with {id} | ![](https://img.shields.io/badge/Done-40A02B) |
| `PUT /people/{id}`    | `number` | Update person        | ![](https://img.shields.io/badge/Done-40A02B) |
| `DELETE /people/{id}` | `number` | Delete person        | ![](https://img.shields.io/badge/Done-40A02B) |


## DB: Postgres

#### Schema: ![](https://img.shields.io/badge/To%20Do-D20F39)

## Run Locally

#### Dependencies:

- [Docker](https://www.docker.com/)
- [Goose](https://github.com/pressly/goose/releases)

#### Starting project:

Clone the project

```bash
  git clone https://github.com/SevenPik/Historia
```

Go to the project directory

```bash
  cd Historia/BazaDanych
```

Build docker image

```bash
  docker compose build
```

Run docker image

```bash
  docker compose up
```

Migrate the database

```bash
  goose -dir sql/schema postgres postgres://USERNAME:PASSWORD@localhost:5432/DB_NAME up 
```

