package com.example.problemsolver.framework.solution;

import com.example.problemsolver.graph.Vertex;
import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.State;
import static com.example.problemsolver.framework.solution.Statistics.CIRCULARITIES;
import static com.example.problemsolver.framework.solution.Statistics.LENGTH;
import static com.example.problemsolver.framework.solution.Statistics.NUM_OPS;
import static com.example.problemsolver.framework.solution.Statistics.QUEUE_SIZE;
import static com.example.problemsolver.framework.solution.Statistics.TIME;
import static com.example.problemsolver.framework.solution.Statistics.VERTICES;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

/**
 * This abstract class implements a state space problem solver
 * that uses a queue to control its search.
 * Subclasses must call the "setQueue" method to install the
 * particular type of queue used.
 * Subclasses must also implement the abstract "expand" method.
 * Other protected methods can be overridden if needed.
 * This class also keeps and makes available problem solutions
 * and search statistics.
 *
 * @author tcolburn
 */
public abstract class Solver {

    private final Problem problem;
    private Queue<Vertex> queue;
    private Solution solution;
    private final Statistics statistics;
    private final HashMap<Vertex, Vertex> vertices;
    private final static int INITIAL_CAPACITY = 500000;

    /**
     * Creates a solver object for a particular problem.
     * @param p the problem to be solved
     */
    public Solver(Problem p) {
        problem = p;
        statistics = new Statistics();
        vertices = new HashMap<>(INITIAL_CAPACITY);
    }

    /**
     * Getter for this solver's problem.
     * @return this solver's problem
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * Setter for this solver's queue.
     * This must be called by a subclass.
     * @param q the queue to be used in this solver
     */
    public void setQueue(Queue<Vertex> q) {
        queue = q;
    }

    /**
     * Getter for this solver's queue.
     * @return this solver's queue
     */
    public Queue<Vertex> getQueue() {
        return queue;
    }

    /**
     * Getter for this solver's solution object.
     * @return this solver's solution object
     */
    public Solution getSolution() {
        return solution;
    }

    /**
     * Getter for this solver's statistics.
     * @return this solver's statistics
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Expands a vertex in the state space search tree created by
     * this solver.
     * This method is abstract and must be overridden by a subclass.
     * @param u the vertex to be expanded
     * @return a list of vertices that are one move away from u in
     * the state space
     */
    public abstract List<Vertex> expand(Vertex u);

    /**
     * Adds a vertex to the queue used by this solver.
     * May be overridden by subclasses.
     * @param v the vertex to be enqueued
     */
    protected void add(Vertex v) {
        getQueue().add(v);
    }

    /**
     * Gets the current state of the problem as a vertex.
     * May be overridden by subclasses.
     * @return the current state of the problem as a vertex
     */
    protected Vertex getCurrent() {
        return new Vertex(problem.getCurrentState());
    }

    /**
     * Attempts to solve the problem from the current state.
     * Search statistics are recorded, and if the search is
     * successful a solution object is constructed.
     */
    public void solve() {
        statistics.clear();
        vertices.clear();
        Vertex current = getCurrent();
        Date before = new Date();
        Vertex goal = search(current);
        Date after = new Date();
        statistics.putStat(VERTICES, vertices.size());
        statistics.putStat(TIME, (int)(after.getTime() - before.getTime()));
        if (goal != null) {
            solution = new Solution(current, goal);
            statistics.putStat(LENGTH, solution.getLength());
        } else {
            throw new RuntimeException("Solution not found");
        }
    }


    /**
     * The central "search" method implements this algorithm:

     Search(s)
     d[s] = 0
     pred[s] = null
     Q = {s}
     V = {s}
     while Q ≠ {} do
     u = Remove[Q]
     if success(u)
     then return u
     for each v ∈ expand(u) do
     if v ∉ V
     then put v in V
     d[v] = d[u] + 1
     pred[v] = u
     Add(Q,v)
     return null

     * This method must also update the queue statistics
     * (NUM_OPS and QUEUE_SIZE) and the number of CIRCULARITIES
     * encountered during the search.
     * @param s a vertex representing the current state of the
     * problem
     * @return a vertex representing a final state of the
     * problem if one is found, null otherwise
     */

    private Vertex search(Vertex s) {
        queue.clear();
        statistics.clear();
        s.setDistance(0);
        s.setPredecessor(null);
        queue.add(s);
        max = queue.size();
        statistics.incrStat(NUM_OPS);
        statistics.incrStat(QUEUE_SIZE);
        vertices.put(s,s);
        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            statistics.incrStat(NUM_OPS);
            if (success(u)) {
                statistics.putStat(QUEUE_SIZE, max);
                return u;
            }
            for (Vertex v: expand(u)) {
                if (!vertices.containsKey(v)) {
                    vertices.put(v, u);
                    v.setDistance(u.getDistance() + 1);
                    v.setPredecessor(u);
                    statistics.incrStat(NUM_OPS);
                    statistics.incrStat(QUEUE_SIZE);
                    queue.add(v);
                    if (queue.size() > max)
                        max = queue.size();
                }
                else {
                    statistics.incrStat(CIRCULARITIES);
                }
            }

        }
        return null;
    }

    private boolean success(Vertex v) {
        return v.getData().equals(problem.getFinalState());
    }

    private int max;

}
