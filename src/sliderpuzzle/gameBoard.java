package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author nikalsh
 */
public class gameBoard extends JFrame {

    private class myKeyListener implements KeyEventDispatcher {

        public myKeyListener() {
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_RELEASED) {
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_Q:
                        System.out.println("bye");
                        System.exit(0);
                        break;

                    case KeyEvent.VK_R:
                        System.out.println("restarting");
                        //TODO restartGame();
                        break;

                }
            }
            return false;
        }
    }

    private myKeyListener keyListener = new myKeyListener();

    public gameBoard() {

        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new myKeyListener());
        
    }

}
