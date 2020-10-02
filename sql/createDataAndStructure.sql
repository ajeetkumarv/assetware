[p[''
drop table `asset_type`;
create table `asset_type`
(
	`id` int not null auto_increment,
    `name` varchar(40) not null,
    
    primary key(id)
    
);

insert into `asset_type` values (1,'Desktop');
insert into `asset_type` values (2,'Keyboard');
insert into `asset_type` values (3,'Mouse');
insert into `asset_type` values (4,'Laptop');
insert into `asset_type` values (5,'Server');

select * from asset_type;

drop table `asset_status`;
create table `asset_status`
(
	`id` int not null auto_increment,
    `status` varchar(40) not null,
    
    primary key(id)
    
);

insert into `asset_status` values (1,'New');
insert into `asset_status` values (2,'In use');
insert into `asset_status` values (3,'Spare');
insert into `asset_status` values (4,'Disposed');
insert into `asset_status` values (5,'In repair');

select * from asset_status;

drop table `department`;
create table `department`
(
	`id` int not null auto_increment,
    `name` varchar(40) not null,
    
    primary key(id)
    
);

insert into `department` values (1,'IT');
insert into `department` values (2,'Store');
insert into `department` values (3,'Backoffice');

select * from department;