package app.src.main;

import java.util.Random;

public class RandomDie implements GameDie {
    public static Integer getDieRoll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}