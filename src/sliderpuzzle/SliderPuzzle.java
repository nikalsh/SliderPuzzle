/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;

import static sliderpuzzle.gameLogic.buttonList;

public class SliderPuzzle implements MouseListener {

public static void main (String[] args) throws MalformedURLException, IOException {
    
    gameBoard game = new gameBoard ();
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    GUIPanel gui = new GUIPanel ();
    
    game.add (new gamePanel (4));
    statPanel stats = new statPanel ();
    game.add (stats);
    game.add (gui);
    
    game.pack ();
    game.setLocationRelativeTo (null);
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
    
    
}

@Override
public void mouseClicked (MouseEvent e) {

}

@Override
public void mousePressed (MouseEvent e) {
    System.out.println (((JButton) e.getSource ()).getText ());
    for (int i = 0; i < buttonList.size (); i++) {
        if (buttonList.get (i).getText ().equals ("")) {
            buttonList.get (i).setText (((JButton) e.getSource ()).getText ());
            ((JButton) e.getSource ()).setText ("");
}}}

@Override
public void mouseReleased (MouseEvent e) {

}

@Override
public void mouseEntered (MouseEvent e) {

}

@Override
public void mouseExited (MouseEvent e) {

}
}
