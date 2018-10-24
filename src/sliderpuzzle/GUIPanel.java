package sliderpuzzle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class GUIPanel extends JPanel {

    private JLabel timerDisplayer = new JLabel("Time elapsed: 00:00");
    private JLabel moveDisplayer = new JLabel("Moves: 0");
    private JPanel statRow = new JPanel();

    private JButton newGame = new JButton("Nytt spel");

    GUIPanel() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        add(newGame);

        add(timerDisplayer);
        add(moveDisplayer);
        newGame.setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.red);

        newGame.addActionListener(l -> {
            System.out.println("pressed nytt game");
        });
    }

}
