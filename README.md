# FruitSMSDemo
a demo for fruit sales management system

# Design

> 原则：尽量从简设计

**管理人表**
*T_USER*
id|name|role|desc

role:
从简设计只能有一个角色(规模扩大后可以添加多角色功能)

**角色表**
*T_ROLE*
id|name|type|desc

type: 
+ 固定code
+ 0 - 管理员(所有操作)
+ 1 - 普通用户(只能查看，不能增删改)

**客户表**
*T_CUSTOMER*
id|name|add01|add02|phone|remark

+ add01和add02为客户可手填或管理员更改的地址
+ remark为备注信息

**产品表**
*T_PRD*
id|name|price|place|desc

**订单表**
*T_ORDER*

id|no|prd_name|prd_amount|prd_unit_price|prd_total_price|remark|cus_name|cus_add01|cus_add02|cus_phone|cus_remark

+ 产品信息和客户信息会复制一份到所产生的订单，防止产品更新和客户更新导致订单信息错乱
+ 订单生成使使用自动计算prd_total_price = prd_amount * prd_unit_price
+ 总价支持手动修改(店主优惠)
