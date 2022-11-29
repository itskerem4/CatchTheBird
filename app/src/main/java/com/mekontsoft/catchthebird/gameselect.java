package com.mekontsoft.catchthebird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gameselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameselect);
    }
    public void mainmenubtn(View view) {
        Intent mainmenu = new Intent(gameselect.this, MainActivity.class);
        startActivity(mainmenu);
    }

    public void basic(View view){
        Intent basic= new Intent(gameselect.this, basic.class);
        startActivity(basic);
    }
    public void normal(View view){
        Intent normal= new Intent(gameselect.this, normal.class);
        startActivity(normal);
    }
    public void hard(View view){
        Intent basic= new Intent(gameselect.this, basic.class);
        startActivity(basic);
    }


}