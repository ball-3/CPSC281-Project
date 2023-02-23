import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JFrame implements ActionListener {

    private Draw draw;
    private int currentLevel = 0;
    private char input;

    Hangman() {
        draw = new Draw(currentLevel);
    }

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel hangmanPanel = new JPanel();
        JPanel wrongWordPanel = new JPanel();
        JPanel wordPanel = new JPanel();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        draw = new Draw(currentLevel);

    }

}
