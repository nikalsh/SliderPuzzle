/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.*;

import static sliderpuzzle.gameLogic.buttonList;

public class SliderPuzzle implements MouseListener {
JFrame game;
gamePanel gamePanel;
private JPanel statRow = new JPanel();

private JButton newGame = new JButton("Nytt spel");
private JButton quit = new JButton("Avsluta");
private JButton move = new JButton("Flytta");
private JButton gridSize = new JButton("Grid size");


public SliderPuzzle (int size) {
    
    buttonList.clear ();
    setGame (new JFrame ());
    
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    
    setGamePanel (new gamePanel (size));
    game.add(getGamePanel ());
    statPanel stats = new statPanel ();
    game.add (stats);
    game.add (GUIPanel ());

    game.pack ();
    game.setLocationRelativeTo (null);
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
}

public JFrame getGame () {
    return game;
}

public SliderPuzzle setGame (JFrame game) {
    this.game = game;
    return this;
}

public void redrawPuzzle (int size) {
    buttonList.clear ();
    game = getGame ();

getGamePanel ().removeAll ();
    game.add (new gamePanel (9));
    
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    game.setLocationRelativeTo (null);
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
    game.pack ();
}

public JPanel getGamePanel () {
    return gamePanel;
}

public SliderPuzzle setGamePanel (gamePanel gamePanel) {
    this.gamePanel = gamePanel;
    return this;
}

public SliderPuzzle () {

}
JPanel GUIPanel() {
    JPanel GUIPanel = new JPanel ();
    GUIPanel.setLayout(new FlowLayout (FlowLayout.LEFT, 5, 5));
    
    GUIPanel.add(newGame);
    GUIPanel.add(move);
    
    GUIPanel.add(quit);
    GUIPanel.add(gridSize);
    
    newGame.addActionListener(l -> {
        
        System.out.println("new game");
    });
    
    quit.addActionListener(l -> {
        
        System.out.println("bye");
        System.exit(0);
    });
    
    move.addActionListener(l -> {
        System.out.println("make a move");
        //TODO implement move logic
    });
    
    gridSize.addActionListener(l -> {
        int size = 8;
        System.out.println("chooses grid size");
        redrawPuzzle (8);
    });
    return GUIPanel;
}

public static void main (String[] args) throws MalformedURLException, IOException {
    
SliderPuzzle sliderPuzzle = new SliderPuzzle (5);

    
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

