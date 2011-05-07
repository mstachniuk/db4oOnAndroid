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
public class AfterLoginService {

    private Context context;

    public AfterLoginService(Context context) {
        this.context = context;
    }

    public List<User> getAllUsers() {
        UserDao userDao = new UserDao(context);
        return userDao.getAll();
    }
}
