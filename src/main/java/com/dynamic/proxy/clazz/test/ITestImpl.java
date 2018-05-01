package com.dynamic.proxy.clazz.test;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>description:</p>
 *
 * @author 竹
 *         on 2018/5/1.
 */
@Slf4j
public class ITestImpl implements ITest {
    @Override
    public String test(String name) {
        log.info("hello {}",name);
        return name;
    }
}
