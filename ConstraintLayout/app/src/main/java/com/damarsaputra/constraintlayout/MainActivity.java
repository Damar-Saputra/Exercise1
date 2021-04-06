package com.damarsaputra.constraintlayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.damarsaputra.constraintlayout.R;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnDaftar){
            Intent i = new Intent(getApplicationContext(), Pendaftaran.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    Button btsignin;
    EditText edemail, edpassword;
    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsignin = findViewById(R.id.btSignin);
        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);

        btsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edemail.getText().toString();
                password = edpassword.getText().toString();
                String name = "Damar";
                String pass = "damar123";

                if (name.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Masukkan Email dan Password",
                            Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if (name.equals(name) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil",
                                Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();
                        b.putString("a", name.trim());
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