import javax.swing.*;
import javax.swing.text.*;

import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Hangman extends JFrame implements ActionListener {

    private Draw draw;
    private int currentLevel = 20;
    private char input;
    private Word word;
    private String currentDisplay = "";
    private JPanel mainPanel;
    CharacterBoxPanel characterBoxPanel;

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
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font defult = new Font("MS Comic Sans", Font.BOLD, 25);

        mainPanel = new JPanel(new BorderLayout());
        JPanel hangmanPanel = new JPanel();
        JPanel wrongWordPanel = new JPanel();
        characterBoxPanel = new CharacterBoxPanel(this.word.getWord());
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField textField = new JTextField();
        textField.setDocument(new JTextFieldLimit(1));
        textField.setFont(defult);
        JButton button = new JButton("submit");
        JLabel wrongInput = new JLabel();

        // size panel
        mainPanel.setPreferredSize(new Dimension(1000, 800));
        hangmanPanel.setPreferredSize(new Dimension(600, 600));
        wrongWordPanel.setPreferredSize(new Dimension(400, 600));
        inputPanel.setPreferredSize(new Dimension(1000, 60));
        characterBoxPanel.setPreferredSize(new Dimension(1000, 90));
        textField.setPreferredSize(new Dimension(40, 40));

        // set color
        mainPanel.setBackground(Color.BLACK);
        hangmanPanel.setBackground(Color.white);
        wrongWordPanel.setBackground(Color.CYAN);
        characterBoxPanel.setBackground(Color.red);

        // provide input
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textFieldValue = textField.getText();
                input = textFieldValue.charAt(0);
                guessChar(input, word);

                textField.setText("");
            }
        });

        // ask for only one char
        inputPanel.add(textField);
        inputPanel.add(Box.createHorizontalStrut(150));
        inputPanel.add(button);
        hangmanPanel.add(draw);

        // wrong input
        wrongWordPanel.setLayout(new BoxLayout(wrongWordPanel, BoxLayout.Y_AXIS));
        JLabel discription = new JLabel("Wrong input");
        wrongWordPanel.add(discription);
        wrongWordPanel.add(wrongInput);

        // add everything
        mainPanel.add(hangmanPanel, BorderLayout.CENTER);
        mainPanel.add(wrongWordPanel, BorderLayout.LINE_START);
        mainPanel.add(characterBoxPanel, BorderLayout.PAGE_END);
        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        add(mainPanel);

    }

    public void guessChar(char c, Word w) {
        // includedWord will return "1,2" if word apple and character is p
        ArrayList<Integer> matchedIndexes = w.indexesOfCharacter(c);
        String num = "";
        String newDisplay;
        boolean changed = false;
        System.out.println(matchedIndexes);
        if (matchedIndexes.size() != 0) {

            for (int i = 0; i < matchedIndexes.size(); i++) {

                StringBuffer string = new StringBuffer(currentDisplay);
                string.setCharAt(matchedIndexes.get(i), c);
                currentDisplay = string.toString();

            }
            characterBoxPanel.updateCharBoxes(currentDisplay);
            mainPanel.repaint();
            System.out.println(currentDisplay);

            changed = true;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        draw = new Draw(currentLevel);

    }

}

class JTextFieldLimit extends PlainDocument {

    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    JTextFieldLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
