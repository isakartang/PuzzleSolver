package com.example.problemsolver.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.problemsolver.R;

public class BigActivityIntroScreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_intro);
    }

    public void doProblem(View v) {
        Intent intent = new Intent(this, BigActivityScreen.class);
        startActivity(intent);
    }
}
