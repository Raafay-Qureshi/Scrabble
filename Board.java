public class Board {

    private Tile[][] pieces = new Tile[15][15];

    public Board() {
    }

    public void placeWord(String word, Coordinate startPos, Coordinate endPos) {
        for (char letter : word.toCharArray()) {
            System.out.println(letter);
        }
    }

    public void placeTile(Tile tile, Coordinate pos) {
        pieces[pos.getY()][pos.getX()] = tile;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 15; i++) {
            result += "\n";
            for (int j = 0; j < 15; j++) {
                result += " ---"; 
            }
            result += "\n";
            for (int j = 0; j < 15; j++) {
                if (!(pieces[i][j] == null) ) {
                    result += ("  " + pieces[i][j].getLetter() +  " ");
                } else {
                    result += "    ";
                }
            }
        }
        result += "\n";
        for (int i = 0; i < 15; i++) {
            result += " ---"; 
        }
        return result;
    }
}
