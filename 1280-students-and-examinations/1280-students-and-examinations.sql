# Write your MySQL query statement below
select std.student_id, std.student_name, sbj.subject_name, coalesce(cnttable.cnt,0) as attended_exams
from Students std cross join Subjects sbj
left join (
    select *, count(*) as cnt
    from Examinations
    group by student_id,subject_name
) cnttable
on std.student_id = cnttable.student_id and sbj.subject_name = cnttable.subject_name
order by std.student_id, sbj.subject_name;
