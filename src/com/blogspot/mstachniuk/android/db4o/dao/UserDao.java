/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.dao;

import android.content.Context;
import com.blogspot.mstachniuk.android.db4o.persistence.User;
import com.db4o.ObjectContainer;
import java.util.List;

/**
 *
 * @author mstachni
 */
public class UserDao {

    private ObjectContainer db;

    public UserDao(Context context) {
        Db4oHelper db4oHelper = new Db4oHelper(context);
        this.db = db4oHelper.db();
    }

    public void saveOrUpdate(User user) {
        db.store(user);
    }

    public void delete(User user) {
        db.delete(user);
    }

    public List<User> getAll() {
        return db.query(User.class);
    }
    
    public List<User> getByLogin(String login) {
        User example = new User(login, null);
        return db.queryByExample(example);
    }

    public List<User> getByLoginAndPassword(String login, String password) {
        User example = new User(login, password);
        return db.queryByExample(example);
    }
}
