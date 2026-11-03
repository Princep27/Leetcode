# Write your MySQL query statement below
select dept as Department, emp as Employee, salary as Salary
from (

    select d.name as dept, e.name as emp, e.salary as salary, 
    dense_rank() over (partition by e.departmentId order by salary desc) as rnk
    from Department d join Employee e on e.departmentId = d.id
) tmp
where rnk <= 3;