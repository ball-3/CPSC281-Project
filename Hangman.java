import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hangman extends JFrame implements ActionListener {

    private Draw draw;
    private int currentLevel = 0;

    Hangman() {
        draw = new Draw(0);
    }

    public void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        JPanel hangmanPanel = new JPanel();
        JPanel wrongWordPanel = new JPanel();
        JPanel wordPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JTextField textfield = new JTextField();
        JButton botton = new JButton("submit");

        // ask for only one char
        inputPanel.add(textfield, botton);
        hangmanPanel.add(draw);

        // add everything
        mainPanel.add(hangmanPanel, BorderLayout.LINE_START);
        mainPanel.add(wrongWordPanel, BorderLayout.CENTER);
        mainPanel.add(wordPanel, BorderLayout.PAGE_END);
        frame.add(mainPanel);

        // default
        frame.setTitle("Hangman game");

        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(700, 700));
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        draw = new Draw(currentLevel);
    }

}
