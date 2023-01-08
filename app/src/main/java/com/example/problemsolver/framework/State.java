package com.example.problemsolver.framework;

public abstract class State {

        /**
         * Computes the heuristic value of this state object compared with a
         * given goal state. Defaults to zero.
         * Extending classes can choose to override this method.
         * @param goal the goal state
         * @return the heuristic value
         */
        public int getHeuristic(State goal) { return 0; }

        /**
         * Gets the name of the move that produced this state.
         * If this is an initial state, it can be null.
         * @return the name of the move that produced this state
         */
        public String getMove() {
            return move;
        }

        /**
         * Sets the name of the move that produced this state.
         * @param move the name of the move that produced this state
         */
        public void setMove(String move) {
            this.move = move;
        }

        /**
         * The name of the move that produced this state.
         */
        private String move;

    }

