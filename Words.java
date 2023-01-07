import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {

    private ArrayList<String> wordList = new ArrayList<>();

    public Words() {
        try {
            File file = new File("words.txt");
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                wordList.add(line);
            }
            input.close();
            System.out.println(wordList.size());
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist.");
        }
    }

    public boolean isWordValid(String word) {
        return wordList.contains(word);
    }
}
