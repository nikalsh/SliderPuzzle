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
    
    private JPanel statRow = new JPanel();

    private JButton newGame = new JButton("Nytt spel");
    private JButton quit = new JButton("Avsluta");
    private JButton move = new JButton("Flytta");
    private JButton gridSize = new JButton("Grid size");

    GUIPanel() {

        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        add(newGame);
        add(move);

        add(quit);
        add(gridSize);

        newGame.addActionListener(l -> {

            System.out.println("new game");
        });

        quit.addActionListener(l -> {

            System.out.println("bye");
            System.exit(0);
        });

        move.addActionListener(l -> {
            System.out.println("make a move");
            //TODO implement move logic
        });
        
        gridSize.addActionListener(l -> {
            int size = 8;
            System.out.println("chooses grid size");
            new SliderPuzzle ().redrawWithNewSize (size);
        });

//        add(timerDisplayer);
//        add(moveDisplayer);
        newGame.setAlignmentX(LEFT_ALIGNMENT);
        setBackground(Color.red);
        
    }
}
