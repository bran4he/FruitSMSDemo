/* drop table*/
drop table if exists T_ASSIGN_DETAIL;

drop table if exists T_ORDER;
drop table if exists T_ORDER_DETAIL;
drop table if exists T_ORDER_STATUS;
drop table if exists T_FRUIT_CONFIG;


drop table if exists T_ASSIGN;

drop table if exists T_ORDER_ADDRESS;
drop table if exists T_PUB_CONFIG;

drop table if exists T_LOGIN_LOG;
drop table if exists T_USER;


/* add data */
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
insert into T_USER (id, username, password, email) values (2, 'test', 'test', 'test@test.com');
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

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'RECEIVER_EFF_YEAR', '3', '收礼人账户建立后的默认有效期');

/*以上初始化和建库脚步*/
drop table if exists T_ORDER_ADDRESS;

CREATE TABLE `T_ORDER_ADDRESS` (
`id` int(10) NOT NULL AUTO_INCREMENT, 
`address` VARCHAR(100) NOT NULL,
`contactName` VARCHAR(50) NOT NULL,
`contactPhone` VARCHAR(100) NOT NULL,
`wechatOpenid` VARCHAR(100),
PRIMARY KEY(`id`)
);
alter table T_ORDER_ADDRESS AUTO_INCREMENT=1;

insert into T_ORDER_ADDRESS values (1, '中国上海市淞沪路270号创智天地广场3号楼', '张晓霞', '15888888888', 'QWERTYUIOP');
insert into T_ORDER_ADDRESS values (2, '中国上海市大渡河路138弄长风公园', '李大庄', '13056721342', 'QWERTYUIOP');

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
(1, 'apple', 'shanghai','2017-04-02', '2017-04-25',5, 99, 
	'this is remark', '{name:"tom"}','2017-03-02', 'admin','2017-03-02', 'admin');
insert into T_FRUIT_CONFIG 
	values 
(null, '香蕉', 'shanghai','2017-04-02', '2017-04-25',5, 99,
	'this is remark', '{name:"jack"}','2017-02-02', 'admin','2017-02-02', 'admin');
/*以上初始化和建库脚步*/

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
(1, '15692132432' ,1, '收礼人小何', 0,
	10, 5, 'QWERTYUIOP', 3, '2020-03-20', 
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

insert into T_ASSIGN
	values
(2, '2' ,0, '虚拟收礼人lee', 1,
	10, 10, 'NA', 3, '2020-03-20', 
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

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
'13045610339', '送礼人小张', '15692132432' , '收礼人小何', 0, 
	'小张来打电话给我们',
	'2017-03-02', 'admin','2017-03-02', 'admin');

insert into T_ASSIGN_DETAIL
	values
(2, 1, 10,
'18712367445', '送礼人小李', '2' , '虚拟收礼人lee', 1,
	'收礼人是虚拟号码',
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

drop table if exists T_ORDER;
CREATE TABLE `T_ORDER` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`statusId` int(5) NOT NULL,
`slaveName`	VARCHAR(100),
`slavePhone`	VARCHAR(100),

`assignId` int(10) NOT NULL,

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
foreign key(`assignId`) references T_ASSIGN(`id`)
);
alter table T_ORDER AUTO_INCREMENT=1;

insert into T_ORDER
	values
(	null, 2,'收礼人小何', '15692132432',  1, 
	'2017-04-02', '中国上海市淞沪路270号创智天地广场3号楼','王小二','15888888888',
	'2017-04-12', '京东李大宝','货到付款',
	'2017-04-13', '张小妹', '放在前台',
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/
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
