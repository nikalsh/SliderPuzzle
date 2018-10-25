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
public class gamePanel extends JPanel {

List<JButton> buttonList = new ArrayList<> ();

private JLabel label;
private int gridSize;

public gamePanel (int size) {
    this.gridSize = size * size;
    
    for (int i = 1; i < gridSize; i++) {
        this.add (new sliderButton (Integer.toString (i)));
    }
    this.add (new sliderButton ("LAST BUTTON"));
    setLayout (new GridLayout (size, size));
    setPreferredSize (new Dimension (500, 500));
    
  //  for (int i = 0; i < ((size * size)); i++) {
     //   buttonList.add (new JButton ("Button " + i));
     
     
  //  }
    
    
}


MouseListener ml = new MouseListener () {
    
    @Override
    public void mousePressed (MouseEvent e) {
        System.out.println (((JButton) e.getSource ()).getIcon ());
        for (int i = 0; i < buttonList.size (); i++) {
            if (buttonList.get (i).getIcon () == null) {
                buttonList.get (i).setIcon (((JButton) e.getSource ()).getIcon ());
                ((JButton) e.getSource ()).setIcon (null);
            }
        }
    }
    
    @Override
    public void mouseReleased (MouseEvent e) {
    
    }
    
    @Override
    public void mouseEntered (MouseEvent e) {
    
    }
    
    @Override
    public void mouseClicked (MouseEvent e) {
    }
    
    @Override
    public void mouseExited (MouseEvent e) {
    }
    
    
};

}
