## Endpoints Proposal:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### Users (login)

| Endpoint             | Type     | Description        | Status                                           |
|:---------------------|:---------|:-------------------|:-------------------------------------------------|
| `GET /users`         |          | Get all users      | ![](https://img.shields.io/badge/Test-FE640B)    |
| `POST /users/add`    |          | Add user           | ![](https://img.shields.io/badge/To%20Do-D20F39) |
| `GET /users/{id}`    | `number` | Get user with {id} | ![](https://img.shields.io/badge/Test-FE640B)    |
| `PUT /users/{id}`    | `number` | Update user        | ![](https://img.shields.io/badge/To%20Do-D20F39) |
| `DELETE /users/{id}` | `number` | Delete user        | ![](https://img.shields.io/badge/To%20Do-D20F39) |


#### People

| Endpoint              | Type     | Description          | Status                                           |
|:----------------------|:---------|:---------------------|:-------------------------------------------------|
| `GET /people`         |          | Get all people       | ![](https://img.shields.io/badge/WIP-DF8E1D)     |
| `POST /people/add`    |          | Add person           | ![](https://img.shields.io/badge/Test-FE640B)    |
| `GET /people/{id}`    | `number` | Get person with {id} | ![](https://img.shields.io/badge/WIP-DF8E1D)     |
| `PUT /people/{id}`    | `number` | Update person        | ![](https://img.shields.io/badge/To%20Do-D20F39) |
| `DELETE /people/{id}` | `number` | Delete person        | ![](https://img.shields.io/badge/To%20Do-D20F39) |


## DB Proposal: Postgres (pgx + sqlc)

#### Schema: ![](https://img.shields.io/badge/To%20Do-D20F39)
