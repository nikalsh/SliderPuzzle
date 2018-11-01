/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class SliderPuzzle implements GameStateListener {

    private gameBoard game;
    private GUIPanel gui;
    private gamePanel panel;
    private statPanel stats;
    private winScreen win;
    private JLayeredPane lp;

    SliderPuzzle() throws MalformedURLException {

        game = new gameBoard();

        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        gui = new GUIPanel();
        panel = new gamePanel(3);
        stats = new statPanel();
        win = new winScreen();

        lp = new JLayeredPane();

        lp.setPreferredSize(new Dimension(500, 500));

        lp.add(panel, new Integer(0));

        lp.add(win, new Integer(1));

        game.add(lp);

        game.add(stats);

        game.add(gui);
        

        addListeners();
    }

    public gameBoard getGame() {
        return this.game;
    }

   @Override
    public void changeToWinState() {
        win.setVisible(true);
        win.enableInputMethods(true);
    }

    @Override
    public void changeToPlayState() {
        win.setVisible(false);
        win.setEnabled(true);
    }

    private void addListeners() {
        game.addKBControllerListener(panel);

        game.addRGListener(panel);

        game.addRGListener(stats);

        panel.addGameStateListener(this);
        panel.addGameStateListener(stats);
        
        panel.addPaneLListener(stats);

        gui.addRGListeners(panel);

        gui.addRGListeners(stats);
    }

    public static void main(String[] args) throws MalformedURLException, IOException {

        SliderPuzzle sp = new SliderPuzzle();
        gameBoard game = sp.getGame();

//        panel.disableButtons();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                game.pack();
                game.setLocationRelativeTo(null);

                game.setVisible(true);
                game.setAlwaysOnTop(true);
                game.setResizable(true);

            }

        });

    }

    

}
