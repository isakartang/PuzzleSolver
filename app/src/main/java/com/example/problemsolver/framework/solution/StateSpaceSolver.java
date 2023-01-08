package com.example.problemsolver.framework.solution;

import com.example.problemsolver.graph.Vertex;
import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.Mover;
import com.example.problemsolver.framework.State;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a state space solver by extending the abstract
 * Solver class.
 * @author Your name and section here
 */
public abstract class StateSpaceSolver extends Solver {

    /**
     * Creates a BFS or DFS state space solver.
     * This constructor should set the queue to a double-ended queue
     * (DEQUE) like the GraphSolver.
     * @param problem the problem being solved
     */
    public StateSpaceSolver(Problem problem) {
        super(problem);
        super.setQueue(new LinkedList<>());
    }

    /**
     * This method implements the expand operation required by the
     * state space search algorithm.
     * @param u the vertex being expanded
     * @return the children of u in the state space search tree
     */
    @Override
    public List<Vertex> expand(Vertex u) {
        List<Vertex> L = new LinkedList<>();
        Problem p = getProblem();
        Mover M = p.getMover();
        for (String s: M.getMoveNames()) {
            if (p.getMover().doMove(s, (State) u.getData()) != null) {
                Vertex v = new Vertex(p.getMover().doMove(s, (State) u.getData()));
                L.add(v);
            }
        }
        return L;
    }
}
