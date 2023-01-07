public class Word {

    private String word;
    private char orientation;
    private int col, row;

    public String getWord() {
        return word;
    }

    public char getOrientation() {
        return orientation;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Word(String word, char orientation, int col, int row) {
        this.word = word;
        this.orientation = orientation;
        this.col = col;
        this.row = row;
    }
}
