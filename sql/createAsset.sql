drop table `asset`;
use assetware;
create table `asset`
(
	`sr_no` varchar(20),
	`tag` varchar(20),
	`asset_type` varchar(20),
	`asset_status` varchar(20),
    `make` varchar(20),
    `model` varchar(20),
    `memory` varchar(20),
    `hard_disk` varchar(20),
    `store_code` varchar(20),
    `os` varchar(20),
    `invoice_no` varchar(20),
    `invoice_date` datetime,
    `po_no` varchar(20),
	`po_date` datetime,
	`remark` text,
	`created_on` datetime default now(),
	`created_by` varchar(20),
	`updated_on` datetime,
	`updated_by` varchar(20),
	
	primary key (sr_no)
);
commit;

drop table asset_user_map;

select * from asset;
update asset set os = 'Linux' where tag not in  ('kurla', 'powai');
insert into asset (sr_no, tag, make) values ('ser2','TG2','HP3') on DUPLICATE KEY UPDATE tag = 'TG2', make='HP3';

delete from asset where invoice_date is null;
delete from asset where sr_no in ('SER100','SER16','SER17','SER18');


INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER1','Kurla','Desktop','New','Mac','Air','8gb','500gbb','St1','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER2','Kurla','Desktop','In Use','Mac','Pro','8gb','500gbb','St2','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER3','Kurla','Laptop','Disposed','HP','MICRO','8gb','1 TB','St3','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER4','Andheri','Desktop','In Repair','Mac','Air','8gb','500gbb','St4','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER5','Andheri','Laptop','New','Mac','Air','8gb','500 GB','St5','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER6','Andheri','Laptop','New','Mac','Air','8gb','500gbb','St6','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER7','Ghatkopar','Server','New','Mac','Air','8gb','500gbb','St7','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER8','Ghatkopar','Laptop','New','Mac','Air','8gb','500gbb','St8','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER9','Ghatkopar','Desktop','New','Mac','Air','8gb','500gbb','St9','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER10','Ghatkopar','Desktop','New','Mac','Air','8gb','500gbb','St10','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER11','Powai','Desktop','New','Mac','Air','8gb','500gbb','St11','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER12','Powai','Desktop','New','Mac','Air','8gb','500gbb','St12','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER13','Powai','Desktop','New','Mac','Air','8gb','500gbb','St13','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER14','Powai','Desktop','New','Mac','Air','8gb','500gbb','St11','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER15','Powai','Desktop','New','Mac','Air','8gb','500gbb','St12','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER16','Powai','Desktop','New','Mac','Air','8gb','500gbb','St13','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER17','Powai','Desktop','New','Mac','Air','8gb','500gbb','St11','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER18','Powai','Desktop','New','Mac','Air','8gb','500gbb','St12','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER19','Powai','Desktop','New','Mac','Air','8gb','500gbb','St13','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER20','Powai','Desktop','New','Mac','Air','8gb','500gbb','St11','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER21','Powai','Desktop','New','Mac','Air','8gb','500gbb','St12','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);

INSERT INTO `asset` (`sr_no`,`tag`,`asset_type`,`asset_status`,`make`,`model`,`memory`,`hard_disk`,`store_code`,`os`,`invoice_no`,`invoice_date`,`po_no`,`po_date`,`remark`,`created_on`,`created_by`,`updated_on`,`updated_by`)
VALUES ('SER22','Powai','Desktop','New','Mac','Air','8gb','500gbb','St13','IT','INV1','2019-01-15 00:00:00','PO1','2019-01-15 00:00:00','This is line 1\r\nThis is line2','2019-09-28 22:38:47','System',NULL,NULL);


commit;

create table attachments
(
	sr_no varchar(20),
	file_name varchar(150)
);

select * from attachments;
select * from asset where sr_no = 'SER1';
update attachments set sr_no = 'SER7' where sr_no = 'SER18';

select a.sr_no, group_concat(att.file_name separator ',') as files from asset a left join attachments att on a.sr_no = att.sr_no
group by a.sr_no;
