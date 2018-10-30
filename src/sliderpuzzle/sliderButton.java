package sliderpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nikalsh
 *
 */
public class sliderButton extends JButton implements gameLogic {

sliderButton oldNullBUTT = null;

public sliderButton (String s) {
    super (s);
    
    addActionListener (l -> {
    
        System.out.println (buttonList.getClass ());
        
        for (int i = 0; i < buttonList.size (); i++) {
            boolean nullBool = (boolean) buttonList.get (i).getClientProperty ("null");
            if (nullBool) {
                oldNullBUTT = buttonList.get (i);
            }
        }
        
        sliderButton clickedBUTT = (sliderButton) l.getSource ();
        
        int oldNullBUTTX = (Integer) oldNullBUTT.getClientProperty ("column");
        int oldNullBUTTY = (Integer) oldNullBUTT.getClientProperty ("row");
        
        int clickedBUTTX = (Integer) clickedBUTT.getClientProperty ("column");
        int clickedBUTTY = (Integer) clickedBUTT.getClientProperty ("row");
        
        // UPP ELLER NER X, Y SAMMA
        if (clickedBUTTX == oldNullBUTTX + 1 || clickedBUTTX == oldNullBUTTX - 1) {
            if (clickedBUTTY == oldNullBUTTY) {
                switchTheButtons (oldNullBUTT, clickedBUTT);
            }
        }
    
        // UPP ELLER NER Y, X SAMMA
        if (clickedBUTTY == oldNullBUTTY + 1 || clickedBUTTY == oldNullBUTTY - 1) {
            if (clickedBUTTX == oldNullBUTTX) {
                switchTheButtons (oldNullBUTT, clickedBUTT);
            }
        }
    });
}

public void switchTheButtons (sliderButton oldNullBUTT, sliderButton clickedBUTT) {
    oldNullBUTT.putClientProperty ("null", false);
    oldNullBUTT.setText (clickedBUTT.getText ());
    oldNullBUTT.setBackground (null);
    clickedBUTT.putClientProperty ("null", true);
    clickedBUTT.setText ("null");
    clickedBUTT.setBackground (Color.lightGray);
}


}
