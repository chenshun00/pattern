package com.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 命令的接受者
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/16
 */
@Slf4j
@Data
@AllArgsConstructor
public class Receiver {

    private String message;

    public void doCommand(Object object) {
        log.debug("接受者{}开始执行命令:{}", message, object);
    }

}
