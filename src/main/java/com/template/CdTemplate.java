package com.template;

import lombok.extern.slf4j.Slf4j;

/**
 * @author chenshun00@gmail.com
 * @since 2018/8/5
 */
@Slf4j
public class CdTemplate extends AbstractTemplate {

    public CdTemplate(String command) {
        super(command);
    }


    @Override
    public void doCommand(String command) {
        log.debug("run {} command,the result is {}", this.getCommand(), "from /User/chenshun/Desktop to /User/chenshun/");
    }
}
