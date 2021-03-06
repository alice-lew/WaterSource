package com.tristenallen.watersource.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tristenallen.watersource.R;
import android.widget.Button;
import com.tristenallen.watersource.main.MainActivity;
import android.content.Context;
import com.tristenallen.watersource.model.AuthHelper;
import com.tristenallen.watersource.model.AuthPackage;
import com.tristenallen.watersource.model.AuthStatus;
import com.tristenallen.watersource.model.Model;


public class LoginActivity extends AppCompatActivity {
    private EditText usrname;
    private EditText password;
    private AuthHelper verifier;
    private AuthPackage AP;
    private AuthStatus status;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usrname = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        loginButton = (Button) findViewById(R.id.LOGIN_BUTTON);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrnameStr = usrname.getText().toString();
                String passwordStr = password.getText().toString();
                verifier = Model.getAuthHelper();
                AP = verifier.login(usrnameStr, passwordStr);
                status = AP.getStatus();

                if (status == AuthStatus.INVALID_NAME) {
                    Context context = getApplicationContext();
                    CharSequence error = "Invalid UserName!";
                    int duration = Toast.LENGTH_LONG;
                    usrname.setText("");
                    password.setText("");
                    Toast badPass = Toast.makeText(context, error, duration);
                    badPass.show();
                } else if (status == AuthStatus.INVALID_PASSWORD) {
                    Context context = getApplicationContext();
                    CharSequence error = "Invalid password!";
                    int duration = Toast.LENGTH_LONG;
                    password.setText("");
                    Toast badPass = Toast.makeText(context, error, duration);
                    badPass.show();

                } else {
                    Intent goToMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(goToMainActivity);
                }
            }
        });
    }
}