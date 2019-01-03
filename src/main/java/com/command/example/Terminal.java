package com.command.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenshun00@gmail.com
 * @since 2018/8/17
 */
@Data
@Slf4j
@AllArgsConstructor
public class Terminal {
    private Command command;

    public void run(){
        command.execute();
    }

}
