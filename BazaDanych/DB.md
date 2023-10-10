## SELECTS

#### Show all places
```sql
SELECT * FROM show_all_places;
```

#### Show all graves
```sql
SELECT * FROM show_all_graves;
```

#### Show people's graves
```sql
SELECT * FROM show_peoples_graves;
```

#### Show all ranks
```sql
SELECT * FROM show_all_ranks;
```

#### Show people's ranks
```sql
SELECT * FROM show_peoples_ranks;
```

#### Show all badges
```sql
SELECT * FROM show_all_badges;
```

#### Show people's badges
```sql
SELECT * FROM show_peoples_badges;
```

#### Show all badges in json
```sql
SELECT * FROM show_all_badges_json;
```

#### Show people's badges in json
```sql
SELECT * FROM show_peoples_badges_json;
```

#### Show all activity
```sql
SELECT * FROM show_all_activity;
```

#### Show people's activity
```sql
SELECT * FROM show_peoples_activity;
```

#### Show all activity in json
```sql
SELECT * FROM show_all_activity_json;
```

#### Show people's activity in json
```sql
SELECT * FROM show_peoples_activity_json;
```

#### Show main view
```sql
SELECT * FROM main_view;
```


## INSERTS

#### Add places
```sql
INSERT INTO places (name) VALUES ('Szczecin');

INSERT INTO cemetery (name, burial_place_id) VALUES ('Cmentarz centralny w Szczecinie', 1);
INSERT INTO quarter (name, cemetery_id) VALUES ('3D', 1);
INSERT INTO row (name, quarter_id) VALUES ('8', 1);
INSERT INTO grave (name, row_id) VALUES ('29', 1);
```

#### Add person
```sql
INSERT INTO people
    (name, inscription, other_names, code_names, birth_date, birth_place_id, death_date, death_place_id, grave_id, description, sources)
VALUES ('Anatol Makarenko', null, null, '{Tłok, Drut, Goździk}', '1919-02-12', 2, '2004-10-27', 1, 1, null, null);
```

#### Add rank
```sql
INSERT INTO ranks (name) VALUES ('Major');
INSERT INTO people_ranks (person_id, rank_id) VALUES (1, 1);
```

#### Add badge
```sql
INSERT INTO sub_badges (name) VALUES ('Krzyż Srebrny Orderu Virtuti Militari');
INSERT INTO badges (name, sub_badge_id) VALUES ('Krzyż Orderu Virtuti Militari', 1);
INSERT INTO people_badges (person_id, badge_id) VALUES (1, 1);
```

#### Add activity
```sql
INSERT INTO activity (name) VALUES ('1919-1939');
INSERT INTO sub_activity (name, activity_id) VALUES ('Powstania', 1);
INSERT INTO events (name, sub_activity_id) VALUES ('I Powstanie Śląskie (1919)', 1);
INSERT INTO people_activity (person_id, event_id) VALUES (1, 1);
```
