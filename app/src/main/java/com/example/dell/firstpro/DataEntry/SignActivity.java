package com.example.dell.firstpro.DataEntry;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.firstpro.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignActivity extends AppCompatActivity {

    EditText email,pass;
    Button ok;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();

        email=findViewById(R.id.emailT);
        pass=findViewById(R.id.passt);
        ok =findViewById(R.id.login);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=email.getText().toString().trim();
                String password=pass.getText().toString().trim();

                auth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(SignActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                            startActivity(new Intent(SignActivity.this, loginActivity.class));
                        else
                            Toast.makeText(getBaseContext(),"Auth failed ",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
