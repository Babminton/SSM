package com.model;
/*@program: mybatis
 *@description: User类
 *@author: zeng
 *@create: 2019-06-24 22:00
 */

import java.io.Serializable;

public class User implements Serializable {

    private int userid;
    private String username;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }

}
