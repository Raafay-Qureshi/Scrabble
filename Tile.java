public class Tile {
    char letter;
    String specialTile;

    public Tile(char letter) {
        this.letter = letter;
        this.specialTile = "";
    }

    public char getLetter() {
        return this.letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public String getSpecialTile() {
        return specialTile;
    }

    public void setSpecialTile(String specialTile) {
        if (specialTile.equals("STR")) {
            this.specialTile = specialTile + "\u001B[0m";
        } else {
            this.specialTile = "\u001B[35m" +  specialTile + "\u001B[0m"; 
        }
    }
}
