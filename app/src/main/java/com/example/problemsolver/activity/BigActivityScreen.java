package com.example.problemsolver.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.problemsolver.R;
import com.example.problemsolver.domains.big.PuzzleBigProblem;
import com.example.problemsolver.framework.Benchmark;
import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.State;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.BestFirstSolver;
import com.example.problemsolver.framework.solution.Solution;
import com.example.problemsolver.framework.solution.Solver;
import com.example.problemsolver.framework.solution.SolvingAssistant;
import com.example.problemsolver.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BigActivityScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigpuzzle);
        problem = new PuzzleBigProblem();
        solvingAssistant = new SolvingAssistant(problem);
        reset = (Button) findViewById(R.id.Breset);
        solve = (Button) findViewById(R.id.Bsolve);
        next = (Button) findViewById(R.id.Bnext);
        //next.setEnabled(false);
        currState = (TextView) findViewById(R.id.bigcur);
        currState.setText(problem.getCurrentState().toString());
        moveCount = (TextView) findViewById(R.id.bmovescount);
        moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
        notif = (TextView) findViewById(R.id.bmessage);
        stats = (TextView) findViewById(R.id.Bstats);
        solver = new BestFirstSolver(problem);
        stats.setText(solver.getStatistics().toString());
        //movesView = (LinearLayout) findViewById(R.id.puzzle_moves);
        bSolvingButtons = findViewById(R.id.linearLayout);
        //movesView insets?
        success = "You solved the problem. Congratulations.";
        List<String> buttonNames = problem.getMover().getMoveNames();
/*
        buttons = new ArrayList<>();
        List<String> moveNames = problem.getMover().getMoveNames();
        for (String m: moveNames) {
            movesView.addView(makeButton(m));
        }
*/
        solve.setOnClickListener(view -> {
            solver.solve();
            S = solver.getSolution();
            stats.setText(solver.getStatistics().toString());
            next.setEnabled(true);
            solve.setEnabled(false);
            S.next();
        });

        next.setOnClickListener(view -> {
            if (S.hasNext()) {
                State before = problem.getInitialState();
                Vertex New = S.next();
                Vertex bef = New.getPredecessor();
                solvingAssistant.update((State) New.getData());
                currState.setText(problem.getCurrentState().toString());
                moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
                State now = (State) New.getData();
                if (bef != null){
                    before = (State) bef.getData();
                }

                for (String m: buttonNames) {
                    State temp = (State) problem.getMover().doMove(m, before);
                    if (now.equals(temp)) {
                        move = m;
                    }
                }
            }
            if (problem.success()) {
                notif.setTextColor(Color.RED);
                notif.setText(success);
                next.setEnabled(false);
            }
        });

        choices = new Spinner(bSolvingButtons.getContext(), Spinner.MODE_DROPDOWN);
        String[] nameArray = new String[problem.getBenchmarks().size()];
        for (int i=0; i < nameArray.length; i++) {
            nameArray[i] = problem.getBenchmarks().get(i).toString();
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(bSolvingButtons.getContext(),
                        android.R.layout.simple_spinner_dropdown_item,
                        nameArray);
        choices.setAdapter(adapter);
        choices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Change to the selected benchmark.
                // The selection is indicated by the method parameter i,
                // which is the index of the selected string in nameArray
                solvingAssistant.reset();
                //String newB = nameArray[i];
                B = problem.getBenchmarks().get(i);
                problem.setCurrentState(B.getStart());
                currState.setText(B.getStart().toString());
                moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // do nothing
            }
        });
        bSolvingButtons.addView(choices);

        reset.setOnClickListener(view -> {
            solvingAssistant.reset();
            currState.setText(problem.getCurrentState().toString());
            moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
            notif.setTextColor(Color.TRANSPARENT);
            solve.setEnabled(true);
            next.setEnabled(false);
            solver.getStatistics().clear();
            stats.setText(solver.getStatistics().toString());

        });
    }
/**
    private Button makeButton(String m) {
        Button b = new Button(movesView.getContext());
        b.setText(m);
        b.setTextColor(Color.BLACK);
        b.setBackgroundColor(Color.WHITE);
        buttons.add(b);
        b.setOnClickListener(view -> {
            solvingAssistant.tryMove(m); currState.setText(problem.getCurrentState().toString());
            moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
            if (solvingAssistant.isProblemSolved()) {
                notif.setTextColor(Color.RED);
                notif.setText(success);
                buttons.forEach(e -> e.setEnabled(false));
            }
            else if (!solvingAssistant.isMoveLegal()) {
                notif.setText(illegal);
                notif.setTextColor(Color.RED);
            }
            else
                notif.setTextColor(Color.TRANSPARENT);
        });
        return b;
    }
*/

    private Problem problem;
    //private LinearLayout movesView;
    private LinearLayout bSolvingButtons;
    private Solution S;
    private Benchmark B;
    private SolvingAssistant solvingAssistant;
    private TextView currState;
    private TextView moveCount;
    private TextView notif;
    private TextView stats;
    private String success;
    private Solver solver;
    private Button reset;
    private Button solve;
    private Button next;
    private String move;
    private Spinner choices;
}
