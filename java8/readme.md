# Java8新特性学习

> 可到官网了解更多特性 http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html

## lambda 表达式(lambda expression)

 java官方地址: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 
 lambda表达式允许你将一个函数功能(functionality)视为参数，或者将代码本身(code)视为数据。
 
 类似ES6语法模式
 
 variable -> {}
 
 variable -> statement
 
 (arg, arg2) -> {}
 
 arg -> arg.call()
 
 #### 主要用到一下新特性:
 
 Predicate<T> 接受一个T类型参数 返回boolean值
 Consumer<T> 接收一个T类型参数 返回空
 Function<T, R> 接收一个T类型的参数返回一个R类型的对象
 Supplier<T>  结果提供器，类似工厂方法
 
## 函数方法引用(Method References)

  java官方地址: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
  
  调用方式 ::
  
  #### 存在以下四种方式：
  
  引用方式 | 举例
  ---|---
  引用静态方法(Reference to a static method) | ContainingClass::staticMethodName
  引用特定的示例方法(Reference to an instance method of a particular object) | containingObject::instanceMethodName
  引用特定类型任意对象的实例方法 (Reference to an instance method of an arbitrary object of a particular type) | ContainingType::methodName
  引用构造方法(Reference to a constructor) | ClassName::new
  
  
## 流式计算(Stream API)

    java官方地址： https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#
    
    stream
    
    collection
    
    filter
    
    limit 
    
    count
    
    map
    
    reduce
    
    
## 集合(Collections)

+ 在新的java.util.stream包中的类提供了一个Stream API以支持函数式操作流元素，Stream API被集成到Collections API允许对集合进行批量操作
    例如排序或map-reduce转换
    
+ 提升HashMap的key值得碰撞解决性能， 参考(http://www.importnew.com/20386.html)；用到了红黑树 红黑树参考: https://github.com/julycoding/The-Art-Of-Programming-By-July/blob/master/ebook/zh/03.01.md http://blog.csdn.net/eson_15/article/details/51144079


## 默认方法 

 默认方法就是一个在接口里面有了一个实现的方法。
 
 ```
 interface Executable {
    default void execute(Object param) {
        System.out.println("exe run "+param);
    }
 }
 ```
 
 ## Optional 类
 
 Optional类是java8类库的一部分，用来解决空判断处理及空指针异常处理！
 
 Optional.orElse(other) 如果不为空返回本身，否则返回other
 
 
 ## Nashorn js引擎
 
 可参考: https://docs.oracle.com/javase/8/docs/technotes/guides/scripting/nashorn/
 
 jdk8以后Nashorn取代Rhino 成为java的嵌入式引擎，完全支持ecmascript 5.1规范，并在性能上得到了提升
 
 jdk8 自带了js命令行工具jjs ,可使用jjs命令进入js控制台
 
 ```
 jjs 
 >print("Hello Java8!")
 ```
 
 ## 新的Date-Time API 
 
 可参考: https://docs.oracle.com/javase/8/docs/technotes/guides/datetime/index.html
 
 jdk8 解决了之前的很多问题：
 
 + 非线程安全： java.util.Date是非线程安全的
 + 设计较差： java.util.Date和java.sql.Date 拥有相同的类名
 + 时区处理麻烦：没有时区处理，提供的java.util.Calendar和java.util.TimeZone也有线程安全问题
 
 同时也提供了两个比较重要的API：
 Local(本地) - 简化了日期时间的处理，没有时区问题
 Zoned(时区) - 通过指定的时区处理时间
 
 
 ## Base64编解码
 
 jdk8 将base64编解码类纳入了标准类库，方便使用！