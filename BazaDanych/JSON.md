## JSON Schema

#### `GET /people` - out
```json
[
  {
    "id": 1,
    "name": "Person1",
    "inscription": "Inscription for Person1",
    "other_names": [
      "Person_1",
      "Person_One"
    ],
    "code_names": [
      "P1",
      "PO"
    ],
    "birth_date": "1980-01-01",
    "birth_place": "Szczecin",
    "death_date": "2020-01-01",
    "death_place": "Szczecin",
    "burial_place": "Szczecin",
    "cemetery": "Cmentarz centralny w Szczecinie",
    "quarter": "3D",
    "row": "4",
    "grave": "21",
    "ranks": [
      "Major"
    ],
    "badges": [
      {
        "name": "Krzyż Orderu Virtuti Militari",
        "sub_badges": [
          "Krzyż Srebrny Orderu Virtuti Militari"
        ]
      },
      {
        "name": "Krzyż walecznych",
        "sub_badges": []
      }
    ],
    "activity": [
      {
        "name": "Zabory",
        "sub_activity": [
          {
            "name": "Organizacje",
            "events": [
              "Liga Narodowa"
            ]
          }
        ]
      },
      {
        "name": "WWI",
        "sub_activity": [
          {
            "name": "Formacje",
            "events": [
              "I Kompania Kadrowa",
              "Legiony Polskie - I Brygada"
            ]
          },
          {
            "name": "Bitwy",
            "events": [
              "Reims (1914)"
            ]
          }
        ]
      }
    ],
    "description": "Description for Person1",
    "sources": "Source for Person1"
  },
  {
    "id": 2,
    "name": "Person2",
    "inscription": "Inscription for Person2",
    "other_names": [
      "Person_2",
      "Person_Two"
    ],
    "code_names": [
      "P2",
      "PT"
    ],
    "birth_date": "1985-01-01",
    "birth_place": "Szczecin",
    "death_date": "2021-01-01",
    "death_place": "Szczecin",
    "burial_place": "Szczecin",
    "cemetery": "Cmentarz centralny w Szczecinie",
    "quarter": null,
    "row": null,
    "grave": null,
    "ranks": [
      "Admirał",
      "Komisarz "
    ],
    "badges": [
      {
        "badge": "Krzyż Partyzancki",
        "sub_badges": []
      },
      {
        "badge": "Krzyż Zasługi",
        "sub_badges": [
          "Złoty Krzyż Zasługi",
          "Srebrny Krzyż Zasługi"
        ]
      }
    ],
    "activity": [
      {
        "name": "WWI",
        "sub_activity": [
          {
            "name": "Bitwy",
            "events": [
              "Pakosław (1915)",
              "Czeremcha (1915)",
              "Rokitna (1915)"
            ]
          },
          {
            "name": "Operations",
            "events": []
          }
        ]
      }
    ],
    "description": "Description for person2",
    "sources": "Source for person2"
  },
  ...
]
```

#### `POST /people` - in
```json
{
  "name": "person123",
  "inscription": "Inscription for Person123",
  "other_names": [
    "Person_123",
    "Person_321"
  ],
  "code_names": [
    "P123",
    "P321"
  ],
  "birth_date": "1945-01-01",
  "birth_place": 1,
  "death_date": "1995-01-01",
  "death_place": null,
  "grave": 1,
  "description": "Description for person123",
  "sources": "Source for person123"
}
```

#### `POST /people` - out
```json
    2
```
*returns id


#### `GET /people/{id}` - out
```json
{
  "id": 2,
  "name": "Person2",
  "inscription": "Inscription for Person2",
  "other_names": [
    "Person_2",
    "Person_Two"
  ],
  "code_names": [
    "P2",
    "PT"
  ],
  "birth_date": "1985-01-01",
  "birth_place": "Szczecin",
  "death_date": "2021-01-01",
  "death_place": "Szczecin",
  "burial_place": "Szczecin",
  "cemetery": "Cmentarz centralny w Szczecinie",
  "quarter": null,
  "row": null,
  "grave": null,
  "ranks": [
    "Admirał",
    "Komisarz"
  ],
  "badges": [
    {
      "badge": "Krzyż Partyzancki",
      "sub_badges": []
    },
    {
      "badge": "Krzyż Zasługi",
      "sub_badges": [
        "Złoty Krzyż Zasługi",
        "Srebrny Krzyż Zasługi"
      ]
    }
  ],
  "activity": [
    {
      "name": "WWI",
      "sub_activity": [
        {
          "name": "Bitwy",
          "events": [
            "Pakosław (1915)",
            "Czeremcha (1915)",
            "Rokitna (1915)"
          ]
        },
        {
          "name": "Operations",
          "events": []
        }
      ]
    }
  ],
  "description": "Description for person2",
  "sources": "Source for person2"
}
```

#### `PUT /people` - in
```json
{
  "name": "person123",
  "inscription": "Inscription for Person123",
  "other_names": [
    "Person_123",
    "Person_321"
  ],
  "code_names": [
    "P123",
    "P321"
  ],
  "birth_date": "1945-01-01",
  "birth_place": 1,
  "death_date": "1995-01-01",
  "death_place": null,
  "grave": 1,
  "description": "Description for person123",
  "sources": "Source for person123"
}
```

#### `GET /people/{id}/ranks` - out
```json
[
  {
    "id": 1,
    "rank": "Admirał"
  },
  {
    "id": 2,
    "rank": "Komisarz"
  }
]
```

#### `POST /people/{id}/ranks` - in
```json
{
  "rank_id": 1
}
```

#### `GET /people/{id}/sub_badges` - out
```json
[
  {
    "id": 1,
    "sub_badge": "Złoty Krzyż Zasługi",
    "badge": "Krzyż Zasługi"
  },
  {
    "id": 2,
    "sub_badge": "Srebrny Krzyż Zasługi",
    "badge": "Krzyż Zasługi"
  },
  {
    "id": 3,
    "sub_badge": "Krzyż Srebrny Orderu Virtuti Militari",
    "badge": "Krzyż Orderu Virtuti Militari"
  }
]
```

#### `POST /people/{id}/sub_badges` - in
```json
{
  "sub_badge_id": 5
}
```

#### `GET /people/{id}/events` - out
```json
[
  {
    "id": 1,
    "event_name": "Powstanie warszawskie",
    "sub_activity_name": "Powstania",
    "activity_name": "WWII"
  },
  {
    "id": 2,
    "event_name": "Reims (1914)",
    "sub_activity_name": "Battles",
    "activity_name": "WWI"
  },
  {
    "id": 3,
    "event_name": "I Kompania Kadrowa",
    "sub_activity_name": "Formations",
    "activity_name": "WWI"
  }
]

```

#### `POST /people/{id}/events` - in
```json
{
  "event_id": 2
}
```

#### `GET /places` - out
```json
[
  {
    "id": 1,
    "name": "Szczecin"
  },
  {
    "id": 2,
    "name": "Warszawa"
  }
]
```

#### `POST /places` - in
```json
  "Warszawa"
```

#### `GET /places/full` - out
```json
[
  {
    "id": null,
    "grave": null,
    "row": null,
    "quarter": null,
    "cemetery": "Cmentarz centralny w Szczecinie",
    "place": "Szczecin"
  },
  {
    "id": 1,
    "grave": "test123",
    "row": "test123",
    "quarter": "test123",
    "cemetery": "Cmentarz centralny w Szczecinie",
    "place": "Szczecin"
  },
  {
    "id": null,
    "grave": null,
    "row": null,
    "quarter": null,
    "cemetery": null,
    "place": "Szczecin"
  }
]
```

