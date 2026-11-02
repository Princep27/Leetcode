# Write your MySQL query statement below
select person_name
from (
    select person_name, sum(weight) over (order by turn) as sum
    from Queue
) tmp
where sum <= 1000
order by sum desc
limit 1;