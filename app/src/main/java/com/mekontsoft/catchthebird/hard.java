package com.mekontsoft.catchthebird;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class hard extends AppCompatActivity {
    TextView timetxt;
    TextView scoretxt;
    int score;

    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
        timetxt = (TextView) findViewById(R.id.timetxt3);
        scoretxt = (TextView) findViewById(R.id.scoretxt3);
        imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView4=(ImageView) findViewById(R.id.imageView4);
        imageView5=(ImageView) findViewById(R.id.imageView5);
        imageView6=(ImageView) findViewById(R.id.imageView6);
        imageView7=(ImageView) findViewById(R.id.imageView7);
        imageView8=(ImageView) findViewById(R.id.imageView8);
        imageView9=(ImageView) findViewById(R.id.imageView9);
        imageView10=(ImageView) findViewById(R.id.imageView10);
        imageArray=new ImageView[]{imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10};
        hideImage();
        score = 0;
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timetxt.setText("Time :"+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timetxt.setText("Time's Up!");
                Toast.makeText(hard.this, "Time's Up!", Toast.LENGTH_SHORT).show();
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert = new AlertDialog.Builder(hard.this);

                alert.setTitle("Game Over");
                alert.setMessage("Do You Want To Start Over ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(hard.this, "Game Over", Toast.LENGTH_SHORT).show();
                        Intent Main = new Intent(hard.this, MainActivity.class);
                        startActivity(Main);
                    }
                });
                alert.show();
            }
        }.start();
    }
    public void mainmenubtn(View view) {
        Intent mainmenu = new Intent(hard.this, MainActivity.class);
        startActivity(mainmenu);
    }

    public void Score (View view){
        score++;
        scoretxt.setText("Score : "+score);
    }

    public void hideImage(){
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);


    }
}