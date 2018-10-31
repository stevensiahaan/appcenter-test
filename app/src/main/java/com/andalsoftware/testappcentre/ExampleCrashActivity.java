package com.andalsoftware.testappcentre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.microsoft.appcenter.crashes.Crashes;

public class ExampleCrashActivity extends BaseActivity {

    private Button btnCrash, btnOK;
    private TextView txtTextHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_crash);
        btnCrash = (Button) findViewById(R.id.btnCrash);
        btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExampleCrashActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
        btnCrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtTextHello.setText(null);
            }
        });
    }
}
