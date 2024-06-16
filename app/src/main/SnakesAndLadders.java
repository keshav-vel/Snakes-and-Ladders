package app.src.main;

import app.src.main.gamedie.GameDie;
import app.src.main.gamedie.RandomDie;
import app.src.main.logger.TerminalLogger;

import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {

  public static void main(String[] args) {
    new SnakesAndLadders().run(new RandomDie());
  }

  public void run(GameDie die) {
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
      TerminalLogger.log("Player " + playerTurn + " got dice roll of " + dieRoll);

      if (playerTurn == 1) {
        int nextPosition = playerOnePosition + dieRoll;

        if (nextPosition > 100) {
          TerminalLogger.log("Player one needs to score exactly " + (100 - playerOnePosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (nextPosition == 100) {
          TerminalLogger.log("Player one wins! Game finished.");
          System.exit(1);
        }

        if (playerOnePosition == 0 && dieRoll != 6) {
          TerminalLogger.log("Player one did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(nextPosition) != null) {
          TerminalLogger.log("Player got bit by snake a position " + nextPosition);
          playerOnePosition = snakePositions.get(nextPosition);
          skipTurn = true;
        }

        if (ladderPositions.get(nextPosition) != null) {
          TerminalLogger.log("Player got chanced upon a ladder at position " + nextPosition + "!");
          playerOnePosition = ladderPositions.get(nextPosition);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerOnePosition = nextPosition;
        }

        TerminalLogger.log("Next position for player one is " + playerOnePosition);
        skipTurn = false;
        playerTurn = 2;
        TerminalLogger.log("Player two will play next turn");

      } else if (playerTurn == 2) {

        int next = playerTwoPosition + dieRoll;

        if (next > 100) {
          TerminalLogger.log("Player two needs to score exactly " + (100 - playerTwoPosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          TerminalLogger.log("Player two wins! Game finished.");
          System.exit(1);
        }

        if (playerTwoPosition == 0 && dieRoll != 6) {
          TerminalLogger.log("Player two did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          TerminalLogger.log("Player got bit by snake a position " + next);
          playerTwoPosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          TerminalLogger.log("Player got chanced upon a ladder at position " + next + "!");
          playerTwoPosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerTwoPosition = next;
        }
        TerminalLogger.log("Next position for player two is " + playerTwoPosition);
        skipTurn = false;
        playerTurn = 3;
        TerminalLogger.log("Player three will play next turn");

      } else if (playerTurn == 3) {

        int next = playerThreePosition + dieRoll;

        if (next > 100) {
          TerminalLogger.log("Player three needs to score exactly " + (100 - playerThreePosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          TerminalLogger.log("Player three wins! Game finished.");
          System.exit(1);
        }

        if (playerThreePosition == 0 && dieRoll != 6) {
          TerminalLogger.log("Player three did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          TerminalLogger.log("Player got bit by snake a position " + next);
          playerThreePosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          TerminalLogger.log("Player got chanced upon a ladder at position " + next + "!");
          playerThreePosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerThreePosition = next;
        }
        TerminalLogger.log("Next position for player three is " + playerThreePosition);
        skipTurn = false;
        playerTurn = 4;
        TerminalLogger.log("Player four will play next turn");

      } else if (playerTurn == 4) {

        int next = playerFourPosition + dieRoll;

        if (next > 100) {
          TerminalLogger.log("Player four needs to score exactly " + (100 - playerFourPosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          TerminalLogger.log("Player four wins! Game finished.");
          System.exit(1);
        }

        if (playerFourPosition == 0 && dieRoll != 6) {
          TerminalLogger.log("Player four did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          TerminalLogger.log("Player got bit by snake a position " + next);
          playerFourPosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          TerminalLogger.log("Player got chanced upon a ladder at position " + next + "!");
          playerFourPosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerFourPosition = next;
        }
        TerminalLogger.log("Next position for player four is " + playerFourPosition);
        skipTurn = false;
        playerTurn = 1;
        TerminalLogger.log("Player one will play next turn");
      }
    }
  }
}
