package sliderpuzzle;

import org.apache.commons.collections.map.MultiValueMap;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nikalsh
 * @author johanone
 */
public class gamePanel extends JPanel implements gameLogic {

static final Insets insets = new Insets (0, 0, 0, 0);

public gamePanel (int size) {
    
    GridBagLayout gridBagLayout = new GridBagLayout ();
    setLayout (gridBagLayout);
    
    int buttonNumber = 0;
    int y = 0;
    
    List<Integer> intList = new ArrayList<> (size * size);
    for (int i = 0; i < (size * size); i++) {
        intList.add (i);
    }
    
    Collections.shuffle (intList);
    
    int i, x;
    
    while (buttonList.size () < (size * size)) {
        for (i = 0, x = 0; i < size; i++, buttonNumber++, x++) {
            buttonList.add (new sliderButton ("Nr " + (buttonNumber)));
            addComponent (this, buttonList.get (buttonNumber), x, y, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
            buttonList.get (buttonNumber).putClientProperty ("column", x);
            buttonList.get (buttonNumber).putClientProperty ("row", y);
            buttonList.get (buttonNumber).putClientProperty ("null", false);
        }
        ++y;
    }
    buttonList.get (buttonList.size () - 1).putClientProperty ("null", true);
    buttonList.get (buttonList.size () - 1).setText ("null");
}

void addComponent (Container container, Component component, int gridx, int gridy,
                   int gridwidth, int gridheight, int anchor, int fill) {
    GridBagConstraints gbc = new GridBagConstraints (gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
            anchor, fill, insets, 0, 0);
    container.add (component, gbc);
}
    


        

}
    
   

        