package sliderpuzzle;

import com.sun.source.doctree.StartElementTree;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author nikalsh
 * @author johanone
 */
public class gamePanel extends JPanel implements gameLogic {

private JLabel label;
private int gridSize;

static final Insets insets = new Insets (0, 0, 0, 0);



public gamePanel (int size)  {
    
    setLayout (new GridBagLayout ());
    
    int buttonNumber = 0;
            int y = 0;
            
            while (buttonList.size () < (size * size)) {
                for (int i = 0, x = 0; i < size; i++, buttonNumber++, x++) {
                    buttonList.add (new sliderButton ("Nr " + buttonNumber));
                    addComponent (this, buttonList.get (buttonNumber), x, y, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
                }
                ++y;
            }
buttonList.get (buttonList.size ()-1).setText ("");
        }
        
        private static void addComponent (Container container, Component component, int gridx, int gridy,
                                          int gridwidth, int gridheight, int anchor, int fill) {
            GridBagConstraints gbc = new GridBagConstraints (gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                    anchor, fill, insets, 0, 0);
            container.add (component, gbc);
        }
    }




    