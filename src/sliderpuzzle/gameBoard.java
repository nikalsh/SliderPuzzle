package sliderpuzzle;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class gameBoard extends JFrame {

    private gamePanel gamePanel;

    public gameBoard() {
        gamePanel = new gamePanel(9);
        this.add(gamePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);
        pack();
    
    
    
    }

}
