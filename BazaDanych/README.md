## Backend:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### Endpoints

| Endpoint                                                     | Description                                   | Status                                           | JSON                                                            |
|:-------------------------------------------------------------|:----------------------------------------------|:-------------------------------------------------|-----------------------------------------------------------------|
| `GET /people`                                                | Get all people                                | ![](https://img.shields.io/badge/Done-40A02B)    | [out](JSON.md#get-people---out)                                 |
| `POST /people`                                               | Add person                                    | ![](https://img.shields.io/badge/Done-40A02B)    | [in](JSON.md#post-people---in)/[out](JSON.md#post-people---out) |
| `GET /people/{id}`                                           | Get person {id}                               | ![](https://img.shields.io/badge/Done-40A02B)    | [out](JSON.md#get-peopleid---out)                               |
| `PUT /people/{id}`                                           | Update person {id}                            | ![](https://img.shields.io/badge/Done-40A02B)    | [in](JSON.md#put-people---in)                                   |
| `DELETE /people/{id}`                                        | Delete person {id}                            | ![](https://img.shields.io/badge/Done-40A02B)    | -                                                               |
| `GET /people/{id}/ranks`                                     | Get all ranks from person {id}                | ![](https://img.shields.io/badge/Done-40A02B)    | [out](JSON.md#get-peopleidranks---out)                          |
| `POST /people/{id}/ranks`                                    | Add rank to person {id}                       | ![](https://img.shields.io/badge/Done-40A02B)    | [in](JSON.md#post-peopleidranks---in)                           |
| `DELETE /people/{id1}/ranks/{id2}`                           | Remove rank {id2} from person {id1}           | ![](https://img.shields.io/badge/Done-40A02B)    | -                                                               |
| `GET /people/{id}/sub_badges`                                | Get all sub_badges from person {id}           | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /people/{id}/sub_badges`                               | Add sub_badge to person {id}                  | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /people/{id1}/sub_badges/{id2}`                      | Remove sub_badge {id2} from person {id1}      | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `GET /people/{id}/events`                                    | Get all events from person {id}               | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /people/{id}/events`                                   | Add event to person {id}                      | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /people/{id1}/events/{id2}`                          | Delete event {id2} from person {id1}          | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
|                                                              |                                               |                                                  |                                                                 |
| `GET /ranks`                                                 | Get all ranks                                 | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /ranks`                                                | Add rank                                      | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `GET /ranks/{id}`                                            | Get rank {id}                                 | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `PUT /ranks/{id}`                                            | Update rank {id}                              | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /ranks/{id}`                                         | Delete rank {id}                              | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
|                                                              |                                               |                                                  |                                                                 |
| `GET /badges`                                                | Get all badges                                | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /badges`                                               | Add badge                                     | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `GET /badges/{id}`                                           | Get badge {id}                                | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `PUT /badges/{id}`                                           | Update badge {id}                             | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /badges/{id}`                                        | Delete badge {id}                             | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /badges/{id}/sub_badges`                               | Add sub_badge to badge {id}                   | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /badges/{id1}/sub_badges/{id2}`                      | Delete sub_badge {id2} from badge {id1}       | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
|                                                              |                                               |                                                  |                                                                 |
| `GET /activities`                                            | Get all activities                            | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /activities`                                           | Add activity                                  | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `GET /activities/{id}`                                       | Get activity {id}                             | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `PUT /activities/{id}`                                       | Update activity {id}                          | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /activities/{id}`                                    | Delete activity {id}                          | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /activities/{id}/sub_activities`                       | Add sub_activity to activity {id}             | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /activities/{id1}/sub_activities/{id2}`              | Delete sub_activity {id2} from activity {id1} | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `POST /activities/{id1}/sub_activities/{id2}/events`         | Add event to sub_activity {id2}               | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |
| `DELETE /activities/{id1}/sub_activities/{id2}/events/{id3}` | Delete event {id3} from sub_activity {id2}    | ![](https://img.shields.io/badge/To%20Do-D20F39) |                                                                 |


## Run Locally

#### Dependencies:

- [Docker](https://www.docker.com/)
- [Goose](https://github.com/pressly/goose/releases) *(optional)*

#### Starting project:

Clone the project

```bash
  git clone https://github.com/sikoramodra/Historia
```

Go to the project directory

```bash
  cd Historia/BazaDanych
```

Create proper `.env` file

```bash
  cp .env.sample .env
```

Build docker image

```bash
  docker compose build
```

Run docker image

```bash
  docker compose up
```

#### **For pgadmin*

- Open http://localhost:5050/ in your browser
- login using `PG_EMAIL` and `PG_PASS` from your `.env` file
- Click on `Add New Server`
- Give it a name eg. `db`
- In connection tab you need to enter `address` and `password`
- `password` can be found in `.env` file as `PG_PASS`
- You can get `address` from docker by typing:
```bash
  docker inspect db -f "{{json .NetworkSettings.Networks }}" | tr ',' '\n' | grep "IPAddress"
```


## [DB Schema](https://dbdiagram.io/d/64fde3db02bd1c4a5e4a8afc)

