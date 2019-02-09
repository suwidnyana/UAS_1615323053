package com.example.uas_1615323053;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Menu;
public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText fieldUsername;
    EditText fieldPassword;
    TextView linkToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //layout

        btnLogin = findViewById(R.id.btnLogin);
        fieldUsername = findViewById(R.id.username);
        fieldPassword = findViewById(R.id.password);
        linkToRegister = (TextView) findViewById(R.id.btnDaftar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Loggin", Toast.LENGTH_LONG).show();

                Database storage = Database.getInstance();
                String username = fieldUsername.getText().toString();
                String password = fieldPassword.getText().toString();

                boolean checkUsername = storage.checkUsername(username);

                if(checkUsername) {
                    boolean checkPassword = storage.checkPassword(password);

                    if(checkPassword) {

                        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Username atau Password anda tidak sesuai", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Username tidak terdaftar, silahkan registrasi terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });


        linkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, Register.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Database storage = Database.getInstance();

        if(!storage.isAuthenticated()) {
            Toast.makeText(getApplicationContext(), "Silahkan login untuk mengubah tampilan", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
