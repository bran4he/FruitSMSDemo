drop table if exists T_ASSIGN;
CREATE TABLE `T_ASSIGN` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`slavePhone` VARCHAR(100) ,	/*唯一索引*/
`isActive` tinyint(1),	/*是否激活，0-No, 1-Yes*/
`slaveName` VARCHAR(100) ,
`isVirtual` tinyint(1),	/*是否是虚拟号码，0-No, 1-Yes*/
`initialUnit` int(10) NOT NULL,
`balanceUnit` int(10) NOT NULL,

`weecharOpenid` VARCHAR(100),

`effectivePeriod` int(10) NOT NULL,
`expireDate` timestamp NOT NULL,

`remark` VARCHAR(200),
`extendData` VARCHAR(1000),

`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',

PRIMARY KEY(`id`),
UNIQUE KEY `slaveKey` (`slavePhone`)
);
alter table T_ASSIGN AUTO_INCREMENT=1;

insert into T_ASSIGN
	values
(1, '15692132432' ,0, '156name', 0,
	10, 5, 'xxxxxxxxx', 3, '2020-03-20', 
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

insert into T_ASSIGN
	values
(2, '2' ,0, 'slaveName', 1,
	10, 10, 'xxxxxxxxx', 3, '2020-03-20', 
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

select * from T_ASSIGN;




