import java.util.Scanner;

public class test {
    public static void main(String[] args) {
    // create the 2d array
    char[][] board = new char[15][15];

    // initialize the array to all spaces
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
        board[i][j] = ' ';
        }
    }

    // get the word and orientation from the user
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the word to place: ");
    String word = input.nextLine();
    System.out.print("Enter the orientation (v for vertical, h for horizontal): ");
    char orientation = input.nextLine().charAt(0);

    // place the word in the array
    if (orientation == 'h') {
        // place the word horizontally
        System.out.print("Enter the starting row: ");
        int row = input.nextInt();
        System.out.print("Enter the starting column: ");
        int col = input.nextInt();

        // check if the word fits on the board
        if (col + word.length() > board[row].length) {
        System.out.println("Error: word does not fit on the board.");
        } else {
        // place the word on the board
        for (int i = 0; i < word.length(); i++) {
            board[row][col + i] = word.charAt(i);
        }
        }
    } else if (orientation == 'v') {
        // place the word vertically
        System.out.print("Enter the starting row: ");
        int row = input.nextInt();
        System.out.print("Enter the starting column: ");
        int col = input.nextInt();

        // check if the word fits on the board
        if (row + word.length() > board.length) {
        System.out.println("Error: word does not fit on the board.");
        } else {
        // place the word on the board
        for (int i = 0; i < word.length(); i++) {
            board[row + i][col] = word.charAt(i);
        }
        }
    } else {
        // invalid orientation
        System.out.println("Error: invalid orientation.");
    }

    // print the board
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
        System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
    } 
}
