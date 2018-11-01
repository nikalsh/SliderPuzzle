/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SliderPuzzle {

    public static void main(String[] args) throws MalformedURLException, IOException {

        gameBoard game = new gameBoard();
        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        GUIPanel gui = new GUIPanel();
        gamePanel panel = new gamePanel(3);
        statPanel stats = new statPanel();

        game.addListener(panel);
        game.addRGListener(panel);
        game.addRGListener(stats);

        panel.addListener(stats);
        gui.addListener(panel);
        gui.addListener(stats);

        game.add(panel);

        game.add(stats);
        game.add(gui);

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
