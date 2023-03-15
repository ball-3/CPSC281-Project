import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangManGUI extends Hangman{
    JFrame hangmanFrame;

    public HangManGUI(){
        hangmanFrame = new JFrame();
        hangmanFrame.setLayout(null);
        hangmanFrame.setSize(1000, 1000);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawHead();
            }
        };
        addButton("Head", actionListener,10, 10, 100, 75);

        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawBody();
            }
        };
        addButton("Body", actionListener1,110 , 10, 100, 75);

        hangmanFrame.setVisible(true);
        hangmanFrame.setResizable(false);
        hangmanFrame.setLocationRelativeTo(null);




    }

    public void drawArm(){
        JLabel label = new JLabel();
        label.setIcon(getImageIcon("..."));
        label.setBounds(350, 300, 1000, 1000);
        label.setSize(500,500);
        label.setVisible(true);
        hangmanFrame.add(label);
        hangmanFrame.repaint();
    }

    public void drawBody(){
        JLabel label = new JLabel();
        label.setIcon(getImageIcon("data/line.png"));
        label.setBounds(350, 300, 1000, 1000);
        label.setSize(500,500);
        label.setVisible(true);
        hangmanFrame.add(label);
        hangmanFrame.repaint();
    }

    public ImageIcon getImageIcon(String filename){
        ImageIcon head = new ImageIcon(filename);
        Image image = head.getImage();
        Image scaledImage = image.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void drawHead(){

        JLabel label = new JLabel();
        label.setIcon(getImageIcon("data/dead.png"));
        label.setBounds(350, 0, 1000, 1000);
        label.setSize(500,500);
        label.setVisible(true);
        hangmanFrame.add(label);
        hangmanFrame.repaint();

    }


    public void addButton(String title, ActionListener actionListener,  int x, int y, int w, int h){
        JButton button = new JButton(title);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBounds(x,y,w,h);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(actionListener);
        hangmanFrame.getContentPane().add(button);


    }


}
