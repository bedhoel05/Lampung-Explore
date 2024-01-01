package com.example.visitinglampung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {

    Button btn_register;
    TextView txt_login, txt_user, txt_mail, txt_pass;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);
        txt_user = findViewById(R.id.et_reg_username);
        txt_mail = findViewById(R.id.et_reg_mail);
        txt_pass = findViewById(R.id.et_reg_password);



        btn_register.setOnClickListener(v-> {
            firebaseAuth.createUserWithEmailAndPassword(txt_mail.getText().toString(), txt_pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(registerActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
                        Intent goRegister = new Intent(registerActivity.this, successActivity.class);
                        goRegister.putExtra("namaActiity", "Register");
                        startActivity(goRegister);
                    }else{
                        Toast.makeText(registerActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        });

        txt_login.setOnClickListener(v-> {
            Intent goLogin = new Intent(registerActivity.this, loginActivity.class);
            goLogin.putExtra("namaActiity", "Halaman Login");
            startActivity(goLogin);
        });
    }
}