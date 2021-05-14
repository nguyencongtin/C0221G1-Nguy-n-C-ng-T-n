use quan_ly_sinh_vien;
-- Hien thi tat ca cac sinh vien co ten bat dau bang ky tu ‘h’
select *
from student
where student_name like "h%";

-- Hien thi cac thong tin lop hoc co thoi gian bat dau vao thang 12.
select *
from class
where month(startdate)=12;

-- Hien thi tat ca cac thong tin mon hoc co credit trong khoang tu 3-5.
select *
from `subject`
where credit between 3 and 5;

-- Thay doi ma lop (class_id) cua sinh vien co ten ‘Hung’ la 2.
SET SQL_SAFE_UPDATES = 0;
update student
set class_id = 2
where student_name="Hung";

-- Hien thi cac thong tin: student_name, sub_name, mark. Du lieu sap xep theo diem thi (mark) giam dan. neu trung sap theo ten tang dan.
select s.student_name, sub.sub_name, m.*
from student s join mark m on s.student_id = m.student_id 
join `subject` sub on m.sub_id = sub.sub_id
order by m.mark desc, s.student_name asc;