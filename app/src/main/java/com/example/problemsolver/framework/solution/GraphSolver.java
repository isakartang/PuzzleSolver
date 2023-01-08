package com.example.problemsolver.framework.solution;

import com.example.problemsolver.graph.*;
import com.example.problemsolver.framework.Problem;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides methods for searching graphs and displaying
 * the results of searching.
 * @author tcolburn
 */
public abstract class GraphSolver extends Solver {

    /**
     * Creates a graph solver.
     * @param problem the problem being solved
     */
    public GraphSolver(Problem problem) {
        super(problem);
        super.setQueue(new LinkedList<>());
        graph = new GraphCreator().createGraphFor(problem);
    }

    @Override
    protected Vertex getCurrent() {
        return graph.find(new Vertex(getProblem().getCurrentState()));
    }

    @Override
    public List<Vertex> expand(Vertex u) {
        return graph.getAdjacencyList(u);
    }

    private final Graph graph;
}
