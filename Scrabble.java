import java.util.Scanner;

public class Scrabble {
    private Board board;
    
    public Scrabble() {
        this.board = new Board();
        System.out.println(board);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("Raafay", board);
        Player player2 = new Player("Aaira", board);
        for (int i = 0; i < 999; i++) {
            
            player1.takeTurn(scanner);
            System.out.println(board);
            
            player2.takeTurn(scanner);
            System.out.println(board);
        }
        scanner.close();
    }
}
