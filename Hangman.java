import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JFrame implements ActionListener {

    private Draw draw;
    private int currentLevel = 0;
    private char input;
    private Word word;
    private String currentDisplay = "";

    Hangman(Word w) {
        this.draw = new Draw(currentLevel);
        this.word = w;
        // if the word is apple, it will makes currentDispay = "00000"
        // social psychology -> "000000 00000"
        for (int i = 0; i < w.getWord().length(); i++) {
            if (w.getWord().charAt(i) != ' ') {
                currentDisplay = currentDisplay + '0';
            } else {
                currentDisplay = currentDisplay + ' ';
            }
        }
    }

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel hangmanPanel = new JPanel();
        JPanel wrongWordPanel = new JPanel();
        JPanel wordPanel = charBox(currentDisplay);
        JPanel inputPanel = new JPanel();
        JTextField textField = new JTextField();
        JButton button = new JButton("submit");

        // size panel
        mainPanel.setSize(1000, 800);
        hangmanPanel.setSize(500, 500);
        wrongWordPanel.setSize(500, 500);
        inputPanel.setSize(1000, 150);
        wordPanel.setSize(1000, 150);

        button.addActionListener(null);

        // provide input
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textFieldValue = textField.getText();
                input = textFieldValue.charAt(0);
            }
        });

        // ask for only one char
        inputPanel.add(textField, button);
        hangmanPanel.add(draw);

        // add everything
        mainPanel.add(hangmanPanel, BorderLayout.LINE_START);
        mainPanel.add(wrongWordPanel, BorderLayout.CENTER);
        mainPanel.add(wordPanel, BorderLayout.PAGE_END);
        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel);

        // default
        frame.setTitle("Hangman game");

        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(1000, 800));
        frame.setVisible(true);

    }

    public void makeWord(char c, Word w) {
        // includedWord will return "1,2" if word apple and character is p
        String info = w.includedWord(c);
        int index;
        String num = "";
        String newDisplay;
        if (info != null) {

            for (int i = 0; i < info.length(); i++) {

                while (info.charAt(i) != ',' && i < info.length()) {
                    num = num + info.charAt(i);
                    if (i >= info.length() - 1) {
                        break;
                    } else {
                        i++;
                    }
                }

                index = Integer.valueOf(num);
                StringBuffer string = new StringBuffer(currentDisplay);
                string.setCharAt(index, c);
                currentDisplay = string.toString();

            }

        }

    }

    public JPanel charBox(String word) {
        JPanel main = new JPanel(new FlowLayout());

        for (int i = 0; i < currentDisplay.length(); i++) {
            Character box = new Character(currentDisplay.charAt(i), 2, 2);
            main.add(box);

        }

        return main;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        draw = new Draw(currentLevel);

    }

}
