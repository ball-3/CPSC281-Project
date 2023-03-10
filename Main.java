import javax.print.attribute.standard.PageRanges;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        
        Word word = new Word(1);

        Hangman display = new Hangman(word);

        JFrame f = display.frame;
        JPanel p = new Draw(20);
        
        

    



        f.setSize(1000, 800);
        f.setTitle("project");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
    
}
}
