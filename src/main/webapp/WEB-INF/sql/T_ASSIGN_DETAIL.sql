drop table if exists T_ASSIGN_DETAIL;
CREATE TABLE `T_ASSIGN_DETAIL` (
`id` int(10) NOT NULL AUTO_INCREMENT, 

`assignId` int(5) NOT NULL,
`unitUpdate` int(10) NOT NULL,

`masterPhone` VARCHAR(100) ,
`masterName` VARCHAR(100) ,

`slavePhone` VARCHAR(100) ,
`slaveName` VARCHAR(100) ,

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
(null, 1, 10,
'15687654523', 'master', '1452643725367' , 'slave', 
	'remark',
	'2017-03-02', 'admin','2017-03-02', 'admin');

/*以上初始化和建库脚步*/

select * from T_ASSIGN_DETAIL;