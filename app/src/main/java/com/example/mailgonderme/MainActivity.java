package com.example.mailgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button button;
    String icerik, konu, mailAdres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        GorveGonder();

    }

    public void tanimla() {
        editText1 = (EditText) findViewById(R.id.MaılHesabı);
        editText2 = (EditText) findViewById(R.id.MaılKonu);
        editText3 = (EditText) findViewById(R.id.MaılIcerık);
        button = (Button) findViewById(R.id.buton);

    }

    public void bilgiAl() {
        mailAdres = editText1.getText().toString();
        konu = editText2.getText().toString();
        icerik = editText3.getText().toString();
    }

    public void GorveGonder() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();
                try {
                    Intent ıntent = new Intent(Intent.ACTION_SEND);
                    ıntent.setType("message/rfc82");
                    ıntent.putExtra(Intent.EXTRA_EMAIL, mailAdres);
                    ıntent.putExtra(Intent.EXTRA_SUBJECT, konu);
                    ıntent.putExtra(Intent.EXTRA_TEXT, icerik);
                    startActivity(Intent.createChooser(ıntent,"mail gönder"));
                } catch (Exception e) {
                    System.out.print("" + e);
                }

            }
        });
    }
}