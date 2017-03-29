drop table if exists T_ASSIGN;
CREATE TABLE `T_ASSIGN` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`masterPhone` VARCHAR(100) ,
`masterName` VARCHAR(100) ,

`slavePhone` VARCHAR(100) ,
`slaveName` VARCHAR(100) ,

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

PRIMARY KEY(`id`)
);
alter table T_ASSIGN AUTO_INCREMENT=1;

insert into T_ASSIGN
	values
(null, '15687654523', 'master', '1452643725367' , 'slave', 
	2, 2, 'xxxxxxxxx', 3, '2020-03-20', 
	'remark', 'ext data', 
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

select * from T_ASSIGN;



