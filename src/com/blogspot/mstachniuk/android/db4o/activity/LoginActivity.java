/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.activity;

import com.blogspot.mstachniuk.android.db4o.logic.CanNotLoginUserException;
import com.blogspot.mstachniuk.android.db4o.logic.LoginUserService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.blogspot.mstachniuk.android.db4o.R;

/**
 *
 * @author staszek
 */
public class LoginActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.login);
        initButtons();
    }

    private void initButtons() {
        Button loginButton = (Button) findViewById(R.idLogin.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                loginUserAction();
            }
        });
    }

    private void loginUserAction() {
        EditText loginEntry = (EditText) findViewById(R.idLogin.loginEntry);
        EditText passwordEntry = (EditText) findViewById(R.idLogin.passwordEntry);
        LoginUserService loginUserService = new LoginUserService(this);
        String login = loginEntry.getText().toString();
        String password = passwordEntry.getText().toString();

        try {
            loginUserService.loginUser(login, password);
            showSuccess();
            goToAfterLoginScreen();
        } catch (CanNotLoginUserException ex) {
            showError(ex);
        }
    }

    private void showSuccess() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Login success!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private void showError(CanNotLoginUserException ex) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Bad login or password\n", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private void goToAfterLoginScreen() {
        Intent intent = new Intent(this, AfterLoginActivity.class);
        startActivityForResult(intent, MODE_PRIVATE);
    }
}
