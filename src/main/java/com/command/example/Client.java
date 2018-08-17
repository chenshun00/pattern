package com.command.example;

/**
 * 命令模式具体场景引用
 * <p>
 * client指代我
 * invoke 代表终端
 * receiver 代表内核
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/17
 */
public class Client {
    public static void main(String[] args) {
        //需要执行的命令
        Command command = new LsCommand("ls");
        //获取终端，并将执行命令告诉终端
        Terminal terminal = new Terminal(command);
        //终端运行，内部还是交给内核去执行
        terminal.run();
    }
}
