import java.util.ArrayList;

public class Validator {
    public void validateInputs(Word word) throws Exception {
        // Word Validation
        if (!word.getWord().matches("[a-z]+")) {
            throw new Exception("Word should only be letters");
        }
        // Orientation Validation
        if (word.getOrientation() != 'v' && word.getOrientation() != 'h') {
            throw new Exception("Orientation should be v or h");
        }
        // Column Validation
        if (word.getCol() + word.getWord().length() > 14 && word.getOrientation() == 'h') {
            throw new Exception("Word is out of bounds!");
        }
        // Row Validation
        if (!(word.getRow() >= 0 && word.getRow() <= 14)) {
            throw new Exception("Row should be in range [1-15]");
        }
        if (word.getRow() + word.getWord().length() > 14 && word.getOrientation() == 'v') {
            throw new Exception("Word is out of bounds!");
        }
    }

    public void checkBag(Bag bag, Board board, Word w) throws Exception {
        ArrayList<Character> letterBag = new ArrayList<>();
        letterBag = (ArrayList<Character>) bag.getLetterBag().clone();
        for (int i = 0; i < w.getWord().length(); i++) {
            char letter = w.getWord().charAt(i);
            int row = w.getOrientation() == 'v' ? w.getRow() + i : w.getRow();
            int col = w.getOrientation() == 'h' ? w.getCol() + i : w.getCol();
            if (!letterBag.contains(letter)) {
                if (board.getCharAt(row, col) != letter) {
                    if (!letterBag.contains(' ')) {
                        throw new Exception("Letter '" + letter + "' is not in bag");
                    }
                    letterBag.remove(letterBag.indexOf(' '));
                }
            } else {
                letterBag.remove(letterBag.indexOf(letter));
            }
        }
        bag.setLetterBag(letterBag);
        bag.addLetters();
    }
}
