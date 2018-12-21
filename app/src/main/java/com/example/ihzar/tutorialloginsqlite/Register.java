package com.example.ihzar.tutorialloginsqlite;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {
    //instansiasi
    Button  btnSignUp;
    DataHelper dbHelper;
    EditText edt_Username, edt_Email, edt_Password, edt_pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //instansiasi objek layout ke class java
        btnSignUp = (Button) findViewById(R.id.buttonRegis);
        dbHelper = new DataHelper(this);
        edt_Username = (EditText) findViewById(R.id.edit_username);
        edt_Email = (EditText) findViewById(R.id.edit_Email);
        edt_Password = (EditText) findViewById(R.id.edit_Password);
        edt_pass2 = (EditText) findViewById(R.id.edit_confpassword);

        //ini adalah function yg dibuat untuk button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            //ini adalah validasi untuk memastikan data telah terisi
            public void onClick(View view) {
              if (isMatch(edt_Password.getText().toString().trim(), edt_pass2.getText().toString().trim())) {
                if (isValidEmail(edt_Email.getText().toString().trim())) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into user(username, email, password) values('" + edt_Username.getText().toString() + "','" + edt_Email.getText().toString() + "','" + edt_Password.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                    finish();

                } else {
                    edt_Email.setError("Email Tidak Valid");
                }
            }
            else
               {
                   edt_pass2.setError("Pastikan Password Sama");
                   Toast.makeText(getApplicationContext(), "Pastikan Password Sama", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    //ini adalah function yang digunakan untuk validasi email dan password, yang diatas merupakan fungsi panggilan dari
    //fungsi dibawah ini
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isMatch(String password, String retypePassword){
        return password.equals(retypePassword);
    }

}
