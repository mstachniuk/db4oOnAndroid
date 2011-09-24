/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.blogspot.mstachniuk.android.db4o.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.blogspot.mstachniuk.android.db4o.R;
import com.blogspot.mstachniuk.android.db4o.dao.Db4oHelper;

/**
 *
 * @author mstachni
 */
public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.main);

        initButtons();
    }

    private void initButtons() {
        Button createNewUserButton = (Button) findViewById(R.idMainMenu.createNewUser);
        createNewUserButton.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateNewUserActivity.class);
                startActivityForResult(intent, MODE_PRIVATE);
            }
        });

        Button loginButton = (Button) findViewById(R.idMainMenu.loginButton);
        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivityForResult(intent, MODE_PRIVATE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        Db4oHelper db4oHelper = new Db4oHelper(this);
        db4oHelper.close();
        super.onDestroy();
    }


}
