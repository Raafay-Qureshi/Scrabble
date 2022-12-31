import java.util.Scanner;

public class Scrabble {
    Board board;

    public Scrabble() {
        this.board = new Board();
        System.out.println(board);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("Raafay");
        Player player2 = new Player("Aaira");
        for (int i = 0; i < 999; i++) {
            
            player1.takeTurn(board, scanner);
            System.out.println(board);
            
            player2.takeTurn(board, scanner);
            System.out.println(board);
        }
        scanner.close();
    }

    
}
