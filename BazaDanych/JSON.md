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
}
```

#### `PUT /people` - in
```json
{
  "name": "person321"
}
```
