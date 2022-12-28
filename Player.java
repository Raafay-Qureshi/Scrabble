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
      Coordinate startPos, endPos;
      System.out.println("\n" + name + "'s turn!");
      while (true) {
        try {
          Word w = validateWord(board, input);

          // Place word on board
          startPos = new Coordinate(w.getCol(), w.getRow());
          if (w.getOrientation() == 'h') {
              endPos = new Coordinate(w.getCol() + w.getWord().length(), w.getRow());
          } else {
              endPos = new Coordinate(w.getCol(), w.getRow() + w.getWord().length());
          }

          if (board.canPlaceWord(w.getWord(), startPos, w.getOrientation())) {
            board.placeWord(w.getWord(), startPos, w.getOrientation());
          } else {
            throw new Exception("Cannot place word!");
          }
          break;
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
      }
    }

    public Word validateWord(Board board, Scanner input) {
      String word; char orientation; int col, row;
      // Validate inputs
      while (true) {
        try {
          // Word Input
          System.out.print("Enter the word to place: ");
          word = input.nextLine().toLowerCase();
          // Word Validation
          if (!word.matches("[a-z]+")) {throw new Exception("Word should only be letters");}

          // Orientation Input
          System.out.print("Enter the orientation (v for vertical, h for horizontal): ");
          orientation = Character.toLowerCase(input.nextLine().charAt(0));
          // Orientation Validation
          if (orientation != 'v' && orientation != 'h') {throw new Exception("Orientation should be v or h");}

          // Column Input
          System.out.print("Enter the starting column [A-O]: ");
          String letters = "ABCDEFGHIJKLMNO";
          char colLetter = Character.toUpperCase(input.nextLine().charAt(0));
          // Column Validation
          if (letters.indexOf(colLetter) == -1) {throw new Exception("Column Letter should be in range [A-O]");}
          col = letters.indexOf(colLetter);
          if (col + word.length() > 14 && orientation == 'h') {throw new Exception("Word is out of bounds!");}

          // Row Input
          System.out.print("Enter the starting row [1-15]: ");
          row = input.nextInt() - 1;
          input.nextLine();
          //Row Validation
          if (!(row >= 0 && row <= 14)) {throw new Exception("Row should be in range [1-15]");}
          if (row + word.length() > 14 && orientation == 'v') {throw new Exception("Word is out of bounds!");}
          break;

        } catch (Exception e) {
          if (e instanceof InputMismatchException) {
            System.out.println("Error: Row should be a number!");
          } else {
            System.out.println("Error: " + e.getMessage());
          }
        }
      }
      return new Word(word, orientation, col, row);
    }
  }