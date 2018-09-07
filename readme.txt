1、pom.xml主要描述了项目的maven坐标，依赖关系，开发者需要遵循的规则，缺陷管理系统，组织和licenses，
    以及其他所有的项目相关因素，是项目级别的配置文件。
2、target是编码后的文件
3、mvnm是大型项目之间的版本依赖
4、src下main是源代码，test是单元测试代码
5、main文件夹下resources是静态资源文件：图片、js文件、css文件
6、热部署配置：pom.xml
    1)添加如下配置
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
    2）<build><plugins><plugin><artifactId>后添加如下配置
            <configuration>
                <fork>true</fork>
            </configuration>

