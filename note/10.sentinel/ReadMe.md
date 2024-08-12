sentinel:

是什么：
![img.png](img/img.png)

流程：
![img_1.png](img/img_1.png)

主要特性：
![img_2.png](img/img_2.png)

组成：
![img_3.png](img/img_3.png)

sentinel: 使用控制台配置
![img_4.png](img/img_4.png)


流空规则

![img_5.png](img/img_5.png)

熔断规则

![img_6.png](img/img_6.png)

![img_7.png](img/img_7.png)


图形配置和代码关系

![img_8.png](img/img_8.png)


热点限流：
控制参数，如果参数符合进行限流


授权规则概述

![img_9.png](img/img_9.png)



规则持久化

规则控制类型

![img_10.png](img/img_10.png)


持久化配置：

[
{
"resource": "/rateLimit/byUrl",
"limitApp": "default",
"grade": 1,
"count": 1,
"strategy": 0,
"controlBehavior": 0,
"clusterMode": false
}
]

![img_13.png](img/img_13.png)![img_12.png](img/img_12.png)



sentinel 整合 openFeign :
报错统一返回处理：
1.feign 注解 配置
2.sentinel 配置
版本不兼容，要该 boot - cloud 版本

gateWay 和 sentinel 集成实现服务限流：

只是一个简单的例子









