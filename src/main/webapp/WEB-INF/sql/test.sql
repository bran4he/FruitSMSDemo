show databases;

drop database eBaoDemo;

CREATE DATABASE eBaoDemo;

create database eBaoDemo character set utf8; 

alter database eBaoDemo character set utf8;

use eBaoDemo;

show tables;
show  global  variables like  'wait_timeout'; 

set global wait_timeout=28800;
set global wait_timeout=30;


show variables like '%character%';

set character_set_client = utf8;

set character_set_server = utf8;

set character_set_connection = utf8;

set character_set_database = utf8;

set character_set_results = utf8;

set collation_connection = utf8_general_ci;

set collation_database = utf8_general_ci;

set collation_server = utf8_general_ci;



select oo.*, os.name as statusValue , aa.wechatOpenid as wechatOpenid from T_ORDER oo join T_ASSIGN aa on oo.assignId = aa.id join T_ORDER_STATUS os on oo.statusId = os.id WHERE wechatOpenid='QWERTYUIOP' order by updateDate 
