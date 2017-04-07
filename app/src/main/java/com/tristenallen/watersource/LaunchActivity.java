package com.tristenallen.watersource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.tristenallen.watersource.login.LoginActivity;
import com.tristenallen.watersource.login.RegistrationActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLoginScreen = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(goToLoginScreen);
            }
        });

        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSignUpScreen = new Intent(LaunchActivity.this, RegistrationActivity.class);
                startActivity(goToSignUpScreen);

            }
        });
    }
}
