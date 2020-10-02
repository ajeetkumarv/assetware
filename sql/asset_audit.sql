drop table `asset_audit`;

create table `asset_audit`
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
	`created_on` datetime,
	`created_by` varchar(20),
	`updated_on` datetime default now(),
	`updated_by` varchar(20)
);

select * from `asset_audit`;

drop trigger audit_asset;

create trigger audit_asset before update on asset for each row
    insert into asset_audit
        set sr_no = OLD.sr_no,
        tag = OLD.tag,
        asset_type = OLD.asset_type,
        asset_status = OLD.asset_status,
        make = OLD.make,
        model = OLD.model,
        memory = OLD.memory,
        hard_disk = OLD.hard_disk,
        store_code = OLD.store_code,
        os = OLD.os,
        invoice_no = OLD.invoice_no,
        invoice_date = OLD.invoice_date,
        po_no = OLD.po_no,
        po_date = OLD.po_date,
        remark = OLD.remark,
        created_on = OLD.created_on,
        created_by = OLD.created_by,
        updated_by = NEW.updated_by;


select * from `asset_audit`;
select * from `asset` where sr_no = 'SER1';

update `asset` set asset_status = 'In Repair', updated_by = 'System' where sr_no = 'SER1';

select * from (	select * from `asset` a where sr_no = 'SER1' union select * from `asset_audit` aa where sr_no = 'SER1') a order by -updated_on;


