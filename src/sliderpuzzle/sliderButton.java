package sliderpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

/**
 *
 * @author nikalsh
 *
 */
public class sliderButton extends JButton implements gameLogic {

private ImageIcon icon;

public sliderButton(String s) {
    super(s);
    addActionListener(l -> {
        System.out.print ("pressed button: ");
        System.out.println (((sliderButton) l.getSource()).getText  ());
        for (int i = 0; i < gameLogic.buttonList.size (); i++) {
            if (gameLogic.buttonList.get (i).getText ().equals ("")) {
                gameLogic.buttonList.get (i).setText (((sliderButton) l.getSource()).getText ());
                ((sliderButton) l.getSource ()).setText ("");
            }
    
        }
        //TODO:
        //canButtonBeMovedOrNot();
    });
    
}
}
