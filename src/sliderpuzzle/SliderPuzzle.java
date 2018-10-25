/*
 * Javautveckling 2018
 */
package sliderpuzzle;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;

public class SliderPuzzle {

    public static void main(String[] args) {
        
        @// TODO: 2018-10-25 lalalala 
        @// TODO: 2018-10-25
        
        gameBoard game = new gameBoard();
        game.setLayout(new BoxLayout(game.getContentPane(), BoxLayout.Y_AXIS));
        gamePanel panel = new gamePanel(3);
        GUIPanel gui = new GUIPanel();

        game.add(panel);
        game.add(gui);

        game.pack();
        game.setLocationRelativeTo(null);

        game.setVisible(true);
        game.setAlwaysOnTop(true);

    }
}