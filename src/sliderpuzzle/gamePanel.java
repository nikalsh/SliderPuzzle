package sliderpuzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author nikalsh
 * @author johanone
 */
public class gamePanel extends JPanel implements gameLogic {

private JLabel label;
private int gridSize;

public gamePanel (int size) {
    
    this.gridSize = size * size;
    
    for (int i = 1; i < gridSize; i++) {
        gameLogic.buttonList.add (new sliderButton (Integer.toString (i)));
        this.add (gameLogic.buttonList.get (i-1));
    }
    
    gameLogic.buttonList.add (new sliderButton (""));
    this.add (gameLogic.buttonList.get(gameLogic.buttonList.size ()-1));
    
    setLayout (new GridLayout (size, size));
    setPreferredSize (new Dimension (500, 500));
    
}
    
    


}
