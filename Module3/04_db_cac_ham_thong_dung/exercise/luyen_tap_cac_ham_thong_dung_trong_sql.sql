use quan_ly_sinh_vien;
select * from `subject` s
group by sub_id,sub_name
having s.credit >= all(select credit from `subject`);

select s.sub_name,m.mark
from subject s
join mark m on s.sub_id = m.sub_id
group by s.sub_name,m.mark
having m.mark >= all (select mark from mark group by mark.sub_id);

select * , avg(m.mark)
from student s 
left join mark m on s.student_id = m.student_id
group by s.student_id
order by m.mark desc;
select * from mark;
