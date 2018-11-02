/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import com.sun.prism.j2d.J2DPipeline;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class SliderPuzzle implements GameStateListener, submitListener {

    private gameBoard game;
    private GUIPanel gui;
    private gamePanel panel;
    private statPanel stats;
    private winScreen win;
    private JLayeredPane lp;
    private HighscorePanel hiscore;
    Box leftColumn = Box.createVerticalBox();
    Box rightColumn = Box.createVerticalBox();
    Box centered = Box.createHorizontalBox();

    SliderPuzzle() throws MalformedURLException {

        game = new gameBoard();

        hiscore = new HighscorePanel();

//        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
//        game.setBounds(0,0,500,500);
        gui = new GUIPanel();
        panel = new gamePanel(2);
        stats = new statPanel();
        win = new winScreen();

        lp = new JLayeredPane();

        lp.setPreferredSize(new Dimension(500, 500));

        lp.add(panel, new Integer(0));

        lp.add(win, new Integer(1));

        rightColumn.add(hiscore);
        leftColumn.add(lp);
        leftColumn.add(stats);
        leftColumn.add(gui);
        centered.add(leftColumn);
        centered.add(rightColumn);
        game.getContentPane().add(centered, BorderLayout.CENTER);

//        game.add(lp);
//
//        game.add(stats);
//
//        game.add(gui);
        addListeners();
    }

    public gameBoard getGame() {
        return this.game;
    }

    @Override
    public void changeToWinState() {
        win.setVisible(true);
        win.enableInputMethods(true);
        win.setScore(stats.getMoves(), stats.getSeconds());
        win.setGridSize(panel.getGridSize());
    }

    @Override
    public void changeToPlayState() {
        win.setVisible(false);
        win.setEnabled(false); 
        
    }
    @Override
    public void updateScoreAfterSubmit() {
        changeToPlayState();
       stats.newGame();
       
        panel.newGame();
    }

    private void addListeners() {
        game.addKBControllerListener(panel);
        
        panel.addGameStateListener(this);
        panel.addGameStateListener(stats);
        
        panel.addPaneLListener(stats);
        
        game.addRGListener(panel);
        game.addRGListener(stats);
        gui.addRGListeners(panel);
        gui.addRGListeners(stats);
      
        
        win.addRGListeners(panel);
        win.addRGListeners(stats);
        win.addRGListeners(hiscore);
        
    }

    public static void main(String[] args) throws MalformedURLException, IOException {

        SliderPuzzle sp = new SliderPuzzle();
        gameBoard game = sp.getGame();
        game.setUndecorated(true);
//        game.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
//        panel.disableButtons();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                game.pack();
                game.setLocationRelativeTo(null);

                game.setVisible(true);
                game.setAlwaysOnTop(false);
                game.setResizable(false);

            }

        });

    }

    

   
}
