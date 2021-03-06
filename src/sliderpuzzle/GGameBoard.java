package sliderpuzzle;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author nikalsh
 */
public class GGameBoard extends JFrame implements GameStateListener {

    private myKeyListener keyListener = new myKeyListener();

    private List<RestartGameListener> RGListerners = new ArrayList<>();
    private List<KBControllerListener> KBListeners = new ArrayList<>();
    private List<KBSubmitListener> KBSubmitListeners = new ArrayList<>();

    private KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    private boolean enabledArrowKeys = true;
    private boolean enabledEnterButton = false;

    public void addKBControllerListener(KBControllerListener toAdd) {
        KBListeners.add(toAdd);
    }

    public void addRGListener(RestartGameListener toAdd) {
        RGListerners.add(toAdd);
    }
    
    public void addKBSubmitListener(KBSubmitListener toAdd){
        KBSubmitListeners.add(toAdd);
    }

    @Override
    public void changeToWinState() {
        enabledArrowKeys = false;
        enabledEnterButton = true;
    }

    @Override
    public void changeToPlayState() {
        enabledArrowKeys = true;
        enabledEnterButton = false;
    }

    private class myKeyListener implements KeyEventDispatcher {

        public myKeyListener() {
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED && enabledArrowKeys) {
                
                    switch (e.getKeyCode()) {

                        case KeyEvent.VK_Q:
//                        System.out.println("bye");
//                        System.exit(0);
                            break;

                        case KeyEvent.VK_R:
//                        System.out.println("restarting");
//                        RGListerners.forEach(RestartGameListener::newGame);
                            break;

                            
                            
                        case KeyEvent.VK_UP:
                            KBListeners.stream().forEach((listener) -> {
                                listener.move("up");
                            });
                            break;

                        case KeyEvent.VK_DOWN:
                            KBListeners.stream().forEach((listener) -> {
                                listener.move("down");
                            });
                            break;

                        case KeyEvent.VK_RIGHT:
                            KBListeners.stream().forEach((listener) -> {
                                listener.move("right");
                            });
                            break;

                        case KeyEvent.VK_LEFT:
                            KBListeners.stream().forEach((listener) -> {
                                listener.move("left");
                            });
                            break;

                    }
                }
            
            if (e.getID() == KeyEvent.KEY_RELEASED && enabledEnterButton){
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    KBSubmitListeners.forEach(KBSubmitListener::submitByEnterPress);
                }
            }
            
            return false;
        }
    }

    public GGameBoard() {

        setTitle("Game Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        manager.addKeyEventDispatcher(keyListener);

    }

}
