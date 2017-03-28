# FruitSMSDemo
a demo for fruit sales management system


# Issues

## T_FRUIT_CONFIG
fruitMonth:水果上架的月份
maxOrderDay:可以触发下单（主单）操作的最晚日期，限制为当月的某号，如25号
maxProvNum:此批次水果最大可提供份数（水果都是按份数计算）
maxOrderNum:一单（主单）最多可以下几份，如2份，注意：主单一个月对一个水果只可以下一份


# Coding Progress

## Plan:

- - -

1. 管理员设计 - 20170322
2. 首页及菜单设计	- 20170324
3. Jqrid加载数据及显示 - 20170324
4. 菜单切换功能模块设计  - 20170324
5. 管理员日志设计 - 20170323
6. 登录接口设计 - 20170323
7. 验证码及系统权限控制  - 20170323
8. 订单状态设计 - 20170322
9. 实现前端全部的增删改的设计和coding, 使用orderstatus为范例 - 20170327

- - - 

+ Jqgrid调用同一增删改接口 js和前端控制研究和设计
+ 管理退出登录控制及session设置
+ 客户设计
+ 主单设计
+ 次单设计
+ 系统参数设计
+ 暂时未设计翻页操作，全部使用loadonce=ture设计，后期改进

> 未完待续...

- - -

## Demo Show

![Alt text](project20170324.png)


# Design API
**OrderStatus**
### 1
request:
```
GET /os/all
```
response:
```
[
  {
    "id": "1",
    "name": "待派送"
  },
  {
    "id": "2",
    "name": "派送中"
  },
  {
    "id": "3",
    "name": "派送成功"
  },
  {
    "id": "4",
    "name": "用户取消"
  },
  {
    "id": "5",
    "name": "派送失败"
  }
]
```
### 2
request:
```
POST /os/add
BODY
{
    "id":null,
    "name":"test"
}
```
response:
```
{
  "result": true,
  "msg": {
    "data": {
      "id": "72",
      "name": "test"
    }
  }
}
```

### 3
request:
```
GET /os/delete/{id} //id=72
```
response:
```
{
  "result": true,
  "msg": {
    "data": {
      "id": "72",
      "name": test
    }
  }
}
```

# Design DB
**OrderStatus**
```
drop table if exists T_ORDER_STATUS;
CREATE TABLE `T_ORDER_STATUS` (
`id` int(5) NOT NULL AUTO_INCREMENT, 
`name` VARCHAR(20) NOT NULL,
PRIMARY KEY(`id`)
); 
alter table T_ORDER_STATUS AUTO_INCREMENT=0;
```

> 初始化脚本见项目目录


# Design Overall

> 原则：

+ 尽量从简设计
+ 实体类和数据库表的对应规则，方便进行快速ORM/CURD操作。如OrderStatus类代表订单状态，对应DB表设计为T_ORDER_STATUS


**管理人表**
*T_USER*
id|name|desc

**客户表**
*T_CUSTOMER*

**产品表**
*T_PRD*
id|name|price|place|desc

**订单表**
*T_ORDER*

+ 产品信息和客户信息会复制一份到所产生的订单，防止产品更新和客户更新导致订单信息错乱

