drop table if exists T_LOGIN_LOG;
CREATE TABLE `T_LOGIN_LOG` (
`id` int(10) NOT NULL AUTO_INCREMENT, 
`userId` int(10) NOT NULL,
`loginDate` timestamp,
`loginIP` VARCHAR(20),
PRIMARY KEY(`id`),
foreign key(`userId`) references T_USER(`id`)      #外链到T_USER表的id字段
);
alter table T_USER AUTO_INCREMENT=1;

insert into T_LOGIN_LOG values (null, 1, '2017-03-22', '127.0.0.1');

/*以上初始化和建库脚步*/

select * from T_LOGIN_LOG;

delete from T_LOGIN_LOG;

show create table T_LOGIN_LOG;

select max(id) from T_LOGIN_LOG;

select log.*, u.username from T_LOGIN_LOG log join T_USER u
	on log.userId = u.id order by log.id limit 1, 10;
