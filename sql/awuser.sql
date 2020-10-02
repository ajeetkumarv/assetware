create table awuser
(
	username varchar(20),
	password varchar(25) binary,
	email varchar(40),
	
	primary key(username)
);

insert into awuser values ('admin','adminpass','admin@asset.com');
insert into awuser values ('user','userpass','user@asset.com');