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
            boolean emptyArea = true;
            for (int i = 0; i < word.length(); i++) {

                char letter;
                if (orientation == 'h') {
                    letter = pieces[startPos.getY()][startPos.getX() + i].getLetter();
                    sidesValid(startPos.getY(), startPos.getX() + i);
                } else {
                    letter = pieces[startPos.getY() + i][startPos.getX()].getLetter();
                    sidesValid(startPos.getY() + i, startPos.getX());
                }

                if (letter != ' ') {
                    if (letter != word.charAt(i)) {
                        return false;
                    }
                    emptyArea = false;
                }
            }
            if (emptyArea) {
                return false;
            }
            return true;
        }
    }

    public boolean sidesValid(int y, int x) {
        int i = 1;
        String word = "";
        while (x + i < 15) {
            char letter = pieces[y][x+i].getLetter();
            if (letter == ' ') {
                break;
            } else {
                word += letter;
            }
            i++;
        }
        if (word != "" ) {
            System.out.println(word);
        }
        return true;
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
                if (pieces[i][j].getLetter() == ' ' && pieces[i][j].getSpecialTile() != "") {
                    result += ("| " + pieces[i][j].getSpecialTile() +  " ");
                } else {
                    result += ("|  " + pieces[i][j].getLetter() +  "  ");
                }
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

    public void createSpecialTile(String specialTile, int x, int y) {
        pieces[x][y].setSpecialTile(specialTile);
        pieces[14 - x][y].setSpecialTile(specialTile);
        pieces[x][14 - y].setSpecialTile(specialTile);
        pieces[14 - x][14 - y].setSpecialTile(specialTile);
    }

    public void initializeBoard() {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j] = new Tile(' ');
            }
        }
        initializeSpecialTiles();
    }

    public void initializeSpecialTiles() {
        createSpecialTile("STR", 7, 7);
        // Triple Word
        createSpecialTile("TrW", 0, 0);
        createSpecialTile("TrW", 7, 0);
        createSpecialTile("TrW", 0, 7);

        // Double Word
        createSpecialTile("DoW", 1, 1);
        createSpecialTile("DoW", 2, 2);
        createSpecialTile("DoW", 3, 3);
        createSpecialTile("DoW", 4, 4);

        // Triple Letter
        createSpecialTile("TrL", 1, 5);
        createSpecialTile("TrL", 5, 1);
        createSpecialTile("TrL", 5, 5);

        // Double Letter
        createSpecialTile("DoL", 0, 3);
        createSpecialTile("DoL", 3, 0);
        createSpecialTile("DoL", 2, 6);
        createSpecialTile("DoL", 6, 2);
        createSpecialTile("DoL", 3, 7);
        createSpecialTile("DoL", 7, 3);
        createSpecialTile("DoL", 6, 6);
    }
}
