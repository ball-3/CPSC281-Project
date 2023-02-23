import javax.swing.*;
import java.awt.*;

public class Draw extends JComponent {
    private int level;

    Draw(int level) {
        this.level = level;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        if (level > -1) {
            g2.setStroke(new BasicStroke(10));
            g2.setColor(Color.black);
        }
        if (level > 0) {
            // box bottom
            g2.fillRect(300, 380, 90, 20);
        }
        if (level > 1) {
            // box 2
            g2.fillRect(300, 360, 90, 20);
        }
        if (level > 2) {
            // box 3
            g2.fillRect(300, 340, 90, 20);
        }
        if (level > 3) {
            // box 4
            g2.fillRect(300, 320, 90, 20);
        }
        if (level > 4) {
            // box 5
            g2.fillRect(300, 300, 90, 20);
        }

        // hanger
        if (level > 5) {
            // face
            g2.drawOval(325, 150, 50, 50);
        }
        if (level > 6) {
            // body
            g2.drawLine(350, 200, 350, 300);
        }

        if (level > 7) {
            // hand right
            g2.drawLine(350, 200, 370, 250);
        }
        if (level > 8) {
            // hand left
            g2.drawLine(350, 200, 330, 250);
        }
        if (level > 9) {
            // with brock (5) legs 1
            g2.drawLine(350, 300, 400, 300);
        }
        if (level > 10) {
            // with brock (5) legs 2
            g2.drawLine(350, 300, 400, 270);
        }
        if (level > 11) {
            g2.drawLine(350, 100, 350, 150);

        }
        if (level > 12) {
            g2.drawLine(150, 100, 350, 100);

        }
        if (level > 13) {
            g2.drawLine(150, 100, 150, 400);

        }
        if (level > 14) {
            g2.drawLine(100, 400, 200, 400);

        }
        if (level > 15) {
            g2.drawLine(200, 100, 150, 150);

        }

        // deleting...
        if (level > 16) {
            // legs
            g2.setColor(Color.white);
            // delete boxes
            // with brock (5) legs 1
            g2.drawLine(350, 300, 400, 300);
        }
        if (level > 17) {
            // with brock (5) legs 2
            g2.drawLine(350, 300, 400, 270);
        }
        if (level > 18) {
            // box bottom
            g2.fillRect(300, 300, 90, 20);
        }
        if (level > 19) {
            // box 2
            g2.fillRect(300, 320, 90, 20);
        }
        if (level > 20) {
            // box 3
            g2.fillRect(300, 340, 90, 20);
        }

        if (level > 21) {
            // box 4
            g2.fillRect(300, 360, 90, 20);
        }
        if (level > 22) {
            // box 5
            g2.fillRect(300, 380, 90, 20);
        }

        // add leg
        if (level > 23) {
            g2.setColor(Color.black);
            g2.drawLine(350, 300, 330, 350);
        }
        if (level > 24) {
            g2.drawLine(350, 300, 370, 350);
        }

    }

}
