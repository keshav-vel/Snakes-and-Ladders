package app.src.test;

import app.src.main.gamedie.GameDie;

class SnakesAndLaddersTest {

    class ProgrammableDie implements GameDie {

        int index = 0;
        Integer[] moves = {5,3,2,4,2,4,5,6,4,6,3,3,1,6,5,3,3,4,3,3,1,4,5,5,3,6,2,1,5,4,2,1,4,5,1,4,2,1,6,4,3,1,1,4,5,1,4,5,4,6,6,6,4,6,1,5,2,1,6,3,1,4,6,1};
        @Override
        public Integer roll() {
            return moves[index++];
        }
    }
}