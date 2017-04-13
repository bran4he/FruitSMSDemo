drop table if exists T_ORDER_DETAIL;
CREATE TABLE `T_ORDER_DETAIL` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`fruitId`	int(10) NOT NULL,
`fruitName`	VARCHAR(100) NOT NULL,

`orderId` int(5) NOT NULL,
`orderUnit` int(10) NOT NULL,

`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',

PRIMARY KEY(`id`),
foreign key(`orderId`) references T_ORDER(`id`), 
foreign key(`fruitId`) references T_FRUIT_CONFIG(`id`)
);
alter table T_ORDER AUTO_INCREMENT=1;

/*以上初始化和建库脚步*/

insert into T_ORDER_DETAIL 
	values
(null, 1, 'apple', 1, 5,'2017-04-02', 'admin','2017-04-02', 'admin');

select * from T_ORDER_DETAIL;

