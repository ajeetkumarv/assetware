drop table `users`;
select * from `users`;
create table `users`
(
	emp_id varchar(20) not null,
	name varchar(30),
    username varchar(20),
	dept varchar(20),
    designation varchar(30),
	contact_no varchar(20),
	email varchar(40),
    location varchar(50),
	remark text,
	
    created_on datetime default now(),
    created_by varchar(40),
    
	primary key(emp_id)
);

insert into `users` (name, username, dept, designation, emp_id, contact_no, email, remark, created_by) values ('ajeet', 'data management', 'emp1', '1234', 'e1@office.com' , 'First remark','sql');


create table contact 
(
	id int not null,
	contact_no varchar(20) not null unique
);

create table email 
(
	id int not null,
	email varchar(25) not null unique
);

