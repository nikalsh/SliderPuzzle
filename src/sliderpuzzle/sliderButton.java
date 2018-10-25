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
        super (s);
    
        addActionListener (l -> {
/*
            Object dis = l.getSource();
            int datPos;
            JButton temp;

            int disPos = gameLogic.buttonList.lastIndexOf(this) + 1;
//            System.out.print(
//                    "pressed button: ");
//            System.out.println(
//                    ((sliderButton) dis).getText());
            for (int i = 0; i < gameLogic.buttonList.size(); i++) {
                temp = gameLogic.buttonList.get(i);
                datPos = gameLogic.buttonList.indexOf(temp ) +1;
                
                if (temp.getText().equals("")) {

                    if (canThisButtonBeMoved(disPos, datPos)){
                    
                    
*/// TODO: 2018-10-26 trying the GridBagLayoutConstraint class for restricting movement
                    for (int i = 0; i < buttonList.size (); i++) {
                        if (buttonList.get (i).getText ().equals ("")) {
                            buttonList.get (i).setText (((JButton) l.getSource ()).getText ());
                            ((JButton) l.getSource ()).setText ("");
                        }
                    }
                    
                    //TODO increment moves by 1
                
                }
    
    
        );
    }
    

    public boolean canThisButtonBeMoved(int to, int from) {
//        System.out.println("emptypos: " + from);
//        System.out.println("dis: " + to);
        
        int res = from-to;
        System.out.println("To: " + to);
        System.out.println("From: " + from);
        
        
        
        System.out.println("abs: " +res);
        
        System.out.println(Math.abs(res) == 1);
        
    return Math.abs(res) == 1;
    }
    
}
