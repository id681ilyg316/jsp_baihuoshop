## 本项目实现的最终作用是基于JSP在线百货商城系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 分类管理
 - 商品上架
 - 商品管理
 - 查看订单
 - 用户列表
 - 管理员登录
 - 管理资讯列表
### 第2个角色为用户角色，实现了如下功能：
 - 按分类查看
 - 提交订单
 - 查看商品详情
 - 查看我的订单
 - 查看我的购物车
 - 查看资讯列表
 - 用户登录
 - 确认订单
## 数据库设计如下：
# 数据库设计文档

**数据库名：** baihuoshop

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [easybuy_news](#easybuy_news) |  |
| [easybuy_order](#easybuy_order) |  |
| [easybuy_order_detail](#easybuy_order_detail) |  |
| [easybuy_product](#easybuy_product) |  |
| [easybuy_product_category](#easybuy_product_category) |  |
| [easybuy_user](#easybuy_user) |  |
| [easybuy_user_address](#easybuy_user_address) |  |
| [result](#result) |  |

**表名：** <a id="easybuy_news">easybuy_news</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | title |   varchar   | 255 |   0    |    N     |  N   |       | 标题  |
|  3   | content |   varchar   | 1000 |   0    |    N     |  N   |       | 内容  |
|  4   | createTime |   varchar   | 255 |   0    |    N     |  N   |       | 创建时间  |

**表名：** <a id="easybuy_order">easybuy_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | userId |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户主键  |
|  3   | loginName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | userAddress |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户地址  |
|  5   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  6   | cost |   float   | 13 |   0    |    Y     |  N   |   NULL    | 总消费  |
|  7   | serialNumber |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 订单号  |

**表名：** <a id="easybuy_order_detail">easybuy_order_detail</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | orderId |   int   | 10 |   0    |    N     |  N   |       | 订单主键  |
|  3   | productId |   int   | 10 |   0    |    N     |  N   |       | 商品主键  |
|  4   | quantity |   int   | 10 |   0    |    N     |  N   |       | 数量  |
|  5   | cost |   float   | 13 |   0    |    N     |  N   |       | 消费  |

**表名：** <a id="easybuy_product">easybuy_product</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 名称  |
|  3   | description |   varchar   | 1024 |   0    |    Y     |  N   |   NULL    | 描述  |
|  4   | price |   float   | 13 |   0    |    N     |  N   |       | 价格  |
|  5   | stock |   int   | 10 |   0    |    N     |  N   |       | 库存  |
|  6   | categoryLevel1Id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分类1  |
|  7   | categoryLevel2Id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分类2  |
|  8   | categoryLevel3Id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 分类3  |
|  9   | fileName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 文件名称  |
|  10   | isDelete |   int   | 10 |   0    |    Y     |  N   |   0    | 是否删除(1：删除0：未删除)  |

**表名：** <a id="easybuy_product_category">easybuy_product_category</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 名称  |
|  3   | parentId |   int   | 10 |   0    |    N     |  N   |       | 父级目录id  |
|  4   | type |   int   | 10 |   0    |    Y     |  N   |   NULL    | 级别(1:一级2：二级3：三级)  |
|  5   | iconClass |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 图标  |

**表名：** <a id="easybuy_user">easybuy_user</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键  |
|  2   | loginName |   varchar   | 255 |   0    |    N     |  N   |       | 登录名  |
|  3   | userName |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  4   | password |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |
|  5   | sex |   int   | 10 |   0    |    N     |  N   |   1    | 性别(1:男0：女)  |
|  6   | identityCode |   varchar   | 60 |   0    |    Y     |  N   |   NULL    | 身份证号  |
|  7   | email |   varchar   | 80 |   0    |    Y     |  N   |   NULL    | 邮箱  |
|  8   | mobile |   varchar   | 11 |   0    |    Y     |  N   |   NULL    | 手机  |
|  9   | type |   int   | 10 |   0    |    Y     |  N   |   0    | 类型（1：后台0:前台）  |

**表名：** <a id="easybuy_user_address">easybuy_user_address</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | 主键id  |
|  2   | userId |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户主键  |
|  3   | address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 地址  |
|  4   | createTime |   datetime   | 19 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  5   | isDefault |   int   | 10 |   0    |    Y     |  N   |   0    | 是否是默认地址（1:是0否）  |
|  6   | remark |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="result">result</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | stuno |   char   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  2   | subjectName |   char   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | score |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  4   | age |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**运行不出来可以微信 javape 我的公众号：源码码头**
