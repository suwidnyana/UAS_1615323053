package com.example.uas_1615323053;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    TextView linkToLogin;
    EditText fieldNama;
    EditText fieldTanggal;
    EditText fieldAlamat;
    EditText fieldEmail;
    EditText fieldUsername;
    EditText fieldPassword;
    EditText fieldUlangiPassword;
    Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fieldNama = (EditText) findViewById(R.id.Nama);
        fieldTanggal = (EditText) findViewById(R.id.Tanggal);
        fieldAlamat = (EditText) findViewById(R.id.Alamat);
        fieldEmail = (EditText) findViewById(R.id.Email);
        fieldUsername = (EditText) findViewById(R.id.Username);
        fieldPassword = (EditText) findViewById(R.id.Password);
        fieldUlangiPassword = (EditText) findViewById(R.id.Konfirmasi);
        btnDaftar = (Button) findViewById(R.id.btnDaftar);
        linkToLogin = (TextView) findViewById(R.id.btnLogin);

        linkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = fieldNama.getText().toString();
                String tanggal = fieldTanggal.getText().toString();
                String alamat = fieldAlamat.getText().toString();
                String email = fieldEmail.getText().toString();
                String username = fieldUsername.getText().toString();
                String password = fieldPassword.getText().toString();
                String ulangiPassword = fieldUlangiPassword.getText().toString();

               Database storage = Database.getInstance();

                storage.add(nama, tanggal, alamat, email, username, password);

                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Registrasi berhasil, silahkan login", Toast.LENGTH_SHORT).show();
            }
        });
    }
}