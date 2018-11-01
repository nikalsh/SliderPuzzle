/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class winScreen extends JPanel {

    private JPanel innerPanel = new JPanel();
    private JLabel label = new JLabel();

    public winScreen() {

        setBounds(100, 100, 300, 300);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255,255,255,200));
        JLabel label = new JLabel("win");

        add(label);
        setPreferredSize(new Dimension(250,250));
        setVisible(false);
        enableInputMethods(false);
    }
    
    
    

}
