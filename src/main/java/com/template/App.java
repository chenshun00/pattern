package com.template;

/**
 * @author chenshun00@gmail.com
 * @since 2018/8/5
 */
public class App {
    public static void main(String[] args) {
        AbstractTemplate template = new CdTemplate("cd ~");
        template.runDetailCommand();

        template = new LsTemplate("ls");
        template.runDetailCommand();

    }
}
