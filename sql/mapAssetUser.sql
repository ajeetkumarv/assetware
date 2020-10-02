drop table asset_user_map;

create table asset_user_map
(
	`sr_no` varchar(20) not null,
	`emp_id` varchar(20) not null,
	`start_dt` datetime default now(),
	`end_dt` datetime,
	`created_by` varchar(20),
	`updated_by` varchar(20)
);