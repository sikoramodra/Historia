## Endpoints Proposal:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### People

| Endpoint              | Type     | Description          | Status                                        | JSON                              |
|:----------------------|:---------|:---------------------|:----------------------------------------------|-----------------------------------|
| `GET /people`         |          | Get all people       | ![](https://img.shields.io/badge/Test-FE640B) | [out](JSON.md#get-people---out)   |
| `POST /people`        |          | Add person           | ![](https://img.shields.io/badge/Test-FE640B) | [in](JSON.md#post-people---in)    |
| `GET /people/{id}`    | `number` | Get person with {id} | ![](https://img.shields.io/badge/Test-FE640B) | [out](JSON.md#get-peopleid---out) |
| `PUT /people/{id}`    | `number` | Update person        | ![](https://img.shields.io/badge/Test-FE640B) | [in](JSON.md#put-people---in)     |
| `DELETE /people/{id}` | `number` | Delete person        | ![](https://img.shields.io/badge/Test-FE640B) | -                                 |


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

