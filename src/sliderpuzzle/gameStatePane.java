/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class gameStatePane extends JLayeredPane {

    JPanel gamePanel;

    public gameStatePane() {
        setPreferredSize(new Dimension(500, 500));
        setOpaque(false);

    }

    
    public Component addGamePanel(Component cmpnt, int i) {
        gamePanel = (JPanel) cmpnt;
        gamePanel.setVisible(true);

        return super.add(cmpnt, i);
    }

}
