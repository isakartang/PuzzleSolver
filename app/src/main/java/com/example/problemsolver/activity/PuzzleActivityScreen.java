package com.example.problemsolver.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.problemsolver.R;
import com.example.problemsolver.activity.EightActivity;

public class PuzzleActivityScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_intro);
    }

    public void doProblem(View v) {
        Intent intent = new Intent(this, EightActivity.class);
        startActivity(intent);
    }
}
