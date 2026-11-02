# Write your MySQL query statement below
select w2.id 
from Weather w1 cross join Weather w2
where timestampdiff(day,w1.recordDate,w2.recordDate) = 1 
and w2.temperature > w1.temperature;