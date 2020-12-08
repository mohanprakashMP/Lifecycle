package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String TAG= "MainActivity";

    private Button DialogButton;
    private Button SecondButton;
    int sum=0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogButton=findViewById(R.id.button);
        SecondButton=findViewById(R.id.button2);
        textView=findViewById(R.id.textView);

        Log.d(TAG, "onCreate");
        Log.d(TAG,"sum: "+sum);

        if(savedInstanceState!=null)
        {
            sum=savedInstanceState.getInt("SUMKEY");
            Log.d(TAG,"sum after rotation:"+sum);
            textView.setText(""+sum);
        }

        DialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sum = sum+1;
                Log.d(TAG,"sum: "+sum);
                textView.setText(""+sum);
            }
        });

        SecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new
                        Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putInt("SUMKEY", sum);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        super.onBackPressed();
    }

}