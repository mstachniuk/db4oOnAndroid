/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.activity;

import com.blogspot.mstachniuk.android.db4o.logic.*;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.blogspot.mstachniuk.android.db4o.R;
import com.blogspot.mstachniuk.android.db4o.dao.Db4oHelper;

/**
 *
 * @author staszek
 */
public class CreateNewUserActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.createuser);
        initButtons();
    }

    private void initButtons() {
        Button createButton = (Button) findViewById(R.idCreateUserMenu.createButton);
        createButton.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                createUserAction();
            }
        });
    }

    private void createUserAction() {
        EditText loginEntry = (EditText) findViewById(R.idCreateUserMenu.loginEntry);
        EditText passwordEntry = (EditText) findViewById(R.idCreateUserMenu.passwordEntry);
        CreateUserService createUserService = new CreateUserService(this);
        String login = loginEntry.getText().toString();
        String password = passwordEntry.getText().toString();
        try {
            createUserService.createUser(login, password);
            showSuccess();
        } catch (CanNotCreateUserException ex) {
            showError(ex);
        }
    }

    private void showSuccess() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Add new user success!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private void showError(CanNotCreateUserException ex) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "I can't create new user.\n" + ex.getMessage(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
}
