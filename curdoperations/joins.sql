create database demo;
use demo;
create table employee(emp_id int primary key,emp_name varchar(20) not null,emp_email varchar(30)
not null unique);
create table salary(emp_id int,dept varchar(20) not null,salary int not null);
insert into employee values(1,"stud1","abc1@gmail.com");
insert into employee values(2,"stud2","abc2@gmail.com");
insert into employee values(3,"stud3","abc3@gmail.com");
insert into employee values(4,"stud4","abc4@gmail.com");
insert into employee values(5,"stud5","abc5@gmail.com");
insert into salary values (3,"cse",23000),(4,"ece",25000),(5,"cse",30000),(7,"ece",20000);
select * from employee;
select * from salary;
select employee.emp_id,employee.emp_name,employee.emp_email,salary.dept,salary.salary from
employee inner join salary on(employee.emp_id = salary.emp_id);
select employee.emp_id,employee.emp_name,employee.emp_email,salary.dept,salary.salary from
employee left outer join salary on(employee.emp_id = salary.emp_id);
select employee.emp_id,employee.emp_name,employee.emp_email,salary.dept,salary.salary from
employee right join salary on(employee.emp_id = salary.emp_id);
select * from employee right join salary on(employee.emp_id = salary.emp_id) union all
select * from employee left join salary on(employee.emp_id = salary.emp_id);












