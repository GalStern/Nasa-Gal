package com.example.nasa.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nasa.Home;
import com.example.nasa.R;
import com.example.nasa.ui.dashboard.DashboardActivity;
import com.example.nasa.ui.dashboard.DashboardFragment;

public class Intro3Activity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);
    }
    public void changeLayout(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void skipLayout(View view){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }

}