package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class home extends AppCompatActivity {
    private Button Logout1;
    Button tentang, galeri;
    private TextView textclick1, textclick2, textclick3, textclick4, textclick5;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sessionManagement = new SessionManagement(this);
        galeri = findViewById(R.id.butvideo);
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Galeri.class);
                startActivity(i);
                finish();
            }
        });
        tentang = findViewById(R.id.buttentang);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), tentang.class);
                startActivity(i);
                finish();
            }
        });
        textclick1 = findViewById(R.id.textView1);
        textclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);
                startActivity(i);
                finish();
            }
        });
        textclick2 = findViewById(R.id.textView2);
        textclick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);
                startActivity(i);
                finish();
            }
        });
        textclick3 = findViewById(R.id.textView3);
        textclick3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);
                startActivity(i);
                finish();
            }
        });
        textclick4 = findViewById(R.id.textView4);
        textclick4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);
                startActivity(i);
                finish();
            }
        });
        textclick5 = findViewById(R.id.textView5);
        textclick5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), berita.class);
                startActivity(i);
                finish();
            }
        });
        Logout1 = findViewById(R.id.buttlogout);
        Logout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                sessionManagement.logoutUser();
                startActivity(i);
                finish();
            }
        });
    }}
