package com.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 装饰器模式:核心就是对一个类进行增强
 * <p>
 * 但是又不能改变这个类的行为，也就是这里的女孩还是要去旅行，还是要回家的，不能因为你装饰了女孩就去网吧上网了，不回家了
 * 也就是装饰者不能概念目标类的行为。只能对这个行为作出一些处理。
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/15
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        PrettyGirl prettyGirl = new SpecificPrettyGirl();
        prettyGirl.traver();
        prettyGirl.back();

        log.debug("------------使用装饰者之前----------");

        PrettyGirl girl = new DetailDecorator(new SpecificPrettyGirl());
        girl.traver();
        girl.back();
    }
}
