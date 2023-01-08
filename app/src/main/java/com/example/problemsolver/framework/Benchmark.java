package com.example.problemsolver.framework;

public class Benchmark {
    public Benchmark(String name, int solutionLength, State start, State goal) {
        this.name = name;
        this.solutionLength = solutionLength;
        this.start = start;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public int getSolutionLength() {
        return solutionLength;
    }

    public State getStart() {
        return start;
    }

    public State getGoal() {
        return goal;
    }

    @Override
    public String toString() {
        return getName() + ": " + solutionLength + " moves";
    }

    private final String name;
    private final int solutionLength;
    private final State start;
    private final State goal;
}
