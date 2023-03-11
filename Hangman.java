import javax.swing.*;
import javax.swing.text.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JFrame implements ActionListener {

    private Draw draw;
    private int currentLevel = 20;
    private char input;
    private Word word;
    private String currentDisplay = "";
    public JFrame frame;

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
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font defult = new Font(currentDisplay, Font.BOLD, 25);

        JPanel mainPanel = new JPanel( new BorderLayout());
        JPanel hangmanPanel = new JPanel();
        JPanel wrongWordPanel = new JPanel();
        JPanel wordPanel = charBox(currentDisplay);
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField textField = new JTextField();
        textField.setDocument(new JTextFieldLimit(1));
        textField.setFont(defult);
        JButton button = new JButton("submit");

        // size panel
        mainPanel.setPreferredSize(new Dimension(1000, 800));
        hangmanPanel.setPreferredSize(new Dimension(600, 600));
        wrongWordPanel.setPreferredSize(new Dimension(400, 600));
        inputPanel.setPreferredSize(new Dimension(1000, 60));
        wordPanel.setPreferredSize(new Dimension(1000, 90));
        textField.setPreferredSize(new Dimension(40, 40)); 
        
       

        button.addActionListener(null);
        //set color
        mainPanel.setBackground(Color.BLACK);
        hangmanPanel.setBackground(Color.white);
        wrongWordPanel.setBackground(Color.CYAN);
        

        // provide input
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String textFieldValue = textField.getText();
                input = textFieldValue.charAt(0);
            }
        });

        // ask for only one char
        inputPanel.add(textField);
        inputPanel.add(button);
        hangmanPanel.add(draw);

        // add everything
        mainPanel.add(hangmanPanel, BorderLayout.CENTER);
        mainPanel.add(wrongWordPanel, BorderLayout.LINE_START);
        mainPanel.add(wordPanel, BorderLayout.PAGE_END);
        mainPanel.add(inputPanel, BorderLayout.PAGE_START);
        frame.add(mainPanel);
        

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
