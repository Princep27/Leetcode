# Write your MySQL query statement below
select p.product_name as product_name, sum(o.unit) as unit
from Products p join Orders o using (product_id)
where month(order_date) = 2 and year(order_date) = 2020
group by p.product_id
having unit >= 100;