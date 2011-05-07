/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.activity;

import com.blogspot.mstachniuk.android.db4o.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.blogspot.mstachniuk.android.db4o.logic.AfterLoginService;
import com.blogspot.mstachniuk.android.db4o.persistence.User;
import java.util.List;

/**
 *
 * @author staszek
 */
public class AfterLoginActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.afterlogin);
        showAllUsers();
    }

    private void showAllUsers() {
        AfterLoginService service = new AfterLoginService(this);
        List<User> allUsers = service.getAllUsers();

        TextView textView = (TextView) findViewById(R.id.afterLoginLabel);
        textView.setText("Available users:\n");
        for(User user : allUsers) {
            textView.append(user.getLogin() + "\n");
        }
    }

}
