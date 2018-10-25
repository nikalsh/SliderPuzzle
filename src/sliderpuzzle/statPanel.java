/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class statPanel extends JPanel {

    private JLabel timer = new JLabel("Tid: 00:00");
    private JLabel moves = new JLabel("Drag: 0");

    public statPanel() {
        setLayout(new GridLayout(2, 0));
        setBackground(Color.yellow);

        add(timer);
        add(moves);

    }

}
