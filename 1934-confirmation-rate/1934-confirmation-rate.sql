# Write your MySQL query statement below
select user_id, coalesce(round(confirmation_rate,2),0) as confirmation_rate
from Signups left join (
    select user_id,count(
        case
            when action = "confirmed" then 1
        end
    )/count(action) as confirmation_rate
    from Confirmations
    group by user_id
) tmp
using (user_id);