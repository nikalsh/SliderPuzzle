/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class SliderPuzzle {

    public static void main(String[] args) throws MalformedURLException, IOException {

        gameBoard game = new gameBoard();
        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        GUIPanel gui = new GUIPanel();

        game.add(new gamePanel(4));
        statPanel stats = new statPanel();
        game.add(stats);
        game.add(gui);

        game.pack();
        game.setLocationRelativeTo(null);

        game.setVisible(true);
        game.setAlwaysOnTop(true);
        game.setResizable(true);

    }
}
