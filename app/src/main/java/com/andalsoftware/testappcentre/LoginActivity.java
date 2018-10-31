package com.andalsoftware.testappcentre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private Button btnLoginUser;
    private EditText editTextUsername, editTextPassword;
    private String username = "", password= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLoginUser = (Button) findViewById(R.id.btnLoginUser);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        btnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginUser();
            }
        });
    }

    private void loginUser()
    {
        username = editTextUsername.getText().toString();
        password = editTextPassword.getText().toString();

        if (username.isEmpty() && password.isEmpty()) {
            Toast.makeText(LoginActivity.this, getString(R.string.msg_please_fill), Toast.LENGTH_SHORT).show();
        } else if (username.equals("admin") && password.equals("admin123")) {
            Toast.makeText(LoginActivity.this, getString(R.string.msg_login_success), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(LoginActivity.this, getString(R.string.msg_login_failed), Toast.LENGTH_SHORT).show();
        }
    }
}