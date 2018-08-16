package com.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 命令的管理者
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/16
 */
@Data
@AllArgsConstructor
@Slf4j
public class Invoke {

    private Command command;

    public void run(){
        log.debug("执行者调用命令，开始执行");
        command.execute();
    }

}
