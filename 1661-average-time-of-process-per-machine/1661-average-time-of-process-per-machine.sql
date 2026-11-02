# Write your MySQL query statement below
select machine_id, round(sum(a2.timestamp-a1.timestamp)/count(machine_id),3) as processing_time
from Activity a1 join Activity a2 using (machine_id,process_id)
where a1.activity_type = 'start' and a2.activity_type = 'end'
group by machine_id;