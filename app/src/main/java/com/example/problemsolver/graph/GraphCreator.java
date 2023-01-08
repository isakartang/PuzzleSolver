package com.example.problemsolver.graph;

import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.State;
import java.util.List;
import java.util.Stack;

/**
 * @author Isak Artang
 */
public class GraphCreator {

    public Graph createGraphFor(Problem problem) {
        graph = new Graph();
        Stack<Vertex> stack = new Stack();
        Vertex Start = new Vertex(problem.getInitialState());
        stack.push(Start);
        List<String> moves = problem.getMover().getMoveNames();
        while (!stack.isEmpty()) {
            Vertex u = stack.pop();
            for (String m : moves) {
                State next = problem.getMover().doMove(m, (State) u.getData());
                if (next != null) {
                    Vertex v = new Vertex(next);
                    if (graph.getVertices().containsKey(v)) {
                        v = graph.getVertices().get(v);
                    }
                    else {stack.push(v); }

                    graph.addEdge(u, v);
                }
            }
        }
        return graph;
    }

    private Graph graph = null;
}