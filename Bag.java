import java.util.ArrayList;
import java.util.Random;

public class Bag {
    private ArrayList<Character> letterBag = new ArrayList<>();
    private Board board;

    public Bag(Board board) {
        this.board = board;
        addLetters();
    }

    public void addLetters() {
        Random rand = new Random();
        int numOfLetters = 10 - letterBag.size();
        for (int i = 0; i < numOfLetters; i++) {
            int j = rand.nextInt(board.getAvailableWords().length());
            char letter = board.getAvailableWords().charAt(j);
            letterBag.add(letter);
            board.setAvailableWords(board.getAvailableWords().replaceFirst(String.valueOf(letter), ""));
        }
    }

    public String toString() {
        String contents = "";
        for (int i = 0; i < letterBag.size(); i++) {
            if (i == letterBag.size() - 1) {
                contents += "'" + letterBag.get(i) + "'";
            } else {
                contents += "'" + letterBag.get(i) + "' ";
            }
        }
        return contents;
    }

    public ArrayList<Character> getLetterBag() {
        return letterBag;
    }

    public void setLetterBag(ArrayList<Character> letterBag) {
        this.letterBag = letterBag;
    }
}
