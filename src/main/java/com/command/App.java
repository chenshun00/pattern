package com.command;

/**
 * 命令模式
 *
 * @author luobo.cs@raycloud.com
 * @since 2018/8/16
 */
public class App {
    public static void main(String[] args) {
        //定义接受者，具体实施行为的对象，这里是学生(学生才是最终上课的实施对象)
        Receiver receiver = new Receiver("1年纪学生");
        //定义命令，实际实施命令的对象，命令存在一个实施者
        Command command = new ConcreteCommand("上课", receiver);
        //调用者，命令的管理员
        Invoke invoke = new Invoke(command);
        //执行命令(看上去是执行，其实具体的执行得交给receiver去做)
        invoke.run();

        //Runnable就是一个典型的命令模式
        //Runnable 是command接口，具体的实际就是具体的命令
        //thread 就是调用者，命令的接受者,具体命令的执行者就是虚拟机
        //invoke      申明命令               实现具体的命令            invoke执行命令
        new Thread(     ()    ->     System.out.println("hello") ).start();
    }
}
