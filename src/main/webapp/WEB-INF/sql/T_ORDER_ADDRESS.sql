drop table if exists T_ORDER_ADDRESS;

CREATE TABLE `T_ORDER_ADDRESS` (
`id` int(10) NOT NULL AUTO_INCREMENT, 
`address` VARCHAR(100) NOT NULL,
`contactName` VARCHAR(50) NOT NULL,
`contactPhone` VARCHAR(100) NOT NULL,
`wechatOpenid` VARCHAR(100),
`defaultAddr` tinyint(1) default 0,/*是否是默认地址，0-No, 1-Yes*/
PRIMARY KEY(`id`)
);
alter table T_ORDER_ADDRESS AUTO_INCREMENT=1;

insert into T_ORDER_ADDRESS values (1, '中国上海市淞沪路270号创智天地广场3号楼', '张晓霞', '15888888888', 'QWERTYUIOP', 0);
insert into T_ORDER_ADDRESS values (2, '中国上海市大渡河路138弄长风公园', '李大庄', '13056721342', 'QWERTYUIOP', 1);
insert into T_ORDER_ADDRESS values (3, '美国华盛顿州金色大街', 'jack', '01088888', 'QWERTYUIOP', 0);

/*以上初始化和建库脚步*/
select * from t_order_address;
