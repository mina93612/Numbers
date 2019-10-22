package com.example.numbers;

import android.media.Image;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
  String TAG =MainActivity.class.getSimpleName();
    int counter;
    int secret = new Random().nextInt(10)+1;
    private TextView number;
    private ImageView result;
    //private TextView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"secret"+ secret);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.numb);
        result = findViewById(R.id.toolbar);
        //button = findViewById(R.id.zero);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                number.setText("0");
//            }
//        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       counter++;
                                       number.setText(String.valueOf(counter));
                                       result.setAlpha(1.0f);
                                       result.setVisibility(View.VISIBLE);

                                       if (counter==secret){
                                           Toast.makeText(MainActivity.this,"hahaha",Toast.LENGTH_LONG);
                                           result.setImageResource(R.drawable.shocked);
                                   }else{
                                           result.setImageResource(R.drawable.smile);
                                           result.animate().alpha(0.0f).setDuration(1200);
                               }



            }




        });

    }
    public void reverse(View view){
        counter =0;
        number.setText(String.valueOf(counter));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
