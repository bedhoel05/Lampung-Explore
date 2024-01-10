package com.example.visitinglampung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visitinglampung.akomodasi.mainAkomodasi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class loginActivity extends AppCompatActivity {

    Button btn_login;
    TextView txt_to_register, txt_forgot_pass;
    EditText et_user, et_pass;
    FirebaseAuth firebaseAuth;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_login = findViewById(R.id.btn_login);
        txt_forgot_pass = findViewById(R.id.txt_forgotPassword);
        txt_to_register = findViewById(R.id.txt_to_register);
        et_user = findViewById(R.id.et_login_username);
        et_pass = findViewById(R.id.et_login_password);
        firebaseAuth = firebaseAuth.getInstance();


        btn_login.setOnClickListener(v-> {
            firebaseAuth.signInWithEmailAndPassword(et_user.getText().toString(),et_pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Intent goLogin = new Intent(loginActivity.this, successActivity.class);
                        goLogin.putExtra("namaActiity", "Login");
                        startActivity(goLogin);
                    }else{
                        if (et_pass.length() < 8) {
                            // Password tidak memenuhi panjang minimum, tampilkan pesan kesalahan
                            et_pass.setError("Minimal 8 karakter diperlukan untuk password!");
                        } else {
                        Toast.makeText(loginActivity.this, "Email atau password salah", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        });

        txt_to_register.setOnClickListener(v-> {
            Intent goRegister = new Intent(loginActivity.this, registerActivity.class);
            goRegister.putExtra("namaActiity", "Register");
            startActivity(goRegister);
        });

        txt_forgot_pass.setOnClickListener(v-> {
            Intent goForgot = new Intent(loginActivity.this, registerActivity.class);
            goForgot.putExtra("namaActiity", "Silahkan Forgot Password");
            startActivity(goForgot);
        });

    }
}