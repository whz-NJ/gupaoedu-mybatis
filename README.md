#Mybatis API使用和手写

##环境搭建

安装一下lombok插件

包含编程式使用 mybatis用例：

运行 com.gupaoedu.mybatis.demo.APIDemo#main 测试用例
运行 MyBatisDemo.get 用例，可以测试 com.gupaoedu.mybatis.plugins.TestPlugin
验证二级缓存的用例：先把TestMapper.xml里<cache>配置打开，然后运行 com.gupaoedu.mybatis.demo.MyBatisDemo.main

com.gupaoedu.mybatis.proxy.Test 为JDK动态代理测试用例。
MapperProxy.invokeDefaultMethod 方法何时执行？ https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

通过AOP，将 Configuration#interceptorChain 插入到Mapper的执行过程中。

将Executor功能拆分为StatementHandler（将Mybatis原生ParameterHandler功能合并进来了，ParameterHandler作用就是
将JavaType转换为DBType，其实ParameterHandler也使用了TypeHandler）和ResultSetHandler
（将Mybatis原始的TypeHandler功能合并进来了，TypeHandler作用就是实现DBType和JavaType之间的互转）。

## 手写Mybatis v2.0

测试用例 com.gupaoedu.mybatis.gp.BootStrap 为手写Mybatis v2.0 版本测试用例。

