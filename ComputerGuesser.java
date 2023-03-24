import java.util.ArrayList;
import java.util.Random;

public class ComputerGuesser extends Player{
    BigramGraph bigramGraph;
    Letter currentLetter;
    Letter letterToGuess;
    Letter nextLetterToGuess;
    Random rand;

    public ComputerGuesser(){
        bigramGraph = new BigramGraph();
        currentLetter = null;
        letterToGuess = null;
        nextLetterToGuess = bigramGraph.listOfLetters.get(4); // 'e'
        rand = new Random();
    }

    public void guessLetter(){
        if(nextLetterToGuess != null){
            guessedLetter = nextLetterToGuess.label;
            currentLetter = nextLetterToGuess;
        }else{
            getNewLetterToGuess();
        }

        System.out.println("Guessed letter: " + guessedLetter);
        correctGuessIndexes = checkLetter(guessedLetter);

        if(correctGuessIndexes.isEmpty()){
            guessedLetterCorrect = false;
            System.out.println("Letter was incorrect.");
            bigramGraph.listOfLetters.remove(currentLetter);
            currentLetter = null;
            nextLetterToGuess = null;
        }else{
            guessedLetterCorrect = true;
            letterToGuess = null;
            System.out.println("Letter was correct.");
            bigramGraph.listOfLetters.remove(currentLetter);
            getNextLetterToGuess();
        }


        if(word.lettersLeft == 0){
            wordIsGuessed = true;
            System.out.println("\nI got the correct word!");
        }
    }

    public ArrayList<Integer> checkLetter(char x){
        return word.indexesOfCharacter(x);
    }


    public void getNewLetterToGuess(){
        int index = rand.nextInt(bigramGraph.listOfLetters.size());

        Letter letter = bigramGraph.listOfLetters.get(index);
        currentLetter = letter;
        letterToGuess = letter;
        guessedLetter = letterToGuess.label;
    }

    public void getNextLetterToGuess(){
        for(Letter l : currentLetter.pointers){
            if(l == null){
                currentLetter.pointers.remove(null);
            }
        }

        if(currentLetter.pointers.isEmpty()){
            nextLetterToGuess = null;
        }else{
           nextLetterToGuess = currentLetter.pointers.get(0);
           currentLetter = currentLetter.pointers.get(0);
            System.out.println("Next Letter to guess: " + nextLetterToGuess.label);
        }
    }





}
