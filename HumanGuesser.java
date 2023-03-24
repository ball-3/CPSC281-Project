import java.util.ArrayList;

public class HumanGuesser extends Player {

    // guesses letter
    public void guessLetter(char letter){
        Player.guessedLetter = letter;
        correctGuessIndexes = checkLetter(letter);

        if(correctGuessIndexes.isEmpty()){
            guessedLetterCorrect = false;
        }else{
            guessedLetterCorrect = true;
        }
    }

    // checks letter of word
    public ArrayList<Integer> checkLetter(char x){
        return word.indexesOfCharacter(x);
    }

    public void setComputerDifficulty(int difficulty){
        Player.computerDifficulty = difficulty;
    }




}
