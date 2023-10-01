## Endpoints Proposal:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### Users (login)

| Endpoint             | Type     | Description        | Status                                        |
|:---------------------|:---------|:-------------------|:----------------------------------------------|
| `GET /users`         |          | Get all users      | ![](https://img.shields.io/badge/Done-40A02B) |
| `POST /users`        |          | Add user           | ![](https://img.shields.io/badge/Done-40A02B) |
| `GET /users/{id}`    | `number` | Get user with {id} | ![](https://img.shields.io/badge/Done-40A02B) |
| `PUT /users/{id}`    | `number` | Update user        | ![](https://img.shields.io/badge/Done-40A02B) |
| `DELETE /users/{id}` | `number` | Delete user        | ![](https://img.shields.io/badge/Done-40A02B) |


#### People

| Endpoint              | Type     | Description          | Status                                        | JSON                     |
|:----------------------|:---------|:---------------------|:----------------------------------------------|--------------------------|
| `GET /people`         |          | Get all people       | ![](https://img.shields.io/badge/Done-40A02B) | [out](#get-people---out) |
| `POST /people`        |          | Add person           | ![](https://img.shields.io/badge/Done-40A02B) | [in](#post-people---in)  |
| `GET /people/{id}`    | `number` | Get person with {id} | ![](https://img.shields.io/badge/Done-40A02B) |
| `PUT /people/{id}`    | `number` | Update person        | ![](https://img.shields.io/badge/Done-40A02B) |
| `DELETE /people/{id}` | `number` | Delete person        | ![](https://img.shields.io/badge/Done-40A02B) |


## Run Locally

#### Dependencies:

- [Docker](https://www.docker.com/)
- [Goose](https://github.com/pressly/goose/releases) *(optional)*

#### Starting project:

Clone the project

```bash
  git clone https://github.com/SevenPik/Historia
```

Go to the project directory

```bash
  cd Historia/BazaDanych
```

Create proper `.env` file

```bash
  mv .env.sample .env
```

Build docker image

```bash
  docker compose build
```

Run docker image

```bash
  docker compose up
```

## [DB Schema](https://dbdiagram.io/d/64fde3db02bd1c4a5e4a8afc)


## JSON Schema

#### `GET /people` - out
```json
[
  {
    "ID": 1,
    "Name": "person123"
  },
  {
    "ID": 2,
    "Name": "person321"
  }
]
```

#### `POST /people` - in
```json
{
  "name": "person123"
}
```

