package com.example.activitylifecycletest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    //内存不够时保存被杀掉的Activity中的数据
    @Override
    protected void onSaveInstanceState(@Nullable Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        //此Activity被杀掉后恢复杀掉的数据
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }

        Button startDialogActivity = findViewById(R.id.startDialogActivity);
        startDialogActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });

        Button startNormalActivity = findViewById(R.id.startNormalActivity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });



    }
}