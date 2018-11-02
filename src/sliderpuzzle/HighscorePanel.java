package sliderpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nikalsh
 */
public class HighscorePanel extends JPanel implements RestartGameListener{

    private onlineHighscoreHandler scoreHandler;
    private List<String> highScoreList = new ArrayList<>();
    private JLabel title = new JLabel("Latest games: ");
    Box scoreBox = Box.createVerticalBox();

    public HighscorePanel() {
        add(title);

        updateScores();

        add(scoreBox);
    }

    public List<String> GetHighScores() {
        List<String> tempHighScoreList = new ArrayList<>();

        try {
            tempHighScoreList = scoreHandler.getHighScoreList();
        } catch (IOException ex) {
            System.out.println("could not retrieve highscores: " + ex);
        }

        return tempHighScoreList;
    }

    public void updateScores() {
        scoreBox.removeAll();


        try {
            scoreHandler = new onlineHighscoreHandler();
        } catch (IOException ex) {
            System.out.println("could not instantiate score handler: " + ex);
        }

//        setBounds(0, 0, 250, 500);
//        setPreferredSize(new Dimension(250, 500));
        setBackground(Color.green);

        highScoreList = GetHighScores();
        //        setLayout(new B);
        for (int i = 0; i < (highScoreList.size() < 25 ? highScoreList.size() : 25); i++) {
            scoreBox.add(new JLabel(highScoreList.get(i)));
        }

    }


    @Override
    public void newGame() {
        
        updateScores();
    }
}
