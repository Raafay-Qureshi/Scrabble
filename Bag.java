import java.util.ArrayList;
import java.util.Random;

public class Bag {
    private ArrayList<Character> letterBag = new ArrayList<>();

    public Bag() {
        Random rand = new Random();
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 15; i++) {
            int j = rand.nextInt(letters.length());
            char letter = letters.charAt(j);
            letterBag.add(letter);
        }
    }

    public String getBagContents() {
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
}
