package sliderpuzzle;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class gamePanel extends JPanel {

    private int size;
    private JLabel label;

    public gamePanel(int size) {
        this.size = size;

        for (int i = 0; i < size; i++) {
            this.add(new sliderButton(Integer.toString(i)));
        }

        setLayout(new GridLayout(3, 3));

    }

}
