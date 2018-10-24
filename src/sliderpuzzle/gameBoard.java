package sliderpuzzle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author nikalsh
 */
public class gameBoard extends JFrame implements KeyListener{

    private gamePanel gamePanel;

    public gameBoard() {
        gamePanel = new gamePanel(9);
        this.add(gamePanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        pack();
        addKeyListener(this);

    }
    
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e.getKeyCode());
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e);
    }

}
