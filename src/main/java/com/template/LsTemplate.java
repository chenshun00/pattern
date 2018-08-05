package com.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * concreteTemplate:ls command
 * </p>
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/5
 */
@Slf4j
public class LsTemplate extends AbstractTemplate {

    public LsTemplate(String command) {
        super(command);
    }

    @Override
    public void doCommand(String command) {
        log.debug("run {} command,the result is {}", this.getCommand(), "a , b, c , a.html");
    }
}
