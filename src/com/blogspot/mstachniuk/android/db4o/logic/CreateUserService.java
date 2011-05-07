/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.logic;

import android.content.Context;
import com.blogspot.mstachniuk.android.db4o.dao.UserDao;
import com.blogspot.mstachniuk.android.db4o.persistence.User;
import java.util.List;

/**
 *
 * @author staszek
 */
public class CreateUserService {

    private final Context context;

    public CreateUserService(Context context) {
        this.context = context;
    }

    public void createUser(String login, String password) throws CanNotCreateUserException {
        UserDao userDao = new UserDao(context);
        List<User> users = userDao.getByLogin(login);
        if(!users.isEmpty()) {
            throw new CanNotCreateUserException("User with login: " + login + " exist in database.");
        }
        User user = new User(login, password);
        userDao.saveOrUpdate(user);
    }

}
