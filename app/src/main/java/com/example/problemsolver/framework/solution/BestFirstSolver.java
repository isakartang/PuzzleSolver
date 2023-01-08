package com.example.problemsolver.framework.solution;

import com.example.problemsolver.graph.Vertex;
import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.State;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This class represents a best-first solver by extending the StateSpaceSolver
 * class.
 * @author tcolburn
 */
public class BestFirstSolver extends StateSpaceSolver {

    /**
     * Creates a "best-first" solver.
     * This constructor should set the queue to a priority queue (PQ)
     * and set the statistics header.
     * @param problem
     */
    public BestFirstSolver(Problem problem) {
        super(problem);
        Comparator<Vertex> comp =
                (v1, v2) -> {
                    State goal = getProblem().getFinalState();
                    State s1 = (State)v1.getData();
                    State s2 = (State)v2.getData();
                    int h1 = s1.getHeuristic(goal);
                    int h2 = s2.getHeuristic(goal);
                    return h1 - h2;
                };
        super.setQueue(new PriorityQueue<>(comp));
        super.getStatistics().setHeader("Best-First Search");
    }
}