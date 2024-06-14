服务熔断

使用场景：多服务调用情况，一个服务挂掉之后，进行降级，防止影响到其他服务的调用

![img.png](img/img.png)

包含的内容：

![img_1.png](img/img_1.png)


circuitBreaker  断路器  它有两个具体实现：
Resilience4J
Spring Retry


resilience4j  

![img_2.png](img/img_2.png)

熔断器状态转换

![img_3.png](img/img_3.png)

配置详解：
![img_4.png](img/img_4.png)

例子：
其中 fallback 是指返回策略，例如返回一个 状态值

![img_5.png](img/img_5.png)

面试举例子

![img_6.png](img/img_6.png)
![img_7.png](img/img_7.png)

基于时间的配置
![img_8.png](img/img_8.png)

![img_9.png](img/img_9.png)









