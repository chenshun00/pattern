package com.builder;

import java.io.Serializable;
import java.util.Date;

/**
 * 一个简单的builder，在很多field的情况下会提高可阅读性，不适合参数较少的情况
 *
 * @author chenshun00@gmail.com
 * @since 2018/8/9
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3031056354692884466L;

    private Integer userId;
    private String username;
    private String nick;
    private String email;
    private String phone;
    private Date birthday;
    private Date register;
    private Date lastLogin;
    private Integer integral;
    private Integer loginCount;


    public User() {
    }

    public User(Integer userId, String username, String nick, String email, String phone, Date birthday, Date register, Date lastLogin, Integer integral, Integer loginCount) {
        this.userId = userId;
        this.username = username;
        this.nick = nick;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.register = register;
        this.lastLogin = lastLogin;
        this.integral = integral;
        this.loginCount = loginCount;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        private static Integer userId;
        private static String username;
        private String nick;
        private String email;
        private String phone;
        private Date birthday;
        private Date register;
        private Date lastLogin;
        private Integer integral;
        private Integer loginCount;

        public  User build() {
            return new User(this.userId, this.username, this.nick, this.email, this.phone, this.birthday, this.register, this.lastLogin, this.integral, this.loginCount);
        }

        public UserBuilder birthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder register(Date register) {
            this.register = register;
            return this;
        }

        public UserBuilder lastLogin(Date lastLogin) {
            this.lastLogin = lastLogin;
            return this;
        }

        public UserBuilder integral(Integer integral) {
            this.integral = integral;
            return this;
        }

        public UserBuilder loginCount(Integer loginCount) {
            this.loginCount = loginCount;
            return this;
        }


        public UserBuilder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder nick(String nick) {
            this.nick = nick;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
    }

    //getter and setter
    public  Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegister() {
        return register;
    }

    public void setRegister(Date register) {
        this.register = register;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", register=" + register +
                ", lastLogin=" + lastLogin +
                ", integral=" + integral +
                ", loginCount=" + loginCount +
                '}';
    }
}
