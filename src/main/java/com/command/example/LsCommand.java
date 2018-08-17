package com.command.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/8/17
 */
@Slf4j
public class LsCommand extends Command {

    private Kernel kernel;

    public LsCommand(String name) {
        super(name);
        kernel = new Kernel(Objects.requireNonNull(name, "command can't be null!"));
    }

    @Override
    public void execute() {
        log.debug("内核开始执行{}命令", this.getName());
        kernel.doAction();
    }
}
