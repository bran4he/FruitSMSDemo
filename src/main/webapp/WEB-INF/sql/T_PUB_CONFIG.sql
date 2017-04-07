drop table if exists T_PUB_CONFIG;
CREATE TABLE `T_PUB_CONFIG` (
`id` int(5) NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(20) NOT NULL,
`value` VARCHAR(20) NOT NULL,
`remark` VARCHAR(20) NOT NULL,
`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',
PRIMARY KEY(`id`)
); 
alter table T_PUB_CONFIG AUTO_INCREMENT=1;

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'ORDER_DAY_TO', '25', '最大的不可下订单日期');

/*以上初始化和建库脚步*/

select * from T_PUB_CONFIG;


