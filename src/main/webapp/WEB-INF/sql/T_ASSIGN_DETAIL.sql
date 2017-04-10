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

select * from T_ASSIGN_DETAIL;
