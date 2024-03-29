use quan_ly_sinh_vien;
select address, count(student_id) as 'so_luong_hoc_vien'
from student
group by address;

select s.student_id,s.student_name, avg(mark)
from student s join mark m on s.student_id = m.student_id
group by s.student_id, s.student_name;

select s.student_id,s.student_name, avg(mark)
from student s join Mark M on s.student_id = m.student_id
group by s.student_id, s.student_name
having avg(mark) > 15;

select s.student_id,s.student_name, avg(mark)
from student s join Mark M on s.student_id = m.student_id
group by s.student_id, s.student_name
having avg(mark) >= all (select avg(mark) from mark group by mark.student_id);