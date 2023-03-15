public class HumanPicker extends Player{

    // sets word to be guessed, can be done through scanner
    public void setWord(String word){
        super.word.setWord(word);
        correctGuesses = new char[word.length()];
    }

    // draws body part on hangman
    public void drawBodyPart(){
        hangmanObject.addDrawnBodyPart();
    }

    public void seeIfGuessedLetterIsCorrect(){
        if(guessedLetterCorrect){
            for(int i = 0; i < correctGuessIndexes.size(); i++){
                if(correctGuessIndexes.get(i) != null){
                    correctGuesses[i] = guessedLetter;
                }
            }
        }else{
            drawBodyPart();
        }
    }

    public void setComputerDifficulty(int difficulty){
        Player.computerDifficulty = difficulty;
    }
}
