drop table if exists T_ORDER;
CREATE TABLE `T_ORDER` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`statusId` int(5) NOT NULL,
`assignId` int(10) NOT NULL,
`fruitId`	int(10) NOT NULL,
`fruitName`	VARCHAR(100) NOT NULL,

`orderUnit` int(10) NOT NULL,

`planDeliveryDate` timestamp NOT NULL,
`address` VARCHAR(100) NOT NULL,
`contactName` VARCHAR(100) NOT NULL,
`contactPhone` VARCHAR(100) NOT NULL,

`deliveryDate` timestamp,
`deliveryBy` VARCHAR(100),
`deliveryRemark` VARCHAR(100),

`finishDate` timestamp,
`finishBy` VARCHAR(100),
`finishRemark` VARCHAR(100),

`remark` VARCHAR(200),
`extendData` VARCHAR(1000),

`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',

PRIMARY KEY(`id`),
foreign key(`statusId`) references T_ORDER_STATUS(`id`), 
foreign key(`assignId`) references T_ASSIGN(`id`),
foreign key(`fruitId`) references T_FRUIT_CONFIG(`id`)
);
alter table T_ORDER AUTO_INCREMENT=1;

insert into T_ORDER
	values
(	null, 2, 1, 1, 'apple0', 5,
	'2017-04-02', '中国上海市淞沪路270号创智天地广场3号楼','王小二','15888888888',
	'2017-04-12', 'JD李大宝','货到付款',
	'2017-04-13', '张小妹', '放在前台',
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

select * from T_ORDER;

select oo.*, os.name as statusValue, aa.weecharOpenid as weecharOpenid
	from T_ORDER oo 
	join T_ORDER_STATUS os on oo.statusId = os.id 
	join T_ASSIGN aa on oo.assignId = aa.id
WHERE weecharOpenid = 'QWERTYUIOP'
AND oo.statusId = 1
order by updateDate;

select oo.*, os.name as statusValue , aa.weecharOpenid as weecharOpenid from T_ORDER oo join T_ASSIGN aa on oo.assignId = aa.id join T_ORDER_STATUS os on oo.statusId = os.id WHERE weecharOpenid='QWERTYUIOP' AND  oo.statusId = 2 order by updateDate;
