package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

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

                    //TODO link controller scheme to game logic
                    case KeyEvent.VK_UP:
                        System.out.println("pressed up");
                        break;

                    case KeyEvent.VK_DOWN:
                        System.out.println("pressed down");
                        break;

                    case KeyEvent.VK_LEFT:
                        System.out.println("pressed left");
                        break;

                    case KeyEvent.VK_RIGHT:
                        System.out.println("pressed right");
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
