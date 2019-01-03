package com.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体的装饰者
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/15
 */
@Slf4j
public class DetailDecorator extends Decorator {

    public DetailDecorator(PrettyGirl prettyGirl) {
        super(prettyGirl);
    }

    @Override
    public void traver() {
        log.debug("女孩开始收拾东西，准备去高铁站!");
        super.traver();
    }

    @Override
    public void back() {
        log.debug("女孩拍照片，开始准备回家");
        super.back();
    }
}
