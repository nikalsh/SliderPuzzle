/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WinScreen extends JPanel{

    private JPanel innerPanel = new JPanel();
    private Box winBox = Box.createVerticalBox();

    
        private List<RestartGameListener> listeners = new ArrayList<>();


    private JTextField input = new JTextField();
    private JLabel label = new JLabel("win");
    private JButton submit = new JButton("Submit score");
    private OnlineHighscoreHandler scoreHandler;
    private String name = "null";
    private String scoreRegister;
    int moves;
    int seconds;
    String grid;

    
      public void addRGListeners(RestartGameListener toAdd) {
        listeners.add(toAdd);
    }
 

    public WinScreen () {

        try {
            scoreHandler = new OnlineHighscoreHandler ();
        } catch (IOException ex) {
            System.out.println("could not instantiate score handler: " + ex);
        }

        setBounds(100, 100, 300, 300);
        setPreferredSize(new Dimension(250, 250));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(255, 255, 255, 200));

        add(label);
        input.setMaximumSize(new Dimension(Integer.MAX_VALUE, input.getPreferredSize().height));
        add(input);
        add(submit);
        submit.addActionListener(l -> {

            name = input.getText();
if (name.length () <= 10) {
    
    try {
        scoreRegister = String.format ("%s solved %s in %s moves and %s seconds",
                name, grid, moves, seconds);
        
        scoreHandler.postNewHighScore (scoreRegister);
    } catch (IOException ex) {
        System.out.println ("could not post new highscore: " + ex);
    }
    System.out.println ("new game");
    listeners.forEach (RestartGameListener::newGame);
    input.setText ("");
}
        });

        setVisible(false);

    }

    public void setScore(int moves, int seconds) {
        this.moves = moves;
        this.seconds = seconds;
    }

    public void setGridSize(int grid) {
        String temp = Integer.toString(grid);
        this.grid = temp + "x" + temp;
    }

}
