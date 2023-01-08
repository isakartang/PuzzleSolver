package com.example.problemsolver.domains.puzzle;

import com.example.problemsolver.domains.puzzle.PuzzleState.Location;
import com.example.problemsolver.framework.Mover;
import com.example.problemsolver.framework.State;

/**
 *
 * @author isaka
 */
public class PuzzleMover extends Mover {

    public static final String slide1 = "SLIDE TILE 1";
    public static final String slide2 = "SLIDE TILE 2";
    public static final String slide3 = "SLIDE TILE 3";
    public static final String slide4 = "SLIDE TILE 4";
    public static final String slide5 = "SLIDE TILE 5";
    public static final String slide6 = "SLIDE TILE 6";
    public static final String slide7 = "SLIDE TILE 7";
    public static final String slide8 = "SLIDE TILE 8";

    public PuzzleMover() {
        super.addMove(slide1, s -> try1(s));
        super.addMove(slide2, s -> try2(s));
        super.addMove(slide3, s -> try3(s));
        super.addMove(slide4, s -> try4(s));
        super.addMove(slide5, s -> try5(s));
        super.addMove(slide6, s -> try6(s));
        super.addMove(slide7, s -> try7(s));
        super.addMove(slide8, s -> try8(s));
    }

    private State try1(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(1);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }

        return null;
    }

    private State try2(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(2);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try3(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(3);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try4(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(4);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try5(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(5);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try6(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(6);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try7(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(7);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }

    private State try8(State s) {
        PuzzleState state = (PuzzleState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(8);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleState(state, curr, blank);
            }
        }
        return null;
    }
}