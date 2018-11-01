package sliderpuzzle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class GUIPanel extends JPanel {

    private List<RestartGameListener> listeners = new ArrayList<>();

    
    
    private JPanel statRow = new JPanel();

    private JButton newGame = new JButton("Nytt spel");
    private JButton quit = new JButton("Avsluta");
    private JButton move = new JButton("Flytta");

    public void addRGListeners(RestartGameListener toAdd) {
        listeners.add(toAdd);
    }

    GUIPanel() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        add(newGame);
        add(move);

        add(quit);

        newGame.addActionListener(l -> {

            System.out.println("new game");
            listeners.forEach(RestartGameListener::newGame);

        });

        quit.addActionListener(l -> {

            System.out.println("bye");
            System.exit(0);
        });

        move.addActionListener(l -> {
            System.out.println("make a move");
            //TODO implement move logic
        });

//        add(timerDisplayer);
//        add(moveDisplayer);
        newGame.setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.red);

    }

}
