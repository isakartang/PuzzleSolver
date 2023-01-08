package com.example.problemsolver.domains.big;

import com.example.problemsolver.domains.big.PuzzleBigState.Location;
import com.example.problemsolver.framework.State;
import com.example.problemsolver.framework.Mover;

/**
 *
 * @author isaka
 */
public class PuzzleBigMover extends Mover {

    public static final String slide1 = "SLIDE TILE 1";
    public static final String slide2 = "SLIDE TILE 2";
    public static final String slide3 = "SLIDE TILE 3";
    public static final String slide4 = "SLIDE TILE 4";
    public static final String slide5 = "SLIDE TILE 5";
    public static final String slide6 = "SLIDE TILE 6";
    public static final String slide7 = "SLIDE TILE 7";
    public static final String slide8 = "SLIDE TILE 8";
    public static final String slide9 = "SLIDE TILE 9";
    public static final String slide10 = "SLIDE TILE 10";
    public static final String slide11 = "SLIDE TILE 11";
    public static final String slide12 = "SLIDE TILE 12";
    public static final String slide13 = "SLIDE TILE 13";
    public static final String slide14 = "SLIDE TILE 14";
    public static final String slide15 = "SLIDE TILE 15";

    public PuzzleBigMover() {
        super.addMove(slide1, s -> try1(s));
        super.addMove(slide2, s -> try2(s));
        super.addMove(slide3, s -> try3(s));
        super.addMove(slide4, s -> try4(s));
        super.addMove(slide5, s -> try5(s));
        super.addMove(slide6, s -> try6(s));
        super.addMove(slide7, s -> try7(s));
        super.addMove(slide8, s -> try8(s));
        super.addMove(slide9, s -> try9(s));
        super.addMove(slide10, s -> try10(s));
        super.addMove(slide11, s -> try11(s));
        super.addMove(slide12, s -> try12(s));
        super.addMove(slide13, s -> try13(s));
        super.addMove(slide14, s -> try14(s));
        super.addMove(slide15, s -> try15(s));

    }

    private State try1(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(1);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try2(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(2);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try3(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(3);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try4(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(4);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try5(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(5);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try6(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(6);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try7(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(7);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try8(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(8);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        return null;
    }

    private State try9(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(9);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try10(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(10);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try11(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(11);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try12(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(12);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try13(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(13);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try14(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(14);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }

    private State try15(State s) {
        PuzzleBigState state = (PuzzleBigState) s;
        Location blank = state.getLocation(0);
        Location curr = state.getLocation(15);
        if (blank.getRow() == curr.getRow()) {
            if (curr.getColumn() + 1 == blank.getColumn()
                    || curr.getColumn() - 1 == blank.getColumn()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }
        else if (blank.getColumn() == curr.getColumn()) {
            if (curr.getRow() + 1 == blank.getRow()
                    || curr.getRow() - 1 == blank.getRow()) {
                return new PuzzleBigState(state, curr, blank);
            }
        }

        return null;
    }
}