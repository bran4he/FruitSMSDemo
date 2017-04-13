drop table if exists T_FRUIT_CONFIG;
CREATE TABLE `T_FRUIT_CONFIG` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`fruitName` VARCHAR(100) NOT NULL,
`fruitArea` VARCHAR(100) NOT NULL,

`fruitMonth` timestamp NOT NULL,
`maxOrderDay` timestamp NOT NULL,

`maxOrderNum` int(10) NOT NULL,
`maxProvNum` int(10) NOT NULL,

`remark` VARCHAR(200),
`extendData` VARCHAR(1000),

`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',

PRIMARY KEY(`id`)
);
alter table T_FRUIT_CONFIG AUTO_INCREMENT=1;

insert into T_FRUIT_CONFIG 
	values 
(1, 'apple', 'shanghai','2017-03-02', '2017-04-25',5, 99, 
	'this is remark', '{name:"tom"}','2017-03-02', 'admin','2017-03-02', 'admin');
insert into T_FRUIT_CONFIG 
	values 
(null, '香蕉', 'shanghai','2017-02-02', '2017-02-25',5, 99,
	'this is remark', '{name:"jack"}','2017-02-02', 'admin','2017-02-02', 'admin');
/*以上初始化和建库脚步*/

select * from T_FRUIT_CONFIG;

select * from T_FRUIT_CONFIG where date_format(fruitMonth,'%Y-%m')=date_format(now(),'%Y-%m');



