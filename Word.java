import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Word {
    private BinarySearchTree wrongInput = new BinarySearchTree();
    private String word = "";
    private ArrayList<String[]> category = new ArrayList<String[]>();
    private String categoryName;
    private int CharNum;
    // use for hangman
    private int limitMistake;
    private int stepSize;
    private int nextState = 0; // hangman drawing state

    public String getWrongInput() {
        return wrongInput.toString();
    }

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
        generateNewRandomWord();
        limitMistake = (level - 27) * -1;
        System.out.println("limit is " + limitMistake+ "   level is "+ level);
        stepSize = 27 /limitMistake;
        nextState = 27% limitMistake;
    }

    public int hangmanState() {
        if (wrongInput.getSize() == 0)
        return 0;
        nextState = nextState + stepSize*wrongInput.getSize();
        System.out.println(nextState +" step is "+stepSize );
        return nextState;
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

    private void generateNewRandomWord() {
        Random random = new Random();
        String[] picked = category.get(1);
        categoryName = picked[0];
        int rand;
        while (true) {
            rand = random.nextInt(picked.length);
            if (rand != 0)
                break;
        }
        word = picked[rand];
        System.out.println(word);

    }

    public ArrayList<Integer> indexesOfCharacter(char c) {
        ArrayList<Integer> send = new ArrayList<Integer>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c || word.charAt(i) == Character.toUpperCase(c)) {
                // tell gui to display the character
                send.add(i);
            }
        }
        if (send.size() == 0)
            wrongInput.insert(c);

        return send;
    }

}
