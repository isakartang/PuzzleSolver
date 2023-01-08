package com.example.problemsolver.domains.big;

import com.example.problemsolver.framework.Problem;
import com.example.problemsolver.framework.Benchmark;

/**
 *
 * @author isaka
 */
public class PuzzleBigProblem extends Problem{
    public PuzzleBigProblem() {
        super();
        super.setName("8-Puzzle");
        super.addBenchmark(new Benchmark("15-Puz 1", 8, BENCH1, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 2", 16, BENCH2, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 3", 33, BENCH3, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 4", 38, BENCH4, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 5", 42, BENCH5, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 6", 44, BENCH6, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 7", 50, BENCH7, GOAL));
        super.addBenchmark(new Benchmark("15-Puz 8", 54, BENCH8, GOAL));

        super.setIntroduction(INTRO);
        super.setMover(new PuzzleBigMover());
        super.setInitialState(new PuzzleBigState(new int[][]{new int[]{5, 1, 2, 3},
                new int[]{6, 0, 7, 4},
                new int[]{9, 10, 11, 8},
                new int[]{13, 14, 15, 12}}));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleBigState(new int[][]{new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 0}}) );


    }

    private final String INTRO = "You are given a board in which numbered"
            + " tiles can slide around. There is one blank space that holds no "
            + "tile.  A legal move consists of sliding a tile into the blank "
            + "space if the tile is adjacent to it. The goal is to move tiles "
            + "around until the board looks like the final state below.";

    private static final PuzzleBigState BENCH1 =
            new PuzzleBigState(new int[][]{new int[]{5, 1, 2, 3},
                    new int[]{6, 0, 7, 4},
                    new int[]{9, 10, 11, 8},
                    new int[]{13, 14, 15, 12}});
    private static final PuzzleBigState GOAL =
            new PuzzleBigState(new int[][]{new int[]{1, 2, 3, 4},
                    new int[]{5, 6, 7, 8},
                    new int[]{9, 10, 11, 12},
                    new int[]{13, 14, 15, 0}});
    private static final PuzzleBigState BENCH2 =
            new PuzzleBigState(new int[][]{new int[]{5, 1, 2, 4},
                    new int[]{6, 11, 12, 3},
                    new int[]{9, 7, 0, 8},
                    new int[]{13, 10, 14, 15}});
    private static final PuzzleBigState BENCH3 =
            new PuzzleBigState(new int[][]{new int[]{1, 4, 10, 8},
                    new int[]{2, 6, 0, 12},
                    new int[]{3, 14, 15, 11},
                    new int[]{5, 9, 13, 7}});
    private static final PuzzleBigState BENCH4 =
            new PuzzleBigState(new int[][]{new int[]{7, 13, 15, 2},
                    new int[]{10, 1, 11, 4},
                    new int[]{3, 9, 6, 8},
                    new int[]{5, 0, 14, 12}});
    private static final PuzzleBigState BENCH5 =
            new PuzzleBigState(new int[][]{new int[]{10, 15, 5, 8},
                    new int[]{2, 0, 6, 3},
                    new int[]{1, 12, 14, 4},
                    new int[]{9, 7, 13, 11}});
    private static final PuzzleBigState BENCH6 =
            new PuzzleBigState(new int[][]{new int[]{14, 6, 0, 8},
                    new int[]{2, 1, 4, 9},
                    new int[]{7, 13, 10, 11},
                    new int[]{15, 5, 12, 3}});
    private static final PuzzleBigState BENCH7 =
            new PuzzleBigState(new int[][]{new int[]{7, 8, 4, 11},
                    new int[]{12, 14, 10, 15},
                    new int[]{0, 5, 3, 13},
                    new int[]{2, 1, 9, 6}});
    private static final PuzzleBigState BENCH8 =
            new PuzzleBigState(new int[][]{new int[]{7, 14, 0, 9},
                    new int[]{10, 2, 11, 13},
                    new int[]{6, 15, 4, 12},
                    new int[]{5, 1, 8, 3}});
}