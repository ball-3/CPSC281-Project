import java.util.ArrayList;

public class Word {

    public char[] word;
    String stringWord;
    int lettersLeft;

    public Word(){
        stringWord = "";
        lettersLeft = 0;
    }

    public void setWord(String newWord){
        stringWord = newWord;
        word = new char[stringWord.length()];
        for(int i = 0; i< newWord.length(); i++){
            word [i] = newWord.charAt(i);
        }
        lettersLeft = stringWord.length();
    }

    public ArrayList<Integer> checkLetter(char x){
        ArrayList<Integer> correctGuessIndexes = new ArrayList<>();

        for(int i = 0; i < Player.word.word.length; i++){
            if (word[i] == x) {
                correctGuessIndexes.add(i);
                lettersLeft -= 1;
            }
        }

        return correctGuessIndexes;
    }
}
