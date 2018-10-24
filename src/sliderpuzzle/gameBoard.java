package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author nikalsh
 */
public class gameBoard extends JFrame {

    class myKeyListener implements KeyEventDispatcher {

        public myKeyListener() {
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_RELEASED) {
                if (e.getKeyCode() == KeyEvent.VK_Q) {
                    System.exit(0);
                    dispose();
                } else if (e.getKeyCode() == KeyEvent.VK_R) {
                        System.out.println("Restarting the game");
                        //TODO:
                        //restartGame();q
                }
            }
            return false;
        }

    }

    private myKeyListener keyListener = new myKeyListener();
    private gamePanel gamePanel;
    private statsPanel statsPanel;

    public gameBoard() {
        gamePanel = new gamePanel(9);
        statsPanel = new statsPanel();
        gamePanel.setBackground(Color.red);
        statsPanel.setBackground(Color.blue);

        setLayout(new GridLayout(1, 1));
        add(gamePanel);
        add(statsPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);

        pack();

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new myKeyListener());
    }

}
