package com.example.user_pc.testsktl.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user_pc.testsktl.R;
import com.example.user_pc.testsktl.homework1.Dz1Activity;

/**
 * Created by USER-PC on 26.07.2017.
 */

public class Classwork2Activity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_classwork2);


        final EditText username = (EditText) findViewById(R.id.usernameText);
        final EditText password = (EditText) findViewById(R.id.passwordText);
        Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                только так нужно передовать инфу в активити через интент
                Intent intent = new Intent(Classwork2Activity.this, Dz1Activity.class);
                intent.putExtra(Dz1Activity.KEY_USERNAME, username.getText().toString());
                intent.putExtra(Dz1Activity.KEY_PASSWORD, password.getText().toString());
                startActivity(intent);
            }
        });
    }
}
