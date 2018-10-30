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

public static void main (String[] args) throws MalformedURLException, IOException {
    
    
    
    gameBoard game = new gameBoard ();
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    GUIPanel gui = new GUIPanel ();
    
    game.add (new gamePanel (7));
    statPanel stats = new statPanel ();
    game.add (stats);
    game.add (gui);
    
    game.pack ();
    game.setLocationRelativeTo (null);
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
    
    
    
}
public void redrawWithNewSize (int size) {
    
  //  new gameBoard ().removeAll();
    gameBoard game = new gameBoard ();
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    GUIPanel gui = new GUIPanel ();
    
    game.add (new gamePanel (size));
    statPanel stats = new statPanel ();
    game.add (stats);
    game.add (gui);
    
    game.pack ();
    
}


@Override
public void mouseClicked (MouseEvent e) {

}

@Override
public void mousePressed (MouseEvent e) {
    
    System.out.println (((JButton) e.getSource ()).getText ());
    
    for (int i = 0; i < buttonList.size (); i++) {
    
            buttonList.get (i).setText (((JButton) e.getSource ()).getText ());
            ((JButton) e.getSource ()).setText ("");
}}

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

