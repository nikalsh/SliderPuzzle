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
public class statPanel extends JPanel {

    private JLabel timerButton = new JLabel("Tid: 00:00");
    private JLabel moves = new JLabel("Drag: 0");
    private Timer timer;
    private int seconds = 0;

    public statPanel() {
        setLayout(new GridLayout(2, 0));
        setBackground(Color.yellow);

        add(timerButton);
        add(moves);
        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            timerButton.setText("Tid: " + seconds);
            seconds++;
        }

    };

}
