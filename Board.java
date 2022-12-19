public class Board {

    private Tile[][] pieces = new Tile[15][15];

    public Board() {
        initializeBoard();
    }

    public void placeWord(String word, Coordinate startPos, Coordinate endPos) {
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (startPos.getX() != endPos.getX()) {
                pieces[startPos.getY()][startPos.getX() + i].setLetter(letter);
            } else {
                pieces[startPos.getY() + i][startPos.getX()].setLetter(letter);
            }
        }
    }

    public void placeTile(Tile tile, Coordinate pos) {
        pieces[pos.getY()][pos.getX()] = tile;
    }

    public String toString() {
        String result = "";
        result += "\n\t";
        for (int i = 0; i < 15; i++) {
            result += " -----";
        }
        for (int i = 0; i < 15; i++) {
            result += "\n" + (i+1) + "\t";
            for (int j = 0; j < 15; j++) {
                result += ("|  " + pieces[i][j].getLetter() +  "  ");
            }
            result += "|";

            result += "\n\t";
            for (int j = 0; j < 15; j++) {
                result += " -----";
            }
        }
        result += "\n\t";
        String letters = "ABCDEFGHIJKLMNO";
        for (int i = 0; i < 15; i++) {
            result += "   " + letters.charAt(i) + "  ";
        }
        return result;
    }
    
    public void initializeBoard() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
            pieces[i][j] = new Tile(' ');
            }
        }
    }
}
