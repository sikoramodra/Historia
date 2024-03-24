## Backend:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### Endpoints

| Endpoint                                | Description                              | Status                                        | JSON                                                            |
|:----------------------------------------|:-----------------------------------------|:----------------------------------------------|-----------------------------------------------------------------|
| `GET /people`                           | Get all people                           | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-people---out)                                 |
| `POST /people`                          | Add person                               | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#post-people---in)/[out](JSON.md#post-people---out) |
| `GET /people/{id}`                      | Get person {id}                          | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-peopleid---out)                               |
| `PUT /people/{id}`                      | Update person {id}                       | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#put-people---in)                                   |
| `DELETE /people/{id}`                   | Delete person {id}                       | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /people/{id}/ranks`                | Get all ranks from person {id}           | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-peopleidranks---out)                          |
| `POST /people/{id}/ranks`               | Add rank to person {id}                  | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#post-peopleidranks---in)                           |
| `DELETE /people/{id1}/ranks/{id2}`      | Remove rank {id2} from person {id1}      | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /people/{id}/sub_badges`           | Get all sub_badges from person {id}      | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-peopleidsub_badges---out)                     |
| `POST /people/{id}/sub_badges`          | Add sub_badge to person {id}             | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#post-peopleidsub_badges---in)                      |
| `DELETE /people/{id1}/sub_badges/{id2}` | Remove sub_badge {id2} from person {id1} | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /people/{id}/events`               | Get all events from person {id}          | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-peopleidevents---out)                         |
| `POST /people/{id}/events`              | Add event to person {id}                 | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#post-peopleidevents---in)                          |
| `DELETE /people/{id1}/events/{id2}`     | Delete event {id2} from person {id1}     | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /places`                           | Get all places                           | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-places---out)                                 |
| `POST /places`                          | Add place                                | ![](https://img.shields.io/badge/Done-40A02B) | [in](JSON.md#post-places---in)                                  |
| `DELETE /places/{id}`                   | Delete place {id}                        | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /places/full`                      | Get all burial places                    | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-placesfull---out)                             |
| `GET /places/cemeteries`                | Get all cemeteries                       | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `POST /places/cemeteries`               | Add cemetery                             | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `DELETE /places/cemeteries/{id}`        | Delete cemetery {id}                     | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /places/quarters`                  | Get all quarters                         | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `POST /places/quarters`                 | Add quarter                              | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `DELETE /places/quarters/{id}`          | Delete quarter {id}                      | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /places/rows`                      | Get all rows                             | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `POST /places/rows`                     | Add row                                  | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `DELETE /places/rows/{id}`              | Delete row {id}                          | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /places/graves`                    | Get all graves                           | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `POST /places/graves`                   | Add grave                                | ![](https://img.shields.io/badge/Test-FE640B) |                                                                 |
| `DELETE /places/graves/{id}`            | Delete grave {id}                        | ![](https://img.shields.io/badge/Done-40A02B) | -                                                               |
| `GET /activities/full`                  | Get all activities-events                | ![](https://img.shields.io/badge/Done-40A02B) | [out](JSON.md#get-activitiesfull---out)                         |




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

