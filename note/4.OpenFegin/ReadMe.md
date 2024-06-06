OpenFegin

简介：

![img.png](img.png)

实际开发中 loadBalancer用的不多，多用 OpenFegin


架构图：
![img_1.png](img_1.png)

超时控制：


全局配置：
![img_2.png](img_2.png)

指定配置：
只需要把default配置去掉，添加对应配置即可
如果两个配置都存在，回去找详细配置，就近原则


重试机制：
配置文件配置可设置重试次数，间隔时长

openApi优化HttpClient:

pom替换  
![img_3.png](img_3.png)

配置添加  
![img_4.png](img_4.png)

对响应请求进行压缩  
![img_5.png](img_5.png)


日志打印
![img_6.png](img_6.png)


config 添加文件后还需要 在 yml 文件中进行配置






