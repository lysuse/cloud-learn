# Spring Cloud基础之Spring Boot

## 1. 简介
    Spring Boot 提供了Spring开发的一整套的脚手架，里面整合了常见的配置，
     同时结合内嵌(Embed)的服务器实现不依赖容器服务器部署的直接可运行的扎包！
     
    Spring Boot 使我们很容易创建基于Spring的独立运行，生产级别的运行程序；以我们自己对Spring平台和第三方库的开发经验和看法来构建，让你开始构建Spring应用程序不在麻烦。
    大多数Spring Boot 程序需要很少的Spring配置。
   
## 2. 环境要求
    Spring Boot 1.5.X 要求Java7+, Spring 4.3.14+; 当然可以使用Java6只不过需要一些额外的配置
    
    Spring Boot 2.0.X 要求Java8+, Spring 5.0.4+; 构建工具 maven 3.2+或者 Gradle 4+
    
#### Servlet容器
    Spring Boot 支持一下嵌入式Servlet容器：
    
    容器名称 | Servlet版本
    ---|---
    Tomcat 8.5   | 3.1
    Jetty 9.4    | 3.1  
    Undertow 1.4 | 3.1  
    
## 3. 安装 Spring Boot

#### 使用maven构建安装

```xml
<project>
    <!-- Inherit defaults from Spring Boot -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.0.0.RELEASE</version>
    </parent>

    <!-- Add typical dependencies for a web application -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    <!-- Package as an executable jar -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
    或者使用以下方式：
```xml
<dependencyManagement>
	<dependencies>
		<!-- Override Spring Data release train provided by Spring Boot -->
		<dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-releasetrain</artifactId>
			<version>Fowler-SR2</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-dependencies</artifactId>
			<version>2.0.0.RELEASE</version>
			<type>pom</type>
			<scope>import</scope>
		</dependency>
	</dependencies>
</dependencyManagement>
```

#### 使用Gradle构建安装

```
plugins {
	id 'org.springframework.boot' version '2.0.0.RELEASE'
	id 'java'
}


jar {
	baseName = 'myproject'
	version =  '0.0.1-SNAPSHOT'
}

repositories {
	jcenter()
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	testCompile("org.springframework.boot:spring-boot-starter-test")
}
```

## 4.使用Spring Boot

### 构建方式
    maven 或者 gradle 具体使用方式见上面 以及很少用的Ant
    
#### starters
    Starters 是一组方面的依赖描述，你可以在你的程序中引入他们。Spring Boot Starters 为您所需的所有Spring和相关技术提供一站式商店，而不必搜索示例代码和复制粘贴的依赖描述符。
    
    例如： 如果你想使用Spring和Spring JPA作为数据库访问，引入spring-boot-starter-data-jpa到你的项目。
 
## 5. 优化代码结构

#### 避免使用默认包
    推荐使用域名颠倒写法，如：com.example.project
    
#### 定位主程序类(Main Application Class)

    我们一般建议您将主应用程序类定位在其他类之上的根包中。EnableAutoConfiguration注解往往是放在你的主类，它隐含地定义了一个 “包搜索” 选项。
    
```
com
 +- example
     +- myapplication
         +- Application.java
         |
         +- customer
         |   +- Customer.java
         |   +- CustomerController.java
         |   +- CustomerService.java
         |   +- CustomerRepository.java
         |
         +- order
             +- Order.java
             +- OrderController.java
             +- OrderService.java
             +- OrderRepository.java
```

    你必须在你所有的含有@Configration注解的类里面含有一个
    @EnableAutoConfiguration或者@SpringBootApplication的注解。
    
    使用@ImportResource(locations={"classpath:spring-conf01.xml"})来引入
    xml文件的配置，示例如下：
    
    @ImportResource(locations = {"classpath:spring-xml02.xml"})
    public class XmlImport {
    }
    
    推荐将@EnableAutoConfiguration加在主要的@Configration类上。
    
    排除不需要的配置使用
    @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
    
    @Import(value={DataSourceConfig.class,RouteConfig.class})手动引入你需要的配置类
    
    
## Spring Boot特征

#### SpringApplication

    SpringApplication 类提供了一个便捷的方式引导启动（自举）一个Spring程序。从main()方法启动。在大多数场景下，你可以代理到一个静态的方法SpringApplication.run,如下所示：
    
```java
public static void main(String[] args) {
    SpringApplication.run(MySpringConfiguration.class, args);
}
```

#### 启动失败

    如果你的程序启动失败，可以注册FailureAnalyzers来提供一个专门的错误信息和具体的动作来解决这个问题.
    
#### 自定义Banner
    
    banner是在启动时被打印的，可以通过添加一个banner.txt到classpath下或者设置spring.banner.location属性去定位这个文件改变banner。
    如果文件不是UTF-8编码的，你可以设置spring.banner.charset设置编码。除了文本文件，你也可以添加一个banner.gif banner.jpg 或者banner.png 图片文件到classpath 或者设置spring.banner.image.location属性。
    图片汇北转化为ASCII艺术呈现并打印在任何文本banner上。
    
    你也可以使用spring.main.banner-mode属性(off on)决定是否显示banner等
    
#### 定制SpringApplication

    如果SpringApplication默认满足不了你的胃口，你可以创建一个本地定制实例，例如，下面这个就设置了=关闭banner：
```java
public static void main(Strring[] args) {
    SpringApplication app = new SpringApplication(MySpringConfiguration.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(args);
}
```

#### 流畅的构造器(Builder)API

    直接上示例：
```java
new SpringApplicationBuilder()
		.sources(Parent.class)
		.child(Application.class)
		.bannerMode(Banner.Mode.OFF)
		.run(args);
```
    
    
#### 事件(Events)和监听器(Listeners)

    除了常见的Spring Framework 事件，比如ContextRefreshEvent, 一个SpringApplication还发送了一些额外的程序事件。
    
> 有些事件其实在ApplicationContext创建好前触发，所以你不能够通过@Bean注册一个该类监听器。你可以注册他们使用SpringApplication.addListeners(...)方法或者
SpringApplicationBuilder.listeners(...)方法
如果你想这些监听器自动注册，不关系程序的创建方式，你可以添加一个META-INF/spring.factories文件到你的项目并引用你的监听器通过使用
org.springframework.context.ApplicationListener key，如下所示：
org.springframework.context.ApplicationListener = com.example.project.MyListener

    
    当应用程序运行时，事件按以下顺序发送：
    
   1. ApplicationStartingEvent被发送在程序启动前，除开注册监听器后初始化
   2. ApplicationEnvironmentPreparedEvent被发送当 环境（Environment）被用于上下文，但是上下文(context)还未创建
   3. ApplicationPreparedEvent 上下文context已经准备完毕 ，可以通过ApplicationPreparedEvent获取到ConfigurableApplicationContext实例对象。ConfigurableApplicationContext类继承ApplicationContext类，但需要注意这个时候spring容器中的bean还没有被完全的加载，因此如果通过ConfigurableApplicationContext获取bean会报错的。
   4. ApplicationStartedEvent 
   5. ApplicationReadyEvent 
   6. ApplicationFailedEvent 
   
   
#### Web环境
    setWebEnvironment(boolean webEnvironment) 设置web是否可用
    
#### 获取应用程序参数

```java
import org.springframework.boot.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*

@Component
public class MyBean {

	@Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		List<String> files = args.getNonOptionArgs();
		// if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
	}

}
```


#### 使用 ApplicationRunner 或者 CommandLineRunner

    如果你想运行一些特殊的代码在SpringApplication已经启动后，你可以实现ApplicationRunner或者CommandLineRunner接口。两个接口都包含单一的run方法
    当SpringApplication.run(...)完成后被调用。
    
    
#### Application Exit

    每个SpringApplication将在JVM上注册一个关闭钩子，以确保ApplicationContext在退出时优雅地关闭。所有标准的Spring生命周期回调(例如DisposableBean接口，或者@PreDestroy 注释)都可以使用。
    
    此外，bean还可以实现 org.springframework.boot.ExitCodeGenerator SHI
    
#### Admin Features
    
    程序可以通过指定 spring.application.admin.enabled 属性来开启admin相关的特性。这将暴露SpringApplicationAdminMXBean在MBeanServer平台上。
    你可以通过这些特性远程管理你的Spring Boot程序。这些特性在服务的包装实现上也比较有用！
    
> 由于暴露的MBean同时也暴露了关闭该应用的shutdown方法，请慎重的选择是否开启该特征，
    
#### Externalized Configuration 外部化配置

    Spring Boot 外部化你的配置以便让相同的代码可以在不同的环境中允许。你可以使用properties配置文件、YAML文件、环境变量以及命令行参数让配置外部化。
    属性值可以通过@Value注解注入到你的bean中， 通过Spring的Environment访问，或者通过@ConfigurationProperties绑定到结构化对象上。
    
    Spring Boot 使用一个非常特别的PropertySource顺序，目的是让理智压倒一切的价值观。属性按以下顺序加载获取：
    
    1. 在你的用户目录（~/.spring-boot-devtools.properties）下的开发者工具配置 Devtools global setting properties
    2. 在你测试用例上的 @TestPropertySource 注解
    3. 在你测试用例上的 @SpringBootTest#properties 注解
    4. 命令行参数
    5. 从SPRING_APPLICATION_JSON里面获取的配置(inline JSON 嵌入到一个环境变量或者系统属性中)
    6. ServletConfig 初始化参数（init parameters）
    7. ServletContext 初始化参数 
    8. JNDI 属性从 java:comp/env
    9. Java 系统配置 (System.getProperties())
    10.系统（OS）环境变量
    11.一个RandomValuePropertySource 中含有random.*的属性
    12.在jar包外部的 Profile-specific application properties （application-{profile}.properties 和 YAML 变量）
    13.在jar包内部的 Profile-specific application properties （application-{profile}.properties 和 YAML 变量）
    14.在jar包外的应用程序配置（application.properties和YAML变量）
    15.在jar包内的应用程序配置（application.properties和YAML变量）
    16.在你的@Configuration类上的@PropertySourtce注解
    17.默认配置(通过SpringApplication.setDefaultProperties指定)
    
#####  配置随机值
    
       RandomValuePropertySource在注入随机值是非常有用的，它能够参数整数、长整型数，uuid以及uuid ,如下所示：
    
```properties
my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.uuid=${random.uuid}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024, 65536]}

```
    random,int*的语法是 OPEN value (,max) CLOSE
##### 获取命令行配置
    默认情况下SpringApplication转化任何命令行选项参数(参数以--开始，比如: --server-port=9000)到一个property同事添加它们到Spring 的 Environment。
    正如上文提到的命令行参数总是优先于其他属性源
    如果你不想命令行属性被添加到Environment，你可以禁止它们通过调用 SpringApplication.setAddCommandLineProperties(false)
    
##### Application Property文件

    SpringApplication 从以下的位置加载 application.properties 文件配置 并将其添加到Environment :
    
    1. 当前目录下的 /config 子目录
    2. 当前目录
    3. classpath下的/config包
    4. classpath的根目录
    
    改列表是按照优先级高低执行，优先级高德可以覆盖优先级低的配置。
    
##### 指定profile配置
```properties
spring.profiles.active=XXX
```
    还可以通过程序之地ing加载的配置文件
```java
SpringApplication.setAdditionalProfiles(...)
```
##### 配置中的占位符
```properties
app.name=my blog
app.slogan.desc=welcome to  ${app.name}
```
##### 使用YAML 代替properties

YAML:
```yaml
spring: 
    datasource: 
      url: jdbc:mysql://127.0.0.1/test1
      username: root
```

properties:
```properties
spring.datasource.url=jdbc:mysql://127.0.0.1/test1
spring.datasource.username=root
```

##### 类型安全配置(Type-safe Configuration)

    通过指定配置文件里的配哦之前缀，将配置自动绑定到Bean
    
```java
@ConfigurationProperties(prefix="another")
@Bean
public AnotherComponent annotherComponent() {
    private String name;
    //...
    public String getName() {
        return this.name;
    }
    
    public String setName(String name) {
        this.name = name;
    }
    //...
}
```

#### 日志 (Logging) 
    
    Spring Boot 使用Commons Logging 在所有内部日志记录，但开放了日志实现的接口。默认提供了Java Util Logging，Log4J2和Logback。日志默认输出是通过console控制台，也可以选择文件输出。
    
    默认地，如果你使用“Starters”， Logback用于日志记录。还包括适当的Logback路由，以确保使用Java Util日志记录、Commons Logging、Log4J或SLF4J的依赖库都能正常工作。
    
    
##### 格式化日志

    2018-03-05 10:57:51.112  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52
    
    通常日志输出包括以下选项：
- 日期和时间：毫秒级别精度，可以排序的
- 日志级别： ERROR，WARN，DEBUG和TRACE
- 进程ID
- --- 分隔度来区分实际的日志消息
- 线程名称：使用方阔号括起来的（可能被截断）
- Logger名称: 记录日之源的类名(通常缩写)
- 日志消息


    
 ##### 控制台输出
 
    java -jar myapp.jar --debug 
    或者 application.propeerties 中 debug=true
    
    方便调试
    
- 指定控制台输出颜色
 
```properties
spring.output.ansi.enabled=always|detect|never
```



##### 文件输出

    默认Spring Boot日志金通过控制台输出，不会写入到日志文件。可以通过logging.file或者logging.path属性指定日志文本
    
```properties
logging.file=my.log #当前目录下的my.log文件
logging.path=/var/log #写入spring.log到指定目录

logging.level.root=WARN
logging.level.org.springframework.web=DEBUG
logging.level.org.hibernate=ERROR
```