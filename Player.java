import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private Bag bag;
    private Validator validator;
    private Board board;
  
    public Player(String name, Board board) {
      this.name = name;
      this.board = board;
      this.score = 0;
      this.bag = new Bag(board);
      this.validator = new Validator();
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

    public String getBag() {
      return this.name + "'s bag: [" + bag + "]";
    }

    public void takeTurn(Scanner input) {
      System.out.println("\n" + name + "'s turn!");
      System.out.println(getBag());
      while (true) {
        try {
          Word w = getInputs(board, input);

          if (board.canPlaceWord(w.getWord(), w.getCol(), w.getRow(), w.getOrientation())) {
            validator.checkBag(bag, board, w);
            board.placeWord(w.getWord(), w.getCol(), w.getRow(), w.getOrientation());
          } else {
            throw new Exception("Cannot place word!");
          }
          break;
        } catch (Exception e) {
          System.out.println("Error: " + e.getMessage());
        }
      }
    }

    public Word getInputs(Board board, Scanner input) {
      String word; char orientation; int col, row;
      Word wordObj;
      // Validate inputs
      while (true) {
        try {
          // Word Input
          System.out.println(bag);
          System.out.print("Enter the word to place: ");
          word = input.nextLine().toLowerCase();
          // Orientation Input
          System.out.print("Enter the orientation (v for vertical, h for horizontal): ");
          orientation = Character.toLowerCase(input.nextLine().charAt(0));
          // Column Input
          System.out.print("Enter the starting column [A-O]: ");
          String letters = "ABCDEFGHIJKLMNO";
          char colLetter = Character.toUpperCase(input.nextLine().charAt(0));
          if (letters.indexOf(colLetter) == -1) {throw new Exception("Column Letter should be in range [A-O]");}
          col = letters.indexOf(colLetter);
          // Row Input
          System.out.print("Enter the starting row [1-15]: ");
          row = input.nextInt() - 1;
          input.nextLine();
          wordObj = new Word(word, orientation, col, row);
          validator.validateInputs(wordObj);
          break;
        } catch (Exception e) {
          if (e instanceof InputMismatchException) {
            System.out.println("Error: Row should be a number!");
          } else {
            System.out.println("Error: " + e.getMessage());
          }
        }
      }
      return wordObj;
    }
  }