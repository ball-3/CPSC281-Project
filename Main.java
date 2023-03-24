import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Word word = new Word(20);

        Hangman display = new Hangman(word, true);

        display.setSize(1000, 650);
        display.setTitle("project");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);

    }
}
