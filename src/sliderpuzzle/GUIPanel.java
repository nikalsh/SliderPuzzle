package sliderpuzzle;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author nikalsh
 */
public class GUIPanel extends JPanel  {
static int size;
    private List<RestartGameListener> listeners = new ArrayList<>();
int selectedIndex;
String[] gameSizeSettings = {
        "2	X 2",
        "3	X 3",
        "4	X 4",
        "5	X 5",
        "6	X 6",
        "7	X 7",
        "8	X 8",
        "9	X 9",
        "10	X 10",
        "11	X 11",
        "12	X 12"
};
JComboBox<String> listOfGameSizes = new JComboBox<> (gameSizeSettings);

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
        add (listOfGameSizes );
        add(quit);

        newGame.addActionListener(l -> {

            
           GUIPanel.size =  Integer.valueOf (listOfGameSizes.getSelectedIndex ()+2);
           
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
//        setBackground(Color.red);

    }
    
    
}
