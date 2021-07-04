package com.example.kopiku;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Pendaftaran extends AppCompatActivity {
    Button tSign, tBack;
    EditText tEmail, tPass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        tEmail = (EditText) findViewById(R.id.edEmail);
        tPass = (EditText) findViewById(R.id.edPass);
        tSign = (Button) findViewById(R.id.btnSign);
        tBack = (Button) findViewById(R.id.btnSign2);

        tSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tEmail.getText().toString().length()==0){
                    tEmail.setError("Email diperlukan!");
                }else if(tPass.getText().toString().length()==0){
                    tPass.setError("Password diperlukan!");
                }else {
                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil! Silahkan pilih menu",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Pendaftaran.this, MainAct2.class);
                    Pendaftaran.this.startActivity(intent);
                    finish();
                }
            }
        });
        tBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pendaftaran.this, Home.class);
                Pendaftaran.this.startActivity(intent);
                finish();
            }
        });
    }
}