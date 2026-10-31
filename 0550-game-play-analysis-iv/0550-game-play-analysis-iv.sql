# Write your MySQL query statement below
select round(
count(distinct case 
                    when isvalid = "true" then player_id 
                end
)/count(distinct(player_id)),2) as fraction

from (

        select player_id,event_date,first_login_date,
        case
            when timestampdiff(day,first_login_date,event_date) = 1 then "true"
            else "false"
        end as isvalid
        from Activity a1
        join (
            select player_id, min(event_date) as first_login_date
            from Activity
            group by  player_id
        ) a2
        using (player_id)
) tmpp;

