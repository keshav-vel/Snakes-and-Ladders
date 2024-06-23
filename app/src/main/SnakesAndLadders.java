package app.src.main;

import app.src.main.events.Game;
import app.src.main.events.GameEvents;
import app.src.main.gamedie.GameDie;
import app.src.main.gamedie.RandomDie;
import app.src.main.logger.Logger;
import app.src.main.logger.TerminalLogger;

import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {

  public static void main(String[] args) {
    new SnakesAndLadders().run(new RandomDie(), new TerminalLogger(), new Game(), new Player());
  }

  public void run(GameDie die, Logger logger, GameEvents game, Player player) {
    //declare variables
    String[][] board = new String[10][10];
    Map<Integer, Integer> snakePositions = new HashMap<Integer, Integer>() {
      {
        put(18, 2);
        put(25, 8);
        put(38, 11);
        put(41, 19);
        put(59, 21);
        put(72, 12);
        put(78, 7);
        put(86, 31);
        put(92, 26);
        put(97, 5);
      }
    };
    Map<Integer, Integer> ladderPositions = new HashMap<Integer, Integer>() {
      {
        put(9, 32);
        put(12, 53);
        put(17, 90);
        put(21, 50);
        put(27, 66);
        put(29, 42);
        put(44, 73);
        put(63, 88);
      }
    };
    int playerTurn = 1;
    int playerOnePosition = 0, playerTwoPosition = 0, playerThreePosition = 0, playerFourPosition = 0;
    boolean skipTurn = false;

    while (true) {
      int dieRoll = die.roll();
      logger.log("Player " + playerTurn + " got dice roll of " + dieRoll);

      if (playerTurn == 1) {
        playerOnePosition = player.getPlayerPosition(logger, game, playerOnePosition, dieRoll, skipTurn, snakePositions, ladderPositions, "one");
        playerTurn = 2;
        logger.log("Player two will play next turn");

      } else if (playerTurn == 2) {
        playerTwoPosition = player.getPlayerPosition(logger, game, playerTwoPosition, dieRoll, skipTurn, snakePositions, ladderPositions, "two");
        playerTurn = 3;
        logger.log("Player three will play next turn");

      } else if (playerTurn == 3) {
        playerThreePosition = player.getPlayerPosition(logger, game, playerThreePosition, dieRoll, skipTurn, snakePositions, ladderPositions, "three");
        playerTurn = 4;
        logger.log("Player four will play next turn");

      } else {
        playerFourPosition = player.getPlayerPosition(logger, game, playerFourPosition, dieRoll, skipTurn, snakePositions, ladderPositions, "four");
        playerTurn = 1;
        logger.log("Player one will play next turn");
      }
    }
  }
}
