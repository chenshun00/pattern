package com.command.example;

import lombok.Data;

/**
 * @author luobo.cs@raycloud.com
 * @since 2018/8/17
 */
@Data
public abstract class Command {

    private String name;

    protected Command(String name) {
        this.name = name;
    }

    public abstract void execute();

}
