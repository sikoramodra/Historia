-- name: GetBadges :many
SELECT b.id                                                      AS id,
       b.name                                                    AS name,
       json_agg(json_build_object('id', sb.id, 'name', sb.name)) AS sub_badges
FROM sub_badge sb
         LEFT JOIN badge b on sb.badge_id = b.id
GROUP BY b.id;