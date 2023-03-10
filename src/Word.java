package src;

import java.util.ArrayList;

public class Word {

    public char[] word;

    public void setWord(String newWord){
        word = new char[newWord.length()];
        for(int i = 0; i< newWord.length(); i++){
            word [i] = newWord.charAt(i);
        }
    }

    public ArrayList<Integer> checkLetter(char x){
        ArrayList<Integer> correctGuessIndexes = new ArrayList<>();

        for(int i = 0; i < Player.word.word.length; i++){
            if (word[i] == x) {
                correctGuessIndexes.add(i);
            }
        }
        return correctGuessIndexes;
    }
}
