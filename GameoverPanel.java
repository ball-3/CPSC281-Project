import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameoverPanel extends JPanel{

    public GameoverPanel (){
            setPreferredSize(new Dimension(1000, 800));
            JButton restart = new JButton("menu");
            restart.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    //new frame??
    
                }

                
            });
            add(restart);


    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("MS Comic Sans", Font.BOLD, 40));
        g2.drawString("GAME OVER", 100, 100);




    }

    
}
