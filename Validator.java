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
        if (!(word.getRow() >= 0 && word.getRow() <= 14)) {throw new Exception("Row should be in range [1-15]");}
        if (word.getRow() + word.getWord().length() > 14 && word.getOrientation() == 'v') {throw new Exception("Word is out of bounds!");}
    }
}
