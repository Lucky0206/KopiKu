package com.example.kopiku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btnMasuk, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);
        btnBack = (Button) findViewById(R.id.btnMasuk2);

        btnMasuk.setOnClickListener((view) -> {
            String usernameKey = username.getText().toString();
            String passwordKey = password.getText().toString();
            if (usernameKey.equals("kopiku") && passwordKey.equals("123")) {
                Toast.makeText(getApplicationContext(), "Login berhasil", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MainAct2.class);
                MainActivity.this.startActivity(intent);
                finish();
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Username atau password anda salah!")
                        .setNegativeButton("Retry",null).create().show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}