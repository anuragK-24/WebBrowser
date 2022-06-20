package com.firstapp.web;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText urlEt= findViewById(R.id.urlET);

        final LinearLayout instagramBtn = findViewById(R.id.instagramBtn);
        final LinearLayout twitterBtn = findViewById(R.id.twitterBtn);
        final LinearLayout youtubeBtn = findViewById(R.id.youtubeBtn);

        urlEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEARCH){
                    final String urlTxt = urlEt.getText().toString();
                    if(!urlTxt.isEmpty()){
                        urlEt.setText("");
                        Intent intent = new Intent(MainActivity.this, BrowserView.class);
                        intent.putExtra("url",urlTxt);

                        startActivity(intent);
                    }
                }
                return false;
            }
        });
        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url","www.instagram.com");

                startActivity(intent);
            }
        });

        twitterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url","www.twitter.com");

                startActivity(intent);
            }
        });

        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserView.class);
                intent.putExtra("url","www.youtube.com");

                startActivity(intent);
            }
        });
    }
}