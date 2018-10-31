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
public class statPanel extends JPanel implements GUIButtonListener, PaneLListener {

    private JLabel timerDisplay = new JLabel("Tid: 00:00");
    private JLabel movesDisplay = new JLabel("Drag: 0");
    private int seconds;
    private int moves;
    private Timer timer;

    public statPanel() {
        setLayout(new GridLayout(2, 0));
        setBackground(Color.yellow);

        add(timerDisplay);
        add(movesDisplay);

        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);

    }

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {

            timerDisplay.setText("Tid: " + seconds);
            seconds++;
        }
    };

    public void resetTimer() {
        this.seconds = 0;
    }

    public void resetMoves() {
        moves = 0;
        movesDisplay.setText("Drag: " + moves);
    }

    public void addMove() {
        moves++;
        movesDisplay.setText("Drag: " + moves);

    }

    @Override
    public void newGame() {
        resetTimer();
        resetMoves();

    }

    @Override
    public void incrementMove() {
        addMove();
    }

}
