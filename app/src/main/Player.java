package app.src.main;

import app.src.main.events.Game;
import app.src.main.events.GameEvents;
import app.src.main.logger.Logger;

import java.util.Map;

public class Player {

    int getPlayerPosition(Logger logger, GameEvents game, int playerPosition, int dieRoll, boolean skipTurn, Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions, String player) {

        int nextPosition = playerPosition + dieRoll;

        skipTurn = isFirstRoll6(logger, playerPosition, dieRoll, skipTurn, player);
        skipTurn = isPositionPast100(logger, playerPosition, skipTurn, player, nextPosition);
        playerPosition = posAfterChancingUponSnakeOrLadder(logger, playerPosition, skipTurn, snakePositions, ladderPositions, nextPosition);

        if (Game.didPlayerWin(logger, game, player, nextPosition)) {
            return 100;
        }

        logger.log("Next position for player " + player + " is " + playerPosition);
        return playerPosition;
    }

    private static int posAfterChancingUponSnakeOrLadder(Logger logger, int playerPosition, boolean skipTurn, Map<Integer, Integer> snakePositions, Map<Integer, Integer> ladderPositions, int nextPosition) {
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

        return Game.movePlayer(playerPosition, skipTurn, nextPosition);
    }

    private static boolean isFirstRoll6(Logger logger, int playerPosition, int dieRoll, boolean skipTurn, String player) {
        if (playerPosition == 0 && dieRoll != 6) {
            logger.log("Player " + player + " did not score 6. First a 6 needs to be scored to start moving on board.");
            skipTurn = true;
        }
        return skipTurn;
    }

    private static boolean isPositionPast100(Logger logger, int playerPosition, boolean skipTurn, String player, int nextPosition) {
        if (nextPosition > 100) {
            logger.log("Player " + player + " needs to score exactly " + (100 - playerPosition) + " on dice roll to win. Passing chance.");
            skipTurn = true;
        }
        return skipTurn;
    }
}