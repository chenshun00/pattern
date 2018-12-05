package com.cglib;

import com.cglib.aop.UserService;

/**
 * <p>description:</p>
 *
 * @author 竹
 * on 2017/10/15.
 */
public class RealSubject implements ISubjectService {

    private UserService userService;

    public String name ;//= "chen";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void doService() {
        System.out.println("doService ing。。。。");
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
