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
public class LoginUserService {

    private Context context;

    public LoginUserService(Context context) {
        this.context = context;
    }

    public User loginUser(String login, String password) throws CanNotLoginUserException {
        UserDao userDao = new UserDao(context);
        List<User> users = userDao.getByNameAndPassword(login, password);
        if(users.size() != 1) {
            throw new CanNotLoginUserException("I can't login user, becouse in database exist "
                    + users.size() + " users with this same data.");
        }
        return users.get(0);
    }
}
