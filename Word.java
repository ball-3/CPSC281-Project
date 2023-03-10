import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    private Tree wrongInput;
    private String word = "";
    private ArrayList<String[]> category = new ArrayList<String[]>();
    private String categoryName;
    private int CharNum;

    Word(String word) {
        this.word = word;
    }

    Word(int level) {
        
        String[] fruit = { "fruit", "apple", "banana", "blueberry", "orange", "mango", "lychee" };
        String[] popular_artist = { "popular artist", "Taylor Swift", "Billie Eilish", "Ariana Grande", "Adele",
                "Olivia Rodrigo", "Dua Lipa", "Harry Styles" };
        String[] computer_science = { "computer science", "linked list", "skip list", "recursion", };
        category.add(fruit);
        category.add(popular_artist);
        category.add(computer_science);
        generateNewRandomWord(level);
    }

    public String getWord() {
        return word;
    }

    public int getWrongNum() {
        return wrongInput.getSize();
    }

    public int getCharNum() {
        return word.length();
    }

    private void generateNewRandomWord(int level) {
        Random random = new Random();
        String[] picked = category.get(1);
        categoryName = picked[0];
        int rand;
        while (true){
            rand = random.nextInt(picked.length);
            if(rand !=0) break;
        }
        word = picked[rand];
        System.out.println(word);

    }

    // maybe void
    public String includedWord(char c) {
        String send = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(i) == c) {
                // tell gui to display the character
                // apple -> P -> "p1p2"
                send = send + "," + i;
            }
        }
        wrongInput.insert(c);

        return null;
    }

}
