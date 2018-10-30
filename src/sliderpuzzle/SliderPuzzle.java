/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.*;
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

String[] gameSizeSettings = {
        "2	X 2",
        "3	X 3",
        "4	X 4",
        "5	X 5",
        "6	X 6",
        "7	X 7",
        "8	X 8",
        "9	X 9",
        "10	X 10",
        "11	X 11",
        "12	X 12"
};

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
game.remove (gamePanel);
    game.add (new gamePanel (size));
    
    game.setLayout (new BoxLayout (game.getContentPane (), BoxLayout.Y_AXIS));
    
    game.setVisible (true);
    game.setAlwaysOnTop (true);
    game.setResizable (true);
    game.setLocationRelativeTo (null);
    game.revalidate ();
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
    JComboBox<String> listOfGameSizes = new JComboBox<> (gameSizeSettings);
    listOfGameSizes.setSelectedIndex(2);
    GUIPanel.add(newGame);
    GUIPanel.add(move);
    
    GUIPanel.add(quit);
    GUIPanel.add(gridSize);
    GUIPanel.add(listOfGameSizes);
    
    
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
        System.out.println("chooses grid size");
        game.remove (gamePanel);
    
    
        int selectedIndex = listOfGameSizes.getSelectedIndex ();
        switch (selectedIndex) {
            case 0: redrawPuzzle (2);
                break;
            case 1: redrawPuzzle (3);
                break;
            case 2: redrawPuzzle (4);
                break;
            case 3: redrawPuzzle (5);
                break;
            case 4: redrawPuzzle (6);
                break;
            case 5: redrawPuzzle (7);
                break;
            case 6: redrawPuzzle (8);
                break;
            case 7: redrawPuzzle (9);
                break;
            case 8: redrawPuzzle (10);
                break;
            case 9: redrawPuzzle (11);
                break;
            case 10: redrawPuzzle (12);
                break;
        }
        
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

