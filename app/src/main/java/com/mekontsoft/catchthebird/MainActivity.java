package com.mekontsoft.catchthebird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    gameselect menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start(View view){
        Intent intent = new Intent(MainActivity.this,gameselect.class);
        startActivity(intent);
    }

    public void rateme(View view){

    }
    public void moretick(View view){

    }
}