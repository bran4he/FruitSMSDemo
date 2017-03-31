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
10. 统一全部前端jqgrid, jquery-ui 入口到index.js - 20170328
11. 完成公共参数, 用户管理, 登录日志, 订单状态的全部前台后台工作 - 20170328
12. add paging function from server part - 20170329
13. add ASSIGN function from back-end and front-end - 20170329
14. add ASSIGN_DETAIL function from back-end and front-end - 20170329
15. add jquery-ui datepicker and jQuery-Timepicker-Addon for pick up date and time - 20170329
- - - 

+ ~~Jqgrid调用同一增删改接口 js和前端控制研究和设计~~ -  done #10
+ ~~管理退出登录控制及session设置~~ - done #11
+ ~~ASSIGN设计~~ - done #14
+ ~~ASSIGN DETAIL设计~~ - done #14
+ ~~ORDER设计~~ - done #13
+ ~~系统参数设计~~ - done #11
+ ~~暂时未设计翻页操作，全部使用loadonce=ture设计，后期改进~~ - done #12
+ setup new ORDER, how to desgin UI and get data from ASSIGN

> 未完待续 user and business requirement...

## 接口plan

+ 提供号码是否存在及激活在Assign表里
+ 下订单接口
+ 我的订单查询接口，使用条件过滤



### Assign

>后台

+ 不允许add/update/delete

>前台

+ 提供接口提供手机号码状态查询
+ 激活号码时更新status，下订单时减少unit，取消订单时增加unit

### AssignDetail - 后台源数据控制

>后台

+ 允许add
+ 不允许delte，写错数量时允许unit填负值进行对冲
+ 允许有条件的编辑：
	+ 不允许编辑unit，只允许新建对冲
	+ slavePhone允许编辑，新建是为真实，编辑时仍为真实；新建时虚拟，编辑时强制虚拟号码改为真实号码
	+ isVirtual不允许编辑，新建时时真是号码，一直是真实；新建时是虚拟，第一次编辑置强制置为真实并且不允许改动
+ 所有的改动只允许按规定流程顺序执行，不能错乱或者回退信息流	

>前台


### Order - 前台消费数据控制

>后台

+ 不允许add/edit/delete
+ 不允许更新订单 - 后台管理不负责更新订单的信息，全部由前台来操作
+ 提供两个按钮，支持批量选择，支持status更改'待派送' -> '派送中' -> '派送成功'
+ 订单状态参数的新建和修改不开放

>前台

+ 提供必要的接口参数，给前台下订单使用(add接口)
+ 支持前台订单的取消（地址等信息错误重新下单）
+ 

- - -

# Demo Show

![Alt text](project20170329.png)


# Design API

> Wait...

# Design DB

> 初始化脚本见项目目录


# Design Overall

> Business requirements


