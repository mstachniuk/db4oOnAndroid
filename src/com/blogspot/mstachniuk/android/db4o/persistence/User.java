/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.persistence;

/**
 *
 * @author mstachni
 */
public class User {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
