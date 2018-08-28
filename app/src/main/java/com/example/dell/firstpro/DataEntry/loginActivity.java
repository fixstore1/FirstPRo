package com.example.dell.firstpro.DataEntry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dell.firstpro.R;

import java.nio.file.Files;

public class loginActivity extends AppCompatActivity {
EditText mail,pass;
Button sign,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mail= findViewById(R.id.mailSignT);
        pass= findViewById(R.id.passSignT);
        sign=findViewById(R.id.sign);
        login=findViewById(R.id.loginB);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mail.getText().toString().trim();
                String password=pass.getText().toString().trim();

            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,SignActivity.class));
            }
        });
    }
}
