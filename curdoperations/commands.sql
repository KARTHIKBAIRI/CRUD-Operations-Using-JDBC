-- creating database-- 

create database clg;
drop database clg;
create table student( id int, name varchar(20), email varchar(50));
use clg;
desc student;
select * from student;
insert into student(id,name,email) values(1,'karthik','karthikbairi@gmail.com'),
(2,'rahul','rahulbade@gmail.com');
update student set name = 'simha' where id = 2;
delete from student where name = 'simha';
truncate table student;
drop table student;
alter table student add age int;
alter table student drop column age;
alter table student modify name varchar(30);
create table employee(id int primary key auto_increment,name varchar(20) not null,
email varchar(50) not null unique,
age int check (age>18), state varchar(20) default 'india');
drop table employee;
desc employee;
insert into employee values(1,'karthik','kartihikbairi@gmail.com',20,'uk'),
(2,'simha','simha@gmail.com',21,'usa');
insert into employee(name,email,age) values('hari','harikbairi@gmail.com',20),
('subash','subash@gmail.com',21);
select * from employee;
select count(age) from employee where age > 20 && name='simha';
select * from employee where not age = 20;
select * from employee limit 3;
select * from employee order by age desc;
select min(age) from employee;
-- max,sum,avg,count --
select avg(age) from employee;
select * from employee where name like 's%';
select * from employee where name like '_i%';
select * from employee where name like '%i%';


