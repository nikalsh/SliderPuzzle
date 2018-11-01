/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class statPanel extends JPanel implements RestartGameListener, PaneLListener, GameStateListener {


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

        startNewTimer();

    }

   private void startNewTimer(){
        timer = new Timer();
        timer.scheduleAtFixedRate(getNewTimer(), 0, 1000);
    }
    
    private TimerTask getNewTimer(){
    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {

            timerDisplay.setText("Tid: " + seconds);
            seconds++;
        }
    };
    return timerTask;
    }

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

    @Override
    public void changeToWinState() {
      timer.cancel();
    }

    @Override
    public void changeToPlayState() {
        startNewTimer();
    }

}
