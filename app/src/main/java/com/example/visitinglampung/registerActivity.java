package com.example.visitinglampung;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerActivity extends AppCompatActivity {

    Button btn_register;
    TextView txt_login, txt_user, txt_mail, txt_pass;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);
        txt_user = findViewById(R.id.et_reg_nama);
        txt_mail = findViewById(R.id.et_reg_mail);
        txt_pass = findViewById(R.id.et_reg_password);
        mAuth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                firebaseAuth.createUserWithEmailAndPassword();
            }
        });

        btn_register.setOnClickListener(v -> {
            String password = txt_pass.getText().toString();
            String mail = txt_mail.getText().toString();

            if (password.length() < 8) {
                // Password tidak memenuhi panjang minimum, tampilkan pesan kesalahan
                txt_pass.setError("Minimal 8 karakter diperlukan untuk password!");
            } else {
                Toast.makeText(registerActivity.this, "Password Benar", Toast.LENGTH_SHORT).show();
                mAuth.createUserWithEmailAndPassword(mail, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(registerActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent goRegister = new Intent(registerActivity.this, successActivity.class);
                                    goRegister.putExtra("namaActiity", "Register");
                                    startActivity(goRegister);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(registerActivity.this, "Register Unsuccessfully", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        txt_login.setOnClickListener(v-> {
            Intent goLogin = new Intent(registerActivity.this, loginActivity.class);
            goLogin.putExtra("namaActiity", "Halaman Login");
            startActivity(goLogin);
        });
    }
}