package sliderpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

/**
 *
 * @author nikalsh
 */
public class sliderButton extends JButton {

    private ImageIcon icon;

    public sliderButton(String s) {
        super(s);

        addActionListener(l -> {
            System.out.println("pressed");
            //TODO:
            //canButtonBeMovedOrNot();
        });

    }

}
