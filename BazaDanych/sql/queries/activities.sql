-- name: GetActivitiesFull :many
SELECT json.a_id                                                                                  AS id,
       json.a_name                                                                                AS name,
       json_agg(json_build_object('id', json.sa_id, 'name', json.sa_name, 'events', json.events)) AS sub_activities
FROM (SELECT a.id                                                    AS a_id,
             a.name                                                  AS a_name,
             sa.id                                                   AS sa_id,
             sa.name                                                 AS sa_name,
             json_agg(json_build_object('id', e.id, 'name', e.name)) AS events
      FROM event e
               LEFT JOIN public.sub_activity sa on e.sub_activity_id = sa.id
               LEFT JOIN public.activity a on sa.activity_id = a.id
      GROUP BY sa.id, a.id) json
GROUP BY json.a_id, json.a_name;
