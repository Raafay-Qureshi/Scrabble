import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
  
    public Player(String name) {
      this.name = name;
      this.score = 0;
    }
   
    public String getName() {
      return this.name;
    }
  
    public int getScore() {
      return this.score;
    }
  
    public void addScore(int points) {
      this.score += points;
    }

    public void takeTurn(Board board, Scanner input) {
      System.out.println("\n" + name + "'s turn!");
      String word; char orientation; int col, row;
      while (true) {
        try {
          System.out.print("Enter the word to place: ");
          word = input.nextLine().toLowerCase();
          if (!word.matches("[a-z]+")) {
            System.out.println("Error: word is not all letters");
            continue;
          }
          System.out.print("Enter the orientation (v for vertical, h for horizontal): ");
          orientation = Character.toLowerCase(input.nextLine().charAt(0));
          if (orientation != 'v' && orientation != 'h') {
            System.out.println("Error: orientation is not v or h");
            continue;
          }

          System.out.print("Enter the starting column [A-O]: ");
          String letters = "ABCDEFGHIJKLMNO";
          char colLetter = Character.toUpperCase(input.nextLine().charAt(0));
          if (letters.indexOf(colLetter) == -1) {
            System.out.println("Error: character is not in the range [A-O]");
            continue;
          }
          col = letters.indexOf(colLetter);
          if (col + word.length() > 14 && orientation == 'h') {
            System.out.println("Error: word does not fit on the board.");
            continue;
          }
          System.out.print("Enter the starting row [1-15]: ");
          row = input.nextInt() - 1;
          input.nextLine();
          if (!(row >= 0 && row <= 14)) {
            System.out.println("Error: integer is not in the range [1-15]");
            continue;
          }
          if (row + word.length() > 14 && orientation == 'v') {
            System.out.println("Error: word does not fit on the board.");
            continue;
          }
          break;
        } catch (InputMismatchException e) {
          System.out.println("Row must be a digit!");
        }
      }

      if (orientation == 'h') {
          Coordinate startPos = new Coordinate(col, row);
          Coordinate endPos = new Coordinate(col + word.length(), row);
          board.placeWord(word, startPos, endPos);
          System.out.println("placed!");
      } else if (orientation == 'v') {
              Coordinate startPos = new Coordinate(col, row);
              Coordinate endPos = new Coordinate(col, row + word.length());
              board.placeWord(word, startPos, endPos);
      } else {
          System.out.println("Error: invalid orientation.");
      }
    }
  }