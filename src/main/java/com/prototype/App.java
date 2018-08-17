package com.prototype;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * description:原型模式，主要是重复利用现在的实例对象，而不是重新new一个
 * 原型模式主要是在它的基础上重新拷贝了一份数据，但是其中又区分为[深拷贝] 和[浅拷贝]
 * <p>
 * 深拷贝:一人一份，你用你的，我用我的，但是所有的数据都要拷贝一次，例如定义的List或者Map，
 * 都要调用list.clone() 或者 map.clone()
 * <p>
 * 浅拷贝:新产生的对象和原有对象共享引用对象，你改我也改的意思(String以及几个包装类型除外)
 * <p>
 * java实现原型模式仅需要实现 Cloneable 接口表示这个是可以clone的即可，然后复写Object的clone()方法
 *
 * clone方法是不会去调用构造器方法的，并且有如下格式
 * x.clone() != x ; x.clone().getClass() == x.getClass();
 * 这个不是通用的要求，但是最基本的是 x.clone().equals(x)
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/14
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        Pojo pojo = new Pojo();
        pojo.setKey(111L);
        pojo.setName("chenshun00");
        Pojo clone = pojo.clone();
        pojo.setBirthday(new Date());
        pojo.setUserId(111);
        log.debug("拷贝前的数据:{}", pojo);
        log.debug("拷贝后的数据:{}", clone);
    }
}
