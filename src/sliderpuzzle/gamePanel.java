package sliderpuzzle;

import com.sun.source.doctree.StartElementTree;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import static sliderpuzzle.gameLogic.buttonList;

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
    
    while (buttonList.size () < (size * size)) {
        for (int i = 0, x = 0; i < size; i++, buttonNumber++, x++) {
            buttonList.add (new sliderButton ("Nr " + buttonNumber));
            addComponent (this, buttonList.get (buttonNumber), x, y, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        }
        gbcTwo.anchor = GridBagConstraints.LINE_END;
        ++y;
    }
    gbcTwo.anchor = GridBagConstraints.LINE_START;
    
    buttonList.get (buttonList.size () - 1).setText ("");
    
}
/*
public class GridBag1 extends JPanel {
    GridBagConstraints constraints = new GridBagConstraints ();
    
    public GridBag1 () {
        setLayout (new GridBagLayout ());
        int x, y;  // for clarity
        addGB (new JButton ("North"), x = 1, y = 0);
        addGB (new JButton ("West"), x = 0, y = 1);
        addGB (new JButton ("Center"), x = 1, y = 1);
        addGB (new JButton ("East"), x = 2, y = 1);
        addGB (new JButton ("South"), x = 1, y = 2);
    }
    
    void addGB (Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        add (component, constraints);
    }
}*/


static void addComponent (Container container, Component component, int gridx, int gridy,
                              int gridwidth, int gridheight, int anchor, int fill) {
        int bananas = 0;
        GridBagConstraints gbc = new GridBagConstraints (gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
                anchor, fill, insets, 0, 0);
        container.add (component, gbc);
    }
    
    GridBagConstraints gbcTwo = new GridBagConstraints ();
    
    
    
    
}

    