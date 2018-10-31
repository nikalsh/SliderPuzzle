/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class statPanel extends JPanel implements GUIButtonListener{

    private JLabel timerButton = new JLabel("Tid: 00:00");
    private JLabel moves = new JLabel("Drag: 0");
    private int seconds;
    private Timer timer;

    public statPanel() {
        setLayout(new GridLayout(2, 0));
        setBackground(Color.yellow);

        add(timerButton);
        add(moves);

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

      
    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {

            timerButton.setText("Tid: " + seconds);
            seconds++;
        }
    };

    public void resetTimer() {
        this.seconds = 0;
    }

    

    @Override
    public void newGame() {
        resetTimer();
        
    }

}
