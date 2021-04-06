package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edEmail, edPassword;
    Button btnLogin, btnRegis;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        btnRegis = findViewById(R.id.btnRegis);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Pendaftaran.class);
                startActivity(i);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                nama = edEmail.getText().toString();
                password = edPassword.getText().toString();
                String email = "admin@mail.com";
                String pass = "123";

                if (nama.isEmpty() && password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(), "Masukkan Email dan Password", Toast.LENGTH_LONG);
                    edEmail.setError("Masukkan Email");
                    edPassword.setError("Masukkan Password");
                    t.show();
                }
                else if (nama.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Masukkan Email",
                            Toast.LENGTH_LONG);
                    edEmail.setError("Masukkan Email");
                    t.show();
                } else if (password.isEmpty()) {
                    edPassword.setError("Masukkan Password");


                } else {

                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);

                        i.putExtras(b);

                        startActivity(i);

                    } else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();

                    }
                }
            }
        });
    }
}


