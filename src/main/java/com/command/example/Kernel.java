package com.command.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/8/17
 */
@Slf4j
@Data
@AllArgsConstructor
public class Kernel {

    private String name;

    public void doAction() {
        log.debug("内核执行单个命令:{}", this.name);
    }
}
