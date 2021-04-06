package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {
    EditText usr, email, alamat, pwd, repwd;
    Button btnregis, btnbatal;
    CheckBox jeniskelamin, agama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        btnregis = findViewById(R.id.rbtndaftar);
        btnbatal = findViewById(R.id.rbtnbatal);
        usr = findViewById(R.id.rdtnama);
        email = findViewById(R.id.rdtemail);
        alamat = findViewById(R.id.rdtalamat);
        pwd = findViewById(R.id.rdtpassword);
        repwd = findViewById(R.id.rdtrepassword);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usr.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pwd.getText().toString().isEmpty() ||
                        repwd.getText().toString().isEmpty()) {
                    email.setError("Masukkan Email");
                    alamat.setError("Masukkan Alamat");
                    pwd.setError("Masukkan Password");
                    repwd.setError("Masukkan Ulang Password");
                } else {
                    if (pwd.getText().toString().equals(repwd.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    } else {
                        Snackbar.make(view, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}