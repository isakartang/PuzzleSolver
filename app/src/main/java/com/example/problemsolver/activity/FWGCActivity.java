package com.example.problemsolver.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.problemsolver.R;
import com.example.problemsolver.domains.farmer.FarmerProblem;
import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.State;
import com.example.problemsolver.framework.solution.AStarSolver;
import com.example.problemsolver.framework.solution.Solution;
import com.example.problemsolver.framework.solution.Solver;
import com.example.problemsolver.framework.solution.SolvingAssistant;
import com.example.problemsolver.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

public class FWGCActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc);
        problem = new FarmerProblem();
        solvingAssistant = new SolvingAssistant(problem);
        reset = (Button) findViewById(R.id.Breset);
        solve = (Button) findViewById(R.id.Bsolve);
        next = (Button) findViewById(R.id.Bnext);
        next.setEnabled(false);
        currState = (TextView) findViewById(R.id.curState);
        moveCount = (TextView) findViewById(R.id.movecount);
        notif = (TextView) findViewById(R.id.message);
        stats = (TextView) findViewById(R.id.stats);
        solver = new AStarSolver(problem);
        stats.setText(solver.getStatistics().toString());
        movesView = (LinearLayout) findViewById(R.id.farmer_mover);
        //movesView insets?
        success = "You solved the problem. Congratulations.";
        illegal = "Illegal move. Try again.";
        List<String> buttonNames = problem.getMover().getMoveNames();

        buttons = new ArrayList<>();
        List<String> moveNames = problem.getMover().getMoveNames();
        for (String m: moveNames) {
            movesView.addView(makeButton(m));
        }

        solve.setOnClickListener(view -> {
            solver.solve();
            S = solver.getSolution();
            stats.setText(solver.getStatistics().toString());
            next.setEnabled(true);
            solve.setEnabled(false);
            buttons.forEach(e -> e.setEnabled(false));
            S.next();
        });

        next.setOnClickListener(view -> {
            for (Button b: buttons) {
                b.setBackgroundColor(Color.WHITE);
            }
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
                for (Button b: buttons) {
                    if (b.getText().equals(move)) {
                        b.setBackgroundColor(Color.DKGRAY);
                    }
                }
            }
            if (problem.success()) {
                notif.setTextColor(Color.BLUE);
                notif.setText(success);
                next.setEnabled(false);
            }
        });

        reset.setOnClickListener(view -> {
            solvingAssistant.reset();
            currState.setText(problem.getCurrentState().toString());
            moveCount.setText(String.valueOf(solvingAssistant.getMoveCount()));
            notif.setTextColor(Color.TRANSPARENT);
            buttons.forEach(e -> e.setEnabled(true));
            solve.setEnabled(true);
            next.setEnabled(false);
            solver.getStatistics().clear();
            stats.setText(solver.getStatistics().toString());
            for (Button b: buttons) {
                b.setBackgroundColor(Color.WHITE);
            }
        });
    }

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
                notif.setTextColor(Color.BLUE);
                notif.setText(success);
                buttons.forEach(e -> e.setEnabled(false));
            }
            else if (!solvingAssistant.isMoveLegal()) {
                notif.setText(illegal);
                notif.setTextColor(Color.BLUE);
            }
            else
                notif.setTextColor(Color.TRANSPARENT);

        });
        return b;
    }

    private Problem problem;
    private LinearLayout movesView;
    private Solution S;
    private SolvingAssistant solvingAssistant;
    private TextView currState;
    private TextView moveCount;
    private TextView notif;
    private TextView stats;
    private String success;
    private String illegal;
    private Solver solver;
    private List<Button> buttons;
    private Button reset;
    private Button solve;
    private Button next;
    private String move;
}
