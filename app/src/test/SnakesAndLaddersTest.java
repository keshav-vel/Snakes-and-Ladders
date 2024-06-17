package app.src.test;

import app.src.main.SnakesAndLadders;
import app.src.test.utils.ProgrammableDie;
import app.src.test.utils.TestLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class SnakesAndLaddersTest {

    @Test
    void gameRunsAndEndsSuccessfully() {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        TestLogger testLogger = new TestLogger();
        try {
            snakesAndLadders.run(new ProgrammableDie(), testLogger, () -> {
                throw new RuntimeException("Game Finished");
            });
            fail("Exception to be thrown!");
        } catch (RuntimeException e) {
            assertEquals("Player four wins! Game finished.", testLogger.messageAt(testLogger.size()-1));
        }
    }
}