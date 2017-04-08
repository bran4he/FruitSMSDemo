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

select * from T_LOGIN_LOG;

