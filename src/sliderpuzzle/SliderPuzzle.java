/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SliderPuzzle {

    public static void main(String[] args) throws MalformedURLException, IOException {

        gameStatePane lp = new gameStatePane();
       
        
        gameBoard game = new gameBoard();
        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        GUIPanel gui = new GUIPanel();
        gamePanel panel = new gamePanel(2);
        statPanel stats = new statPanel();

        
        
        
        
        game.addListener(panel);
        game.addRGListener(panel);
        game.addRGListener(stats);

        panel.addListener(stats);
        gui.addListener(panel);
        gui.addListener(stats);
        
        
//        lp.addGamePanel(panel, 0);

        game.add(panel);
        

//        game.add(panel);
//        game.add(lp);

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
