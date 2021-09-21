# springboot-log4j2-demo#
    注意！注意！注意！
    想要更好的了解log4j2的使用，还是去log4j的官网才行。这里只是简单的演示。本人对于官网的研究也有很多的不足，只是将看到的某些注意点这里会记录下。
    所以想要更加随心所欲的使用，一定要学会自己去研究官网。
    切记！切记！切记！
## xml文件配置 ##
1. xml类型的配置，有两种，一种是简化的配置，一种是标准的xml配置
   1. 简化配置的标签例如：
    ```xml
        <Console name="STDOUT" target="SYSTEM_OUT">-->
          <PatternLayout disableAnsi="false" pattern="${CONSOLE}" charset="${CHARSET}"/> 
        </Console>
    ```
   2. 注意，使用标准的时候，要在`<configuration>`标签上，加上：`strict="true"`，参考log4j2.xml文件的配置方式。标准的配置的标签，例如：
   ```xml
    <Appender type="Console" name="STDOUT" target="SYSTEM_OUT">
        <Layout type="PatternLayout">
            <Pattern>${CONSOLE}</Pattern>
        </Layout>
    </Appender>
    ```
## 配置文件的拆分 ##
文件：log4j2-test.xml是个完整的文件。
这里是以xml为例，其他方式的暂时还没有研究
测试拆分文件时，使用的文件有：
1. log4j2.xml：综合引入各个日志配置文件
2. log4j2-appenders.xml：定义appender文件
3. log4j2-property.xml：定义property文件
4. log4j2-asy.xml(异步日志)|log4j2-syn.xml（同步日志）
