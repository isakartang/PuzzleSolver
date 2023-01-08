package com.example.problemsolver.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.problemsolver.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewFarmer(View v) {
        Intent intent = new Intent(this, FarmerActivityScreen.class);
        startActivity(intent);
    }

    public void viewPuzzle(View v) {
        Intent intent = new Intent(this, PuzzleActivityScreen.class);
        startActivity(intent);
    }
    public void viewBig(View v) {
        Intent intent = new Intent(this, BigActivityIntroScreen.class);
        startActivity(intent);
    }
}