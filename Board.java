public class Board {

    private boolean firstWord = true;
    private Tile[][] pieces = new Tile[15][15];

    public Board() {
        initializeBoard();
    }

    public void placeWord(String word, Coordinate startPos, char orientation) {
        if (firstWord) {firstWord = false;}

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (orientation == 'h') { 
                pieces[startPos.getY()][startPos.getX() + i].setLetter(letter);
            } else {
                pieces[startPos.getY() + i][startPos.getX()].setLetter(letter);
            }
        }
    }

    public boolean canPlaceWord(String word, Coordinate startPos, char orientation) {
        if (firstWord) {
            for (int i = 0; i < word.length(); i++) {
                if (orientation == 'h') {
                    if (startPos.getY() == 7 && startPos.getX() + i == 7) {
                        return true;
                    }
                } else {
                    if (startPos.getY() + i == 7 && startPos.getX() == 7) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            for (int i = 0; i < word.length(); i++) {

                if (orientation == 'h') {
                    if (pieces[startPos.getY()][startPos.getX() + i].getLetter() != ' ') {
                        return false;
                    }
                } else {
                    if (pieces[startPos.getY() + i][startPos.getX()].getLetter() != ' ') {
                        return false;
                    }
                }
            }
            return true;
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

    public void createSpecialTile(char specialTile, Coordinate pos) {
        pieces[pos.getX()][pos.getY()].setLetter(specialTile);
    }

    public void initializeBoard() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
            pieces[i][j] = new Tile(' ');
            }
        }
    }

    // public void initializeSpecialTiles() {
    //     // Triple Word
    //     createSpecialTile('\u2162', new Coordinate(0, 0));
    //     createSpecialTile('\u2162', new Coordinate(7, 0));
    //     createSpecialTile('\u2162', new Coordinate(14, 0));
    //     createSpecialTile('\u2162', new Coordinate(0, 7));
    //     createSpecialTile('\u2162', new Coordinate(0, 14));
    //     createSpecialTile('\u2162', new Coordinate(14, 7));
    //     createSpecialTile('\u2162', new Coordinate(14, 14));

    //     // Double Word
    //     createSpecialTile('\u2161', new Coordinate(1, 1));
    //     createSpecialTile('\u2161', new Coordinate(2, 2));
    //     createSpecialTile('\u2161', new Coordinate(3, 3));
    //     createSpecialTile('\u2161', new Coordinate(4, 4));

    //     createSpecialTile('\u2161', new Coordinate(13, 1));
    //     createSpecialTile('\u2161', new Coordinate(12, 2));
    //     createSpecialTile('\u2161', new Coordinate(11, 3));
    //     createSpecialTile('\u2161', new Coordinate(10, 4));

    //     createSpecialTile('\u2161', new Coordinate(1, 13));
    //     createSpecialTile('\u2161', new Coordinate(2, 12));
    //     createSpecialTile('\u2161', new Coordinate(3, 11));
    //     createSpecialTile('\u2161', new Coordinate(4, 10));

    //     createSpecialTile('\u2161', new Coordinate(13, 13));
    //     createSpecialTile('\u2161', new Coordinate(12, 12));
    //     createSpecialTile('\u2161', new Coordinate(11, 11));
    //     createSpecialTile('\u2161', new Coordinate(10, 10));

    //     // Triple Letter
    //     createSpecialTile('\u2172', new Coordinate(1, 5));
    //     createSpecialTile('\u2172', new Coordinate(1, 9));

    //     createSpecialTile('\u2172', new Coordinate(5, 1));
    //     createSpecialTile('\u2172', new Coordinate(5, 5));
    //     createSpecialTile('\u2172', new Coordinate(5, 9));
    //     createSpecialTile('\u2172', new Coordinate(5, 13));

    //     createSpecialTile('\u2172', new Coordinate(9, 1));
    //     createSpecialTile('\u2172', new Coordinate(9, 5));
    //     createSpecialTile('\u2172', new Coordinate(9, 9));
    //     createSpecialTile('\u2172', new Coordinate(9, 13));

    //     createSpecialTile('\u2172', new Coordinate(13, 5));
    //     createSpecialTile('\u2172', new Coordinate(13, 9));

    //     // Double Letter
    //     createSpecialTile('\u2171', new Coordinate(0, 3));
    //     createSpecialTile('\u2171', new Coordinate(0, 12));

    //     createSpecialTile('\u2171', new Coordinate(2, 6));
    //     createSpecialTile('\u2171', new Coordinate(2, 8));

    //     createSpecialTile('\u2171', new Coordinate(3, 0));
    //     createSpecialTile('\u2171', new Coordinate(3, 7));
    //     createSpecialTile('\u2171', new Coordinate(3, 14));

    //     createSpecialTile('\u2171', new Coordinate(6, 2));
    //     createSpecialTile('\u2171', new Coordinate(6, 6));
    //     createSpecialTile('\u2171', new Coordinate(6, 8));
    //     createSpecialTile('\u2171', new Coordinate(6, 8));
    // }
}
