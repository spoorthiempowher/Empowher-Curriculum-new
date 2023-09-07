-- Database: College_Students

-- DROP DATABASE IF EXISTS "College_Students";

-- CREATE DATABASE "College_Students"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'English_United States.1252'
--     LC_CTYPE = 'English_United States.1252'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

/* Section 1 DDL statements */	
	
Create table Student 
(student_id INT,
student_name varchar(30),
student_age INT,
student_address varchar(25),
student_phone_no varchar(20)

)

select * from student

/* Alter table syntaxes and examples */

alter table student alter column student_name SET NOT NULL;
alter table student alter column student_name drop not null;
alter table student add email  varchar(50);
alter table student rename column email to Email_ID
alter table student drop column Email_Id


Truncate table student ;
Drop table student ;

/* Section 2 DML statements */

Insert into student values 
( 1, 'Sushmita', 25,'Bangalore',785698453),
(2, 'Ajay',26,'Bangalore Urban', 997865643),
(3,'Aishwarya', 30,'Bangalore Rural',987645231),
(4,'Varun',28,'Bangalore North',785634123)

Insert into student  
VALUES (5,'Zacarius', 31,'Pune',784567342)
RETURNING student_phone_no --*

Update student set student_name  = 'Varun Dhawan' where student_name = 'Varun' -- forgetting where clause will cause all rows to be updated 
Update student set student_Age = 30, student_phone_no = 785473924 where student_name = 'Varun'

Delete from student where student_id = 5
Delete from student 

/* Section 3 Distinct, Order By , ASC , DESC , LIMIT */

select * from student order by student_name desc --asc 
select * from student order by student_name desc , student_id

select distinct  * from student 
select distinct (student_name) from student 

select * from student limit 2
select * from student order by student_name limit 3


