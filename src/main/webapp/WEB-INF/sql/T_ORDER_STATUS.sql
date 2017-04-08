drop table if exists T_ORDER_STATUS;
CREATE TABLE `T_ORDER_STATUS` (
`id` int(5) NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(20) NOT NULL,
`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',
PRIMARY KEY(`id`)
); 
alter table T_ORDER_STATUS AUTO_INCREMENT=1;

insert into T_ORDER_STATUS (id, name) values (1,'待派送');
insert into T_ORDER_STATUS (id, name) values (2,'派送中');
insert into T_ORDER_STATUS (id, name) values (3,'派送成功');
insert into T_ORDER_STATUS (id, name) values (4,'用户取消');
insert into T_ORDER_STATUS (id, name) values (5,'派送失败');

/*以上初始化和建库脚步*/


select * from T_ORDER_STATUS;

