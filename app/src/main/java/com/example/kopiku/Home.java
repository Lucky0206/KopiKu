package com.example.kopiku;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class Home extends AppCompatActivity {

    Button btnLogin, btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnDaftar = (Button)findViewById(R.id.btnDaftar);
        ViewPager viewPager = findViewById(R.id.viewPager);
        Imageslider imageslider = new Imageslider(this);
        viewPager.setAdapter(imageslider);

        btnLogin.setOnClickListener((view)-> {
            {
                Toast.makeText(getApplicationContext(), "Silahkan login dahulu",Toast.LENGTH_LONG).show();;
                Intent intent = new Intent(Home.this, MainActivity.class);
                Home.this.startActivity(intent);
                finish();
            }
        });
        btnDaftar.setOnClickListener((view)-> {
            {
                Toast.makeText(getApplicationContext(), "Silahkan daftar dahulu",Toast.LENGTH_LONG).show();;
                Intent intent = new Intent(Home.this, Pendaftaran.class);
                Home.this.startActivity(intent);
                finish();
            }
        });
    }
}
