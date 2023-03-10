import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    private int level;

    Draw(int level) {
        this.level = level;
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (level > -1) {
            g2.setStroke(new BasicStroke(10));
            g2.setColor(Color.black);
        }
        if (level > 0) {
            // box bottom
            g2.fillRect(300, 330, 90, 20);
        }
        if (level > 1) {
            // box 2
            g2.fillRect(300, 310, 90, 20);
        }
        if (level > 2) {
            // box 3
            g2.fillRect(300, 290, 90, 20);
        }
        if (level > 3) {
            // box 4
            g2.fillRect(300, 270, 90, 20);
        }
        if (level > 4) {
            // box 5
            g2.fillRect(300, 250, 90, 20);
        }

        // hanger
        if (level > 5) {
            // face
            g2.drawOval(325, 100, 50, 50);
        }
        if (level > 6) {
            // body
            g2.drawLine(350, 150, 350, 250);
        }

        if (level > 7) {
            // hand right
            g2.drawLine(350, 150, 370, 200);
        }
        if (level > 8) {
            // hand left
            g2.drawLine(350, 150, 330, 200);
        }
        if (level > 9) {
            // with brock (5) legs 1
            g2.drawLine(350, 250, 400, 250);
        }
        if (level > 10) {
            // with brock (5) legs 2
            g2.drawLine(350, 250, 400, 220);
        }
        if (level > 11) {
            g2.drawLine(350, 50, 350, 100);

        }
        if (level > 12) {
            g2.drawLine(150, 50, 350, 50);

        }
        if (level > 13) {//not sure
            g2.drawLine(150, 50, 150, 350);

        }
        if (level > 14) {
            g2.drawLine(100, 350, 200, 350);

        }
        if (level > 15) {
            g2.drawLine(200, 50, 150, 100);

        }

        // deleting...
        if (level > 16) {
            // legs
            g2.setColor(Color.white);
            // delete boxes
            // with brock (5) legs 1
            g2.drawLine(350, 250, 400, 250);
        }
        if (level > 17) {
            // with brock (5) legs 2
            g2.drawLine(350, 250, 400, 220);
        }
        if (level > 18) {
            // box bottom
            g2.fillRect(300, 250, 90, 20);
        }
        if (level > 19) {
            // box 2
            g2.fillRect(300, 270, 90, 20);
        }
        if (level > 20) {
            // box 3
            g2.fillRect(300, 290, 90, 20);
        }

        if (level > 21) {
            // box 4
            g2.fillRect(300, 310, 90, 20);
        }
        if (level > 22) {
            // box 5
            g2.fillRect(300, 330, 90, 20);
        }

        // add leg
        if (level > 16) {
            g2.setColor(Color.black);
            g2.drawLine(350, 250, 330, 300);
        }
        if (level > 16) {
            g2.drawLine(350, 250, 370, 300);
        }

    }

}
