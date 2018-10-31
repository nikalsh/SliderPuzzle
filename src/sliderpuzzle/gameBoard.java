package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

/**
 *
 * @author nikalsh
 */
public class gameBoard extends JFrame {
    
    private List<KBControllerListener> listeners = new ArrayList<>();
    
    public void addListener(KBControllerListener toAdd) {
        listeners.add(toAdd);
    }
    
    private class myKeyListener implements KeyEventDispatcher {
        
        public myKeyListener() {
        }
        
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                switch (e.getKeyCode()) {
                    
                    case KeyEvent.VK_Q:
                        System.out.println("bye");
                        System.exit(0);
                        break;
                    
                    case KeyEvent.VK_R:
                        System.out.println("restarting");
                        //TODO restartGame();
                        break;
                    
                    case KeyEvent.VK_UP:
                        listeners.stream().forEach((listener) -> { 
                            listener.move("up");
                        });
                        break;
                    
                    case KeyEvent.VK_DOWN:
                             listeners.stream().forEach((listener) -> { 
                            listener.move("down");
                        });
                        break;
                    
                    case KeyEvent.VK_RIGHT:
                            listeners.stream().forEach((listener) -> { 
                            listener.move("right");
                        });
                        break;
                    
                    case KeyEvent.VK_LEFT:
                             listeners.stream().forEach((listener) -> { 
                            listener.move("left");
                        });
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
