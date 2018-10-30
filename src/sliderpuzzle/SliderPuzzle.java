/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;

import static sliderpuzzle.gameLogic.buttonList;

public class SliderPuzzle implements MouseListener {

public SliderPuzzle (int size) {
    
    buttonList.clear ();
    gameBoard game = new gameBoard ();
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    GUIPanel gui = new GUIPanel ();
    
    game.add (new gamePanel (size));
    statPanel stats = new statPanel ();
    game.add (stats);
    game.add (gui);
    
    game.pack ();
    game.setLocationRelativeTo (null);
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
    
}

public static void main (String[] args) throws MalformedURLException, IOException {
    
    gameBoard game = new gameBoard ();
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    GUIPanel gui = new GUIPanel ();
    
    game.add (new gamePanel (5));
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
    
}

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

