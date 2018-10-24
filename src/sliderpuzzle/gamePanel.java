package sliderpuzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class gamePanel extends JPanel {

    private JLabel label;
    private int gridSize;

    public gamePanel(int size) {
        this.gridSize = size * size;

        for (int i = 0; i < gridSize; i++) {
            this.add(new sliderButton(Integer.toString(i)));
        }

        setLayout(new GridLayout(size, size));
        setPreferredSize(new Dimension(500, 500));

    }

}
