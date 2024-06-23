package app.src.main.events;

import app.src.main.logger.Logger;

public class Game implements GameEvents {
    public static boolean didPlayerWin(Logger logger, GameEvents game, String player, int nextPosition) {
        if (nextPosition == 100) {
            logger.log("Player " + player + " wins! Game finished.");
            game.endGame();
            return true;
        }
        return false;
    }

    public static int movePlayer(int playerPosition, boolean skipTurn, int nextPosition) {
        if (!skipTurn) {
            playerPosition = nextPosition;
        }
        return playerPosition;
    }

    public void endGame() {
        System.exit(1);
    }
}