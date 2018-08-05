package com.template;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * template pattern:the abstract template
 * </p>
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/5
 */
@Slf4j
public abstract class AbstractTemplate {

    @Getter
    @Setter
    private String command;

    public AbstractTemplate(String command) {
        this.command = command;
        log.debug("define a {} command", this.command);
    }

    public void runDetailCommand() {
        doCommand(this.command);
    }

    protected abstract void doCommand(String command);
}
