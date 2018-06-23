# how to run
    *   java 1.8 (java -version)
    *   install maven(mvn -version)
    *   install lombok plugin and enable annotation process
    *   add dependency


# proxy
#### Articles

   *   [理解动态代理及动态代理在RPC中的应用](!https://blog.csdn.net/nyyjs/article/details/77850523)

# cache pool (by semaphore)
   * init some factory object or http client object and so on.
   * Design two Map to study cache pool ,also we can know master/slave(mysql).   

#   async 
    > RPC

# 责任链模式
    |------------ ------------ -------- -------- --------- --------
    |request --->|handler ---> handler ---> handler ----> handler |
    |------------ ------------ -------- -------- --------- --------
    
    1. A request will be handle by handlers one by one . 
        1. handled successful , then return or execute something
        2. handle by next .
    
# Iteator
    one interface and many sub class , we can add a middle ware handling the diff

# 策略模式
策略模式就是在进行‘计算’，‘比较’的时候不要将具体的比较（计算）策略写死，而是动态根据上下文的情况具体的策略进行运算，从而具有了较强的拓展性.
	eg：jdk提供的comparable<E> 和 comparator<E> 的比较大小的问题电商系统进行打折的时候，有很多的打折规则，也可以使用策略模式来实现。

# 观察者模式
观察者模式中核心理念就是化主动为被动，将我去主动处理他，换成他主动来被处理。大体上是在被观察者身上添加一个监听。要明白观察者和被观察者之间的关系

# reactor模式
要理解nio.pdf中描述的 `reactor pattern`  
*具体查看https://github.com/iluwatar/java-design-patterns

# 适配器模式
在查看 `Spring` 中的 `HandlerMapping` 和 `HandlerAdapter` 时发现了适配器的使用


# 加入监听器 
    
   *   事件驱动监听器.根据某个时间触发
       
        `tomcat` 组件启动, `blade` 触发某个时间，参数可以自行定义，具体的触发可以根据业务，组件进行

   *   监听启动. 仅执行一次
    
        `Listener` Servlet 规范
        
        适用于自定义实现的监听器(系统监听器是容器提供/类似于容器的框架实现)    
    
    
# add thread pool
    
   *  extend thread poll by changing some variables about thread pool(name,deamon..etc) 
    in order to print log or ...