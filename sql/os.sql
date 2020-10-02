create table os
(
	id int auto_increment primary key,
	os varchar(20) unique not null
);
select * from os;
insert into os (os) values ('Windows 7'), ('Windows 8'), ('Windows Vista'), ('Windows 10'), ('MacOS'), ('Linux');