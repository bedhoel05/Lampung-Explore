package com.example.visitinglampung;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {

    Button btn_register;
    TextView txt_login, txt_user, txt_mail, txt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);
        txt_user = findViewById(R.id.et_reg_username);
        txt_mail = findViewById(R.id.et_reg_mail);
        txt_pass = findViewById(R.id.et_reg_password);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                firebaseAuth.createUserWithEmailAndPassword();
            }
        });

//        btn_register.setOnClickListener(v-> {
//            firebaseAuth.createUserWithEmailAndPassword(txt_mail.getText().toString(), txt_pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    Toast.makeText(registerActivity.this, task.toString(), Toast.LENGTH_SHORT).show();
//                    if(task.isSuccessful()) {
//                       Toast.makeText(registerActivity.this, "nathan gagal", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(registerActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
//                        Intent goRegister = new Intent(registerActivity.this, successActivity.class);
//                        goRegister.putExtra("namaActiity", "Register");
//                        startActivity(goRegister);
//                    }else{
//                        Toast.makeText(registerActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                        Toast.makeText(registerActivity.this, "regist gagal", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        });

//        txt_login.setOnClickListener(v-> {
//            Intent goLogin = new Intent(registerActivity.this, loginActivity.class);
//            goLogin.putExtra("namaActiity", "Halaman Login");
//            startActivity(goLogin);
//        });
    }
}