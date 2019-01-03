package com.builder;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * builder pattern，我们能使用lombok的@Builder去简化
 *  ⚠️:最后的build是直接通过构造方法返回的，所以需要添加默认的构造方法，防止使用mybatis等orm的时候反射构建对象失败
 * @author chenshun00@gmail.com
 * @since 2018/8/9
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        log.debug("builder pattern:{}", User.builder()
                .userId(1)
                .username("chenshun")
                .nick("chenshun00")
                .email("chenshun00@gamil.com")
                .integral(1111)
                .birthday(new Date())
                .lastLogin(new Date())
                .loginCount(89)
                .phone("1111111")
                .build());
    }
}
