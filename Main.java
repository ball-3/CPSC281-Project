public class Main {
    public static void main(String[] args){
        ComputerGuesser cg = new ComputerGuesser();
        HumanPicker humanPicker = new HumanPicker();

        humanPicker.setWord("movie");
        while(!Player.wordIsGuessed){
            cg.guessLetter();
        }

    }
}
