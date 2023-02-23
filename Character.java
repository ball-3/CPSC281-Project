import javax.swing.JComponent;
import java.awt.*;

public class Character extends JComponent{
   
    private char boxWord;
    private int x;
    private int y;
    private int yForNum;


    public Character (char word, int xAxis, int yAxis) {
       
        boxWord = word;
        x = xAxis;
        y = yAxis;
        yForNum = yAxis + 50;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawRect(x - 1, y, 38, 36);
        if (boxWord == ' ') {
            g2.setColor(Color.white);
            g2.fillRect(x, y, 40, 40);
            g2.setColor(Color.BLACK);
        } else if (boxWord == '0'){
            g2.fillRect(x, y, 40, 40);

        }
        else {
            g2.setFont(new Font("Verdana", Font.BOLD, 20));
            g2.drawString(String.valueOf(boxWord), 20, 30);
        
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(40, 40);
    }

    
}
