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

    private class myActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("pressed");
        }

    }

    private ImageIcon icon;
    private myActionListener actionListener = new myActionListener();

    public sliderButton(String s) {
        super(s);

        addActionListener(actionListener);

    }

}
