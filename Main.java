import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
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


    //continue to play the game until it is over
    while (true) {

      int nextNum = getNumber();
      System.out.println("Player " + playerTurn + " got dice roll of " + nextNum);

      if (playerTurn == 1) {
        int next = playerOnePosition + nextNum;

        if (next > 100) {
          System.out.println("Player one needs to score exactly " + (100 - playerOnePosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          System.out.println("Player one wins! Game finished.");
          System.exit(1);
        }

        if (playerOnePosition == 0 && nextNum != 6) {
          System.out.println("Player one did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          System.out.println("Player got bit by snake a position " + next);
          playerOnePosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          System.out.println("Player got chanced upon a ladder at position " + next + "!");
          playerOnePosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerOnePosition = next;
        }

        System.out.println("Next position for player one is " + playerOnePosition);
        skipTurn = false;
        playerTurn = 2;
        System.out.println("Player two will play next turn");

      } else if (playerTurn == 2) {

        int next = playerTwoPosition + nextNum;

        if (next > 100) {
          System.out.println("Player two needs to score exactly " + (100 - playerTwoPosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          System.out.println("Player two wins! Game finished.");
          System.exit(1);
        }

        if (playerTwoPosition == 0 && nextNum != 6) {
          System.out.println("Player two did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          System.out.println("Player got bit by snake a position " + next);
          playerTwoPosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          System.out.println("Player got chanced upon a ladder at position " + next + "!");
          playerTwoPosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerTwoPosition = next;
        }
        System.out.println("Next position for player two is " + playerTwoPosition);
        skipTurn = false;
        playerTurn = 3;
        System.out.println("Player three will play next turn");

      } else if (playerTurn == 3) {

        int next = playerThreePosition + nextNum;

        if (next > 100) {
          System.out.println("Player three needs to score exactly " + (100 - playerThreePosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          System.out.println("Player three wins! Game finished.");
          System.exit(1);
        }

        if (playerThreePosition == 0 && nextNum != 6) {
          System.out.println("Player three did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          System.out.println("Player got bit by snake a position " + next);
          playerThreePosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          System.out.println("Player got chanced upon a ladder at position " + next + "!");
          playerThreePosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerThreePosition = next;
        }
        System.out.println("Next position for player three is " + playerThreePosition);
        skipTurn = false;
        playerTurn = 4;
        System.out.println("Player four will play next turn");

      } else if (playerTurn == 4) {

        int next = playerFourPosition + nextNum;

        if (next > 100) {
          System.out.println("Player four needs to score exactly " + (100 - playerFourPosition) + " on dice roll to win. Passing chance.");
          skipTurn = true;
        }

        if (next == 100) {
          System.out.println("Player four wins! Game finished.");
          System.exit(1);
        }

        if (playerFourPosition == 0 && nextNum != 6) {
          System.out.println("Player four did not score 6. First a 6 needs to be scored to start moving on board.");
          skipTurn = true;
        }

        if (snakePositions.get(next) != null) {
          System.out.println("Player got bit by snake a position " + next);
          playerFourPosition = snakePositions.get(next);
          skipTurn = true;
        }

        if (ladderPositions.get(next) != null) {
          System.out.println("Player got chanced upon a ladder at position " + next + "!");
          playerFourPosition = ladderPositions.get(next);
          skipTurn = true;
        }

        if (!skipTurn) {
          playerFourPosition = next;
        }
        System.out.println("Next position for player four is " + playerFourPosition);
        skipTurn = false;
        playerTurn = 1;
        System.out.println("Player one will play next turn");
      }

    }

  }

  //throw number at random
  private static Integer getNumber() {
    Random rand = new Random();
    return rand.nextInt(6) + 1;
  }

}
