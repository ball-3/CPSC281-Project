import java.util.ArrayList;

public class Player {
    static char guessedLetter;
    static ArrayList<Integer> correctGuessIndexes;
    static boolean guessedLetterCorrect;
    static char[] correctGuesses;
    static Word word = new Word();
    static Hangman hangmanObject;
    static int computerDifficulty;
    static boolean wordIsGuessed = false;
}
