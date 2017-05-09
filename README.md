# FruitSMSDemo
a demo for fruit sales management system


# 部署
1. 填写jdbc.properties中c3p0.password=，注意不要commit这个密码
2. 注释或删除jdbc.properties中#local c3p0的相关配置
3. 替换war包的jdbc.properties，或者直接mvn clean package -Dmaven.test.skip=true

# Requirement

+ fruitMonth:水果上架的月份
+ maxOrderDay:可以触发下单（主单）操作的最晚日期，限制为当月的某号，如25号
+ maxProvNum:此批次水果最大可提供份数（水果都是按份数计算） -  **暂时不对此做限制**
+ maxOrderNum:一单（主单）最多可以下几份，如2份，
+ 注意：主单一个月对一个水果只可以下一份 - **需要确认需求**


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
23. add api of validate wechatOpenId - 20170406
24. add quick operation for changing order status - 20170406
25. 增加查看功能，多列信息是方便查看 - 20170407
26. 增加order页面的条件搜索功能 -  20170407(updated project screenshot)
27. 增加assgin页面的条件搜索功能 - 20170407
28. 增加assigndetail页面的条件搜索功能 - 20170407
29. 增加fruit config页面的条件搜索功能 - 20170407
30. 增加公共参数：默认收礼人建立时的默认有效期为3年 及相关逻辑  -20170408
31. 增加前端新建和修改时的必填字段校验及提示信息   -20170408
32. 备注改为非必填字段，后台判断是否为空，为空时置为默认备注  -20170408
33. 修改jqgrid显示如激活、虚拟号、订单状态为真实字面意义，隐藏原来关联的id -20170408
34. 增加AOP注解方式输出系统日志   -20170408
35. 更新页面的显示信息，更为正式和商业   -20170409
36. 增加逻辑：保存水果配置时，最大可定数量小于已存在的订单   -20170409
37. 自动保存微信端下单时的地址信息，关联到openId - 20170410
38. 收礼人下单时提供列表，并提供删除功能相关接口 - 20170410
39. 订单管理页面支持收礼人姓名和收礼人手机号查询功能 - 20170410
40. 使用c3p0数据库连接池代替DBCP，解决新浪SAE数据库默认设置max_wait=10s导致connection关闭却仍然存在pool里，引发的查询失效问题。 - 20170411
41. 增加部署说明 - 20170411
42. 暂时允许第三方跨域请求微信API controller: @CrossOrigin(origins = "*") or mvc:cors - 20170411
43. 增加微信查询水果列表接口 - 20170412
44. 增加微信查询当前月份水果列表接口 - 20170413
45. 后台水果配置页面增加显示当前月份水果功能  - 20170414
46. 微信接口增加一单多水果的功能 - 20170413
47. 后台准备设计方法，显示一单多水果功能的展示 - 20170415
48. 双击订单显示订单详细 - 20170415
49. 格式化和标准化订单查询信息 - 20170420
50. 增加短信调用接口，调用微信端的接口在用户获得分配水果时接收提醒短信 - 20170424
51. 增加查询最大可订单日的微信端接口 - 20170426
52. 简化页面格式选择，只显示yyyy-MM-dd(只保留登录日志精确到时分秒) - 20170427
53. 新增defaultAddr字段，用于标识用户的默认地址，用于自动填充 - 20170427
54. 新增控件用于数量的操作，防止不当操作。支持设置初始值，最小最大值 - 20170428
55. 更新下单接口，支持参数是否将此单地址设为默认地址，兼容之前设计的下单接口 - 20170430
56. 新增接口 统计当月用户已经下的订单数量（待派送的订单数量） - 20170430
57. 根据讨论，删除水果设置上的最大订单日限制 - 20170502
58. 删除slider控制数字，在前端页面使用js写死逻辑强制校验数字，0~10000、-10000~10000 - 20170502
59. 更新最大可在途订单量接口，返回当前用于当月的在途订单和公共参数配置的单数  - 20170503
60. 更新计划送达时间（+7days of create day），送达时间，完成时间（状态扭转前不显示，扭转成功后显示当前时间）- 20170503
61. move API related docs to wiki - 20170509
- - - 

### bug fix
1. assign page cannot use view function - 20170407
2. user order missing verify of public config of max_order_day_to -  20170407
3. fix user order and save common address, should getNextId for entity to save - 20170410
4. user login record save date time(db) but query/list without HH:mm:ss - 20170411
5. fix jquery ajax with CORS issue - 20170412
6. fix bug of cannot query order from wechat - 20170420
7. fix bug that user can cancel canceled orders - 20170427
8. fix bug of getCurrentMonthWaitForOrderNums - 20170504
9. fix bug of save same address with order set default address - 20170509
- - -

### function design

+ ~~Jqgrid调用同一增删改接口 js和前端控制研究和设计~~ -  done #10
+ ~~管理退出登录控制及session设置~~ - done #11
+ ~~ASSIGN设计~~ - done #14
+ ~~ASSIGN DETAIL设计~~ - done #14
+ ~~ORDER设计~~ - done #13
+ ~~系统参数设计~~ - done #11
+ ~~暂时未设计翻页操作，全部使用loadonce=ture设计，后期改进~~ - done #12
+ ~~setup new ORDER, how to desgin UI and get data from ASSIGN~~ - done

- - -

## 微信第三方接口的安全性设计

[安全设计](https://github.com/bran4he/FruitSMSDemo/wiki "设计")

## 微信API

[接口在wiki](https://github.com/bran4he/FruitSMSDemo/wiki "接口信息")

## Assign

>后台

+ 不允许add/update/delete

>前台

+ 提供接口提供手机号码状态查询 - done
+ 激活号码时更新status - done
+ 下订单时减少unit - done
+ 取消订单时增加unit - done

## AssignDetail - 后台管理人员控制源数据

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


## Order - 前台消费数据控制

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

> page with quick operation & criteria search

![Alt text](project20170407.png)

> common page

![Alt text](project20170329.png)


# Design API

> Wait...

# Design DB

> 初始化脚本见项目目录


# Design Overall

> Business requirements


