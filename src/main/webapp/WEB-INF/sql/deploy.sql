drop table if exists T_ASSIGN;
CREATE TABLE `T_ASSIGN` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`slavePhone` VARCHAR(100) ,	/*唯一索引*/
`isActive` tinyint(1),	/*是否激活，0-No, 1-Yes*/
`slaveName` VARCHAR(100) ,
`isVirtual` tinyint(1),	/*是否是虚拟号码，0-No, 1-Yes*/
`initialUnit` int(10) NOT NULL,
`balanceUnit` int(10) NOT NULL,

`wechatOpenid` VARCHAR(100),

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

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'RECEIVER_EFF_YEAR', '3', '收礼人账户建立后的有效期');

/*以上初始化和建库脚步*/

drop table if exists T_USER;
CREATE TABLE `T_USER` (
`id` int(10) NOT NULL AUTO_INCREMENT, 
`username` VARCHAR(20) NOT NULL,
`password` VARCHAR(20) NOT NULL,
`email` VARCHAR(50),
`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',
PRIMARY KEY(`id`)
); 
alter table T_USER AUTO_INCREMENT=1;

/*初始化admin用户*/
insert into T_USER (id, username, password, email) values (1, 'admin', 'admin', 'admin@admin.com');
insert into T_USER (id, username, password, email) values (null, 'test', 'test', 'test@test.com');
/*以上初始化和建库脚步*/



drop table if exists T_LOGIN_LOG;
CREATE TABLE `T_LOGIN_LOG` (
`id` int(10) NOT NULL AUTO_INCREMENT, 
`userId` int(10) NOT NULL,
`loginDate` timestamp,
`loginIP` VARCHAR(20),
PRIMARY KEY(`id`),
foreign key(`userId`) references T_USER(`id`)
);
alter table T_USER AUTO_INCREMENT=1;

insert into T_LOGIN_LOG values (null, 1, '2017-03-22', '127.0.0.1');

/*以上初始化和建库脚步*/



drop table if exists T_ASSIGN_DETAIL;
CREATE TABLE `T_ASSIGN_DETAIL` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`assignId` int(5) NOT NULL,
`unitUpdate` int(10) NOT NULL,

`masterPhone` VARCHAR(100) ,
`masterName` VARCHAR(100) ,


`slavePhone` VARCHAR(100) ,
`slaveName` VARCHAR(100) ,
`isVirtual` tinyint(1),	/*是否是虚拟号码，0-No, 1-Yes*/


`remark` VARCHAR(200),

`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',

PRIMARY KEY(`id`),
foreign key(`assignId`) references T_ASSIGN(`id`)
);
alter table T_ASSIGN_DETAIL AUTO_INCREMENT=1;

insert into T_ASSIGN_DETAIL
	values
(1, 1, 10,
'12345678901', 'master', '15692132432' , 'slave', 0, 
	'remark',
	'2017-03-02', 'admin','2017-03-02', 'admin');

insert into T_ASSIGN_DETAIL
	values
(2, 1, 10,
'12345678901', 'master', '2' , 'slave', 1,
	'虚拟号码',
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

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
(	null, 2, 1, 1, 'apple', 5,
	'2017-04-02', '中国上海市淞沪路270号创智天地广场3号楼','王小二','15888888888',
	'2017-04-12', 'JD李大宝','货到付款',
	'2017-04-13', '张小妹', '放在前台',
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/









