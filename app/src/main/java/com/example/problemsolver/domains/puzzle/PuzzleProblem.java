package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.framework.Benchmark;
import com.example.problemsolver.framework.Problem;

/**
 *
 * @author isaka
 */
public class PuzzleProblem extends Problem{
    public PuzzleProblem() {
        super();
        super.setName("8-Puzzle");
        super.addBenchmark(new Benchmark("8-Puz 1", 5, BENCH1, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 2", 10, BENCH2, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 3", 13, BENCH3, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 4", 18, BENCH4, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 5", 20, BENCH5, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 6", 24, BENCH6, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 7", 30, BENCH7, GOAL));
        super.addBenchmark(new Benchmark("8-Puz 8", 30, BENCH8, GOAL));

        super.setIntroduction(INTRO);
        super.setMover(new PuzzleMover());
        super.setInitialState(new PuzzleState(new int[][]{new int[]{2, 8, 3},
                new int[]{1, 6, 4},
                new int[]{7, 0, 5}}));
        super.setCurrentState(super.getInitialState());
        super.setFinalState(new PuzzleState(new int[][]{new int[]{1, 2, 3},
                new int[]{8, 0, 4},
                new int[]{7, 6, 5}}));


    }

    private final String INTRO = "You are given a board in which numbered"
            + " tiles can slide around. There is one blank space that holds no "
            + "tile.  A legal move consists of sliding a tile into the blank "
            + "space if the tile is adjacent to it. The goal is to move tiles "
            + "around until the board looks like the final state below.";

    private static final PuzzleState BENCH1 =
            new PuzzleState(new int[][]{new int[]{2, 8, 3},
                    new int[]{1, 6, 4},
                    new int[]{7, 0, 5}});
    private static final PuzzleState GOAL =
            new PuzzleState(new int[][]{new int[]{1, 2, 3},
                    new int[]{8, 0, 4},
                    new int[]{7, 6, 5}});
    private static final PuzzleState BENCH2 =
            new PuzzleState(new int[][]{new int[]{3, 6, 4},
                    new int[]{1, 0, 2},
                    new int[]{8, 7, 5}});
    private static final PuzzleState BENCH3 =
            new PuzzleState(new int[][]{new int[]{3, 0, 4},
                    new int[]{1, 6, 5},
                    new int[]{8, 2, 7}});
    private static final PuzzleState BENCH4 =
            new PuzzleState(new int[][]{new int[]{2, 1, 3},
                    new int[]{8, 0, 4},
                    new int[]{6, 7, 5}});
    private static final PuzzleState BENCH5 =
            new PuzzleState(new int[][]{new int[]{4, 2, 0},
                    new int[]{8, 3, 6},
                    new int[]{1, 7, 5}});
    private static final PuzzleState BENCH6 =
            new PuzzleState(new int[][]{new int[]{1, 6, 3},
                    new int[]{4, 0, 8},
                    new int[]{7, 2, 5}});
    private static final PuzzleState BENCH7 =
            new PuzzleState(new int[][]{new int[]{5, 6, 7},
                    new int[]{4, 0, 8},
                    new int[]{3, 2, 1}});
    private static final PuzzleState BENCH8 =
            new PuzzleState(new int[][]{new int[]{5, 2, 7},
                    new int[]{8, 0, 4},
                    new int[]{3, 6, 1}});
}

