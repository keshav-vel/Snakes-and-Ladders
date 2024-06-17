package app.src.main;

import app.src.main.logger.Logger;

import java.util.Map;

public class Player {
     int getPlayerPosition(Logger logger, GameEvents game, int playerPosition, int dieRoll, boolean skipTurn, Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions, String player) {
        int nextPosition = playerPosition + dieRoll;

        if (nextPosition > 100) {
            logger.log("Player " + player + " needs to score exactly " + (100 - playerPosition) + " on dice roll to win. Passing chance.");
            skipTurn = true;
        }

        if (nextPosition == 100) {
            logger.log("Player " + player + " wins! Game finished.");
            game.endGame();
        }

        if (playerPosition == 0 && dieRoll != 6) {
            logger.log("Player " + player + " did not score 6. First a 6 needs to be scored to start moving on board.");
            skipTurn = true;
        }

        if (snakePositions.get(nextPosition) != null) {
            logger.log("Player got bit by snake at position " + nextPosition);
            playerPosition = snakePositions.get(nextPosition);
            skipTurn = true;
        }

        if (ladderPositions.get(nextPosition) != null) {
            logger.log("Player got chanced upon a ladder at position " + nextPosition + "!");
            playerPosition = ladderPositions.get(nextPosition);
            skipTurn = true;
        }

        if (!skipTurn) {
            playerPosition = nextPosition;
        }

        logger.log("Next position for player " + player + " is " + playerPosition);
        return playerPosition;
    }
}