import javax.swing.JComponent;
import java.awt.*;

public class CharacterBox extends JComponent {

    private char boxWord;
    private int x;
    private int y;
    private int yForNum;
    private boolean isGuessed = false;

    public CharacterBox(char c, int xAxis, int yAxis) {
        setPreferredSize(new Dimension(40, 40));
        boxWord = c;
        if (c == ' ')
            isGuessed = true;
        this.x = xAxis;
        this.y = yAxis;
        yForNum = yAxis + 50;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        System.out.print(isGuessed + " c = " + boxWord + ", ");
        if (isGuessed) {
            System.out.println("1");
            g2.setFont(new Font("Verdana", Font.BOLD, 20));
            g2.drawString(String.valueOf(boxWord), 20, 30);
        } else {
            System.out.println("2");
            g2.fillRect(0, 0, 30, 30);

        }
    }

    public void setGuessedTrue() {
        this.isGuessed = true;
    }

}
