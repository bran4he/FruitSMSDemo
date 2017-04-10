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

select * from T_ORDER_ADDRESS;
SELECT * FROM T_ORDER_ADDRESS WHERE wechatOpenid='QWERTYUIOP';