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
        gamePanel panel = new gamePanel(5);
        GUIPanel gui = new GUIPanel();

        statPanel stats = new statPanel();
        game.add(panel);
        game.add(stats);
        game.add(gui);

        game.pack();
        game.setLocationRelativeTo(null);

        game.setVisible(true);
        game.setAlwaysOnTop(true);
        game.setResizable(false);

        
        

      
    }

}
