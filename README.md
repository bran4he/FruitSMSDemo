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
### new feature

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
16. add api of phone register - 20170405
17. add api of order - 20170405
18. add api of validate phone - 20170405
19. add api for user cancle order - 20170406
20. add auth validation for integration api - 20170406
21. add Spring AOP for log
22. slavePhone有条件性编辑来保持系统逻辑简单 - 20170406
23. add api of validate weechatOpenId - 20170406
24. add quick operation for changing order status - 20170406
25. 增加查看功能，多列信息是方便查看 - 20170407
- - - 

### bug fix
1. assign pape cannot use view function


- - -

### function design

+ ~~Jqgrid调用同一增删改接口 js和前端控制研究和设计~~ -  done #10
+ ~~管理退出登录控制及session设置~~ - done #11
+ ~~ASSIGN设计~~ - done #14
+ ~~ASSIGN DETAIL设计~~ - done #14
+ ~~ORDER设计~~ - done #13
+ ~~系统参数设计~~ - done #11
+ ~~暂时未设计翻页操作，全部使用loadonce=ture设计，后期改进~~ - done #12
+ setup new ORDER, how to desgin UI and get data from ASSIGN - done

- - -

## 微信第三方接口的安全性设计
方案1：AOP
方案2：Interceptor

说明：
1. 选择方案2，可以方便的自定义拦截路径，不需要在每一个api上加上注解，直接通过xml配置即可。
2. rest/user/register/用户注册激活请求不需要认证
2. 其他请求需要在HTTP请求header上加上Auth属性，属性值为当前weechatOpenId


## 接口plan


### 提供号码是否存在及激活在Assign表里

**Request:**
```
URL: {web_root}/rest/user/validatePhone/{phone}
```
**Response:**
```
{
  "code": "success",
  "value": {status},
  "msg": null
}
```

**value of return**
```
	ACTIVE("active"), 
	NOTACTIVE("notactive"), 
	NA("NA");
```

**sample**
```
GET  fruit/rest/user/validatePhone/1588888888
```

- - -

### 校验weechatOpenId的状态
**Request:**
```
URL: {web_root}/rest/user/validateWeechatId/{weechatId}
```
> 其他同上

### 激活手机号码并关联存储weechatOpenId
**Request:**
```
URL: {web_root}/rest/user/register/{phone}/{weechatOpenId}
```

**Response**
```
{
  "code": "{code}",
  "value": {status},
  "msg": null
}
```

**code**
```
	SUCCESS("success"), 
	EXCEPTION("exception"), 
	FAIL("fail");
```

**value**
```
PARAM_NOT_CORRECT: -1
PROCESS_SUCCESS:0
USER_NOT_EXISTS:1
```

**sample**
```
GET  fruit/rest/user/register/1588888888/QWERTYUIOP
{
  "code": "success",
  "value": "0",
  "msg": null
}
```

### 下订单接口
**Request:**
```
POST: {web_root}/rest/order/userOrder/{weechatOpenID}
BODY:
{JSON DATA}
```
**Response**
```
{
  "code": null,
  "value": null,
  "msg": null
}

```
**code**
```
	SUCCESS("success"), 
	EXCEPTION("exception"), 
	FAIL("fail");
```

**value**
```
	PARAM_NOT_CORRECT = new String("-1");
	PROCESS_SUCCESS = new String("0");
	USER_NOT_AUTH = new String("1");
	BALANCE_NOT_ENOUGH = new String("2");
	EXCEED_MAX_ORDER_LIMIT = new String("3");
	EXCEED_MAX_ORDER_DATE = new String("4");
	EXCEED_ASSIGN_BALANCE_UNIT = new String("5");
	EXCEED_FRUIT_BALANCE = new String("6");
```

**msg**
```
null
order data(success)
```

**sample**
```
POST  fruit/order/userOrder/QWERTYUIOP
BODY 
  {
    "fruitId": 1,
    "fruitName": "apple0",
    "orderUnit": 1,
    "address": "中国上海市淞沪路270号创智天地广场3号楼",
    "contactName": "王小二",
    "contactPhone": "15888888888",
    "remark":"remakr"
  }
```

Response:
```
//success
{
  "code": "SUCCESS",
  "value": "0",
  "msg": "{\"id\":\"2\",\"statusId\":\"1\",\"assignId\":\"1\",\"orderUnit\":1,\"fruitId\":\"1\",\"fruitName\":\"apple0\",\"planDeliveryDate\":\"2017-04-12 14:50:28\",\"address\":\"中国上海市淞沪路270号创智天地广场3号楼\",\"contactName\":\"王小二\",\"contactPhone\":\"15888888888\",\"deliveryDate\":\"2017-04-12 14:50:28\",\"deliveryBy\":\"DeliveryBy\",\"deliveryRemark\":\"DeliveryRemark\",\"finishDate\":\"2017-04-12 14:50:28\",\"finishBy\":\"FinishBy\",\"finishRemark\":\"FinishRemark\",\"remark\":\"remakr\",\"extendData\":\"extdata\",\"insertDate\":\"2017-04-05 14:50:28\",\"updateDate\":\"2017-04-05 14:50:28\",\"insertBy\":\"unknown\",\"updateBy\":\"unknown\"}"
}

//fail
{
  "code": "EXCEPTION",
  "value": "6",
  "msg": null
}
```

- - -

### 我的订单查询接口，使用条件过滤
**Request:**
```
POST: {web_root}/rest/order/query/{weechatId}/{status}
```
**status**
```
	 ALL = "0";
	 WAIT_FOR = "1";
	 DELIVERYING = "2";
	 DELIVERY_SUCCESS = "3";
	 CUSTOMER_CANCLE = "4";
	 DELIVERY_FAIL = "5";
```

**Response**
```
{
  "code": {code},
  "value": {value},
  "msg": {list of order}
}
```

**sample**
Request:
GET fruit/rest/order/query/QWERTYUIOP/0

Response:
```
{
  "code": "SUCCESS",
  "value": "0",
  "msg": "[{\"id\":\"1\",\"statusId\":null,\"statusValue\":\"派送中\",\"assignId\":null,\"weecharOpenid\":\"QWERTYUIOP\",\"orderUnit\":5,\"fruitId\":null,\"fruitName\":\"apple0\",\"planDeliveryDate\":null,\"address\":\"中国上海市淞沪路270号创智天地广场3号楼\",\"contactName\":\"王小二\",\"contactPhone\":\"15888888888\",\"deliveryDate\":null,\"deliveryBy\":null,\"deliveryRemark\":null,\"finishDate\":null,\"finishBy\":null,\"finishRemark\":null,\"remark\":\"remark\",\"extendData\":null,\"insertDate\":null,\"updateDate\":null,\"insertBy\":null,\"updateBy\":null},{\"id\":\"2\",\"statusId\":null,\"statusValue\":\"待派送\",\"assignId\":null,\"weecharOpenid\":\"QWERTYUIOP\",\"orderUnit\":1,\"fruitId\":null,\"fruitName\":\"apple0\",\"planDeliveryDate\":null,\"address\":\"中国上海市淞沪路270号创智天地广场3号楼\",\"contactName\":\"王小二\",\"contactPhone\":\"15888888888\",\"deliveryDate\":null,\"deliveryBy\":null,\"deliveryRemark\":null,\"finishDate\":null,\"finishBy\":null,\"finishRemark\":null,\"remark\":\"remakr\",\"extendData\":null,\"insertDate\":null,\"updateDate\":null,\"insertBy\":null,\"updateBy\":null}]"
}
```

- - -

### 取消订单接口

**Request:**
```
GET: {web_root}/rest/order/cancleOrder/{orderId}
```

**Response**
```
{
  "code": {code},
  "value": {value},
  "msg": {JSON of order if success}
}

**sample**
Request:
GET fruit/rest/order/cancleOrder/2

Response:
```
{
  "code": "SUCCESS",
  "value": "0",
  "msg": "{\"id\":\"2\",\"statusId\":\"4\",\"assignId\":\"1\",\"orderUnit\":1,\"fruitId\":\"1\",\"fruitName\":\"apple0\",\"planDeliveryDate\":\"2017-04-12 14:50:28\",\"address\":\"中国上海市淞沪路270号创智天地广场3号楼\",\"contactName\":\"王小二\",\"contactPhone\":\"15888888888\",\"deliveryDate\":\"2017-04-12 14:50:28\",\"deliveryBy\":\"DeliveryBy\",\"deliveryRemark\":\"DeliveryRemark\",\"finishDate\":\"2017-04-12 14:50:28\",\"finishBy\":\"FinishBy\",\"finishRemark\":\"FinishRemark\",\"remark\":\"remakr\",\"extendData\":\"extdata\",\"insertDate\":\"2017-04-05 14:50:28\",\"updateDate\":\"2017-04-06 09:47:11\",\"insertBy\":\"unknown\",\"updateBy\":\"unknown\"}"
}
```

- - -

### 查询余额接口
**Request:**
```
GET: {web_root}/rest/assign/checkBalance/{weechatId}
```

**Response**
```
{
  "code": {code},
  "value": {value},
  "msg": null
}

**sample**
Request:
GET fruit/rest/assign/checkBalance/QWERTYUIOP

Response:
```
{
  "code": "SUCCESS",
  "value": "5",
  "msg": null
}
```

- - -

### Assign

>后台

+ 不允许add/update/delete

>前台

+ 提供接口提供手机号码状态查询 - done
+ 激活号码时更新status - done
+ 下订单时减少unit - done
+ 取消订单时增加unit - done

### AssignDetail - 后台管理人员控制源数据

>后台

+ 允许add - done
+ 不允许delete，写错数量时允许unit填负值进行对冲 -done
+ 允许有条件的编辑：
	+ 不允许编辑unit，只允许新建正值增加或者新建负值对冲  -done
	+ slavePhone允许编辑，新建是为真实，编辑时仍为真实，不允许修改为虚拟 - done
	+ 新建时虚拟，编辑时强制虚拟号码改为真实号码  - done
	+ isVirtual不允许编辑，新建时时真号码，一直是真实；新建时是虚拟，第一次编辑置强制置为真实并且不允许改动
+ 所有的改动只允许按规定流程顺序执行，不能错乱或者回退信息流

>前台


### Order - 前台消费数据控制

>后台

+ 不允许add/edit/delete
+ 不允许更新订单 - 后台管理不负责更新订单的信息，全部由前台来操作
+ 提供两个按钮，支持批量选择，支持status更改'待派送' -> '派送中' -> '派送成功' - done
+ 订单状态参数的新建和修改不开放 - done

>前台

+ 提供必要的接口参数，给前台下订单使用(add接口) - done
+ 支持前台订单的取消（地址等信息错误重新下单） - done


- - -

# Demo Show

![Alt text](project20170329.png)


# Design API

> Wait...

# Design DB

> 初始化脚本见项目目录


# Design Overall

> Business requirements


