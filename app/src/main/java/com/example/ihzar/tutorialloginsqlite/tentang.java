package com.example.ihzar.tutorialloginsqlite;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tentang extends AppCompatActivity {

    Button gmaps, kembali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        kembali = findViewById(R.id.kembalitentang);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), home.class);
                startActivity(i);
                finish();
            }
        });
        Button gmaps = (Button) findViewById(R.id.maps);
        gmaps.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.google.com/maps/place/Politeknik+Negeri+Malang/@-7.9465289,112.6155368,15z/data=!4m5!3m4!1s0x0:0x789ce9a636cd3aa2!8m2!3d-7.9465289!4d112.6155368"));
                startActivity(i);
            }
        }));
    }
}
