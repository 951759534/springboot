package org.news.router.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by K550jk on 2017/3/24.
 */
public class User implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String pass;

}
