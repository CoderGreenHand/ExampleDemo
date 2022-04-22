package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    //主键id
    private int id;
    //登录用户名
    private String userName;
    //登录密码
    private String password;
    //登录状态
    private String loginSatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginSatus() {
        return loginSatus;
    }

    public void setLoginSatus(String loginSatus) {
        this.loginSatus = loginSatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", loginSatus='" + loginSatus + '\'' +
                '}';
    }
}
