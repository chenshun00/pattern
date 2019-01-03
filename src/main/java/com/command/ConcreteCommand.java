package com.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 具体的命令
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/16
 */
@Slf4j
@Data
@AllArgsConstructor
public class ConcreteCommand implements Command {

    @Override
    public void execute() {
        log.debug("开始执行命令");
        receiver.doCommand(command);
        log.debug("执行命令完毕");
    }

    private String command;
    private Receiver receiver;
}
