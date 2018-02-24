# Java8新特性学习

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
  
  
## 流式计算(Stream)

    java官方地址： https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#
    
    stream
    
    collection
    
    filter
    
    limit 
    
    count
    
    map
    
    reduce