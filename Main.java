import javax.print.attribute.standard.PageRanges;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {

        Word word = new Word(9);

        Hangman display = new Hangman(word);

        display.setSize(1000, 650);
        display.setTitle("project");
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setVisible(true);

    }
}
