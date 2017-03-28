show databases;

CREATE DATABASE eBaoDemo;

use eBaoDemo;

show tables;

CREATE TABLE T_USER (
name VARCHAR(20), 
sex CHAR(1), 
age TINYINT(2)
); 

select * from T_USER;


insert into T_USER values ('jack', 'm', 101);


show create table T_USER;

CREATE TABLE T_DEMO (
id int(5) NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL, 
sex CHAR(1), 
age TINYINT(2),
PRIMARY KEY(`id`)
); 
alter table T_DEMO AUTO_INCREMENT=0;

insert into T_DEMO values (null, 'jack', 'm', 101);
insert into T_DEMO values (null, 'bran', 'f', 9);
insert into T_DEMO values (null, 'hello', 'm', 10);

insert into T_DEMO values ('19', 'dddd', 's', 90);
select * from T_DEMO;

select max(id) from T_DEMO;

