## Endpoints Proposal:

### Statuses

| ![](https://img.shields.io/badge/To%20Do-D20F39) | ![](https://img.shields.io/badge/Test-FE640B) | ![](https://img.shields.io/badge/WIP-DF8E1D) | ![](https://img.shields.io/badge/Done-40A02B) |
|:-------------------------------------------------|:----------------------------------------------|:---------------------------------------------|:----------------------------------------------|


#### People

| Endpoint              | Type     | Description          | Status                                        | JSON                       |
|:----------------------|:---------|:---------------------|:----------------------------------------------|----------------------------|
| `GET /people`         |          | Get all people       | ![](https://img.shields.io/badge/Test-FE640B) | [out](#get-people---out)   |
| `POST /people`        |          | Add person           | ![](https://img.shields.io/badge/Test-FE640B) | [in](#post-people---in)    |
| `GET /people/{id}`    | `number` | Get person with {id} | ![](https://img.shields.io/badge/Test-FE640B) | [out](#get-peopleid---out) |
| `PUT /people/{id}`    | `number` | Update person        | ![](https://img.shields.io/badge/Test-FE640B) | [in](#put-people---in)     |
| `DELETE /people/{id}` | `number` | Delete person        | ![](https://img.shields.io/badge/Test-FE640B) | -                          |


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
    "id": 1,
    "name": "person123"
  },
  {
    "id": 2,
    "name": "person321"
  }
]
```

#### `POST /people` - in
```json
{
  "name": "person123"
}
```

#### `GET /people/{id}` - out
```json
{
  "id": 1,
  "name": "person123"
}
```

#### `PUT /people` - in
```json
{
  "name": "person321"
}
```


## activities
```json
{
  "activity": {
    "Zabory": [
      "Liga Narodowa",
      "Liga Polska",
      "..."
    ],
    "WWI": {
      "Formacje": [
        "I Kompania Kadrowa",
        "Legiony Polskie - I Brygada",
        "..."
      ],
      "Bitwy": [
        "Reims (1914)",
        "Arras (1915)",
        "..."
      ]
    },
    "1919-1939": [
      "Wojna polsko-bolszewicka (1919-1921)",
      "I Powstanie Śląskie (1919)",
      "..."
    ],
    "WWII": "?"
  }
}
```

#### `Zabory`, `WWI`, `1919-1939`, `WWII` - activity
#### `Formacje`, `Bitwy` - sub_activity
