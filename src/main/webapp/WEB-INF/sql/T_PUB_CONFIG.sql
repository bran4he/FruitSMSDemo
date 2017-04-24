drop table if exists T_PUB_CONFIG;
CREATE TABLE `T_PUB_CONFIG` (
`id` int(5) NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(20) NOT NULL,
`value` VARCHAR(200) NOT NULL,
`remark` VARCHAR(100) NOT NULL,
`insertDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`insertBy` VARCHAR(20) default 'admin',
`updateDate` timestamp DEFAULT CURRENT_TIMESTAMP,
`updateBy` VARCHAR(20) default 'admin',
PRIMARY KEY(`id`)
); 
alter table T_PUB_CONFIG AUTO_INCREMENT=1;

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'ORDER_DAY_TO', '25', '最大的不可下订单日期');

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'RECEIVER_EFF_YEAR', '3', '收礼人账户建立后的默认有效期');

insert into T_PUB_CONFIG (id, name, value, remark) values (null,'WECHAT_SERVER_URL', 'http://localhost:8080/TryNewFruit/', '微信后台的地址用于调用发短信接口');


insert into T_PUB_CONFIG (id, name, value, remark) values (null,'RECIVER_SMS_CONTENT', '亲爱的用户，恭喜您收到水果啦，请到微信公众号xxx激活手机号并领取水果。', '用户分配到水果后收到的短信内容');

/*以上初始化和建库脚步*/

select * from T_PUB_CONFIG;


