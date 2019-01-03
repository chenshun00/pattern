package com.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体的实现类
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/15
 */
@Slf4j
public class SpecificPrettyGirl implements PrettyGirl {

    @Override
    public void traver() {
        log.debug("女孩去旅行");
    }

    @Override
    public void back() {
        log.debug("女孩旅行回家");
    }
}
