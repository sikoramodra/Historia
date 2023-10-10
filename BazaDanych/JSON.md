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
