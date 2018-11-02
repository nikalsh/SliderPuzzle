package sliderpuzzle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author nikalsh
 * @author johanone
 */
public class gamePanel extends JPanel implements RestartGameListener, KBControllerListener {

    int emptyX, emptyY, newX, newY;

    private List<PaneLListener> paneLListeners = new ArrayList<>();
    private List<GameStateListener> gameStateListeners = new ArrayList<>();

    private ImageHandler imgWiz = new ImageHandler();
    private JLabel label;
    private int gridSize;
    private int size;
    private BufferedImage image = null;
    private BufferedImage[][] buttonImage;
    private sliderButton[][] btnList;

    String humanDog = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSfkVopwJoEyFhWLXYzgNIiV36-Ry12m6KUyX_5gGRk0ACAIOngTw";
    String monkey = ("https://cdn.vox-cdn.com/thumbor/Or0rhkc1ciDqjrKv73IEXGHtna0=/0x0:666x444/1200x800/filters:focal(273x193:379x299)/cdn.vox-cdn.com/uploads/chorus_image/image/59384673/Macaca_nigra_self-portrait__rotated_and_cropped_.0.jpg");
    String randomImg = ("https://picsum.photos/500/500/?random");

    public int getGridSize(){
        return size;
    }
    
    public gamePanel(int size) throws MalformedURLException {

        this.size = size;
        runPlayState();
        randomize();
        setBounds(0, 0, 500, 500);
        setPreferredSize(new Dimension(500, 500));

    }

    public void disableButtons() {
        for (int i = 0; i < btnList.length; i++) {
            for (int j = 0; j < btnList.length; j++) {
                btnList[i][j].setEnabled(false);
            }
        }
    }

    public void enableButtons() {
        for (int i = 0; i < btnList.length; i++) {
            for (int j = 0; j < btnList.length; j++) {
                btnList[i][j].setEnabled(true);
            }
        }
    }

    public void addPaneLListener(PaneLListener toAdd) {
        paneLListeners.add(toAdd);
    }

    public void addGameStateListener(GameStateListener toAdd) {
        gameStateListeners.add(toAdd);
    }

    public void runGameIsWonState() {

        gameStateListeners.forEach(GameStateListener::changeToWinState);
        disableButtons();

    }

    @Override
    public void newGame() {

        this.removeAll();
        runPlayState();

        randomize();

    }

    public void runPlayState() {
        gameStateListeners.forEach(GameStateListener::changeToPlayState);

        try {
            imgWiz.setURL(monkey);
        } catch (MalformedURLException ex) {
            System.out.println("failed to read URL");

        }
        buttonImage = new BufferedImage[size][size];

        image = imgWiz.loadFromUrl();

        image = imgWiz.resize(image, 500.0, 500.0);

        buttonImage = imgWiz.slice(size, size, image);

        btnList = new sliderButton[size][size];
        ImageIcon ico = null;

        this.gridSize = size * size;

//        gameLogic logic = new gameLogic(size);
        setLayout(new GridLayout(size, size));
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                k++;

                sliderButton btn = new sliderButton((k == this.gridSize ? "" : Integer.toString(k)), j, i, k);

                //slidebuttons
                if (k != this.gridSize) {

                    ico = new ImageIcon(buttonImage[i][j]);
                    btn.setFont(new Font("Arial", Font.PLAIN, 0));
                    btn.setIcon(ico);

                }
                //the empty button
                btnList[i][j] = btn;
                btn.setFont(new Font("Arial", Font.PLAIN, 0));
                add(btn);

                this.setButtonActionListener(btn);

            }

        }

    }

    public void setButtonActionListener(JButton button) {

        button.addActionListener(l -> {
            sliderButton A = ((sliderButton) l.getSource());
            int y = A.y();
            int x = A.x();
            int diffY = 0;
            int diffX = 0;
            int diff;
            int b = 0;

            OUTER:
            for (int yy = 0; yy < btnList.length; yy++) {
                for (int xx = 0; xx < btnList.length; xx++) {

                    if (btnList[yy][xx].getText().equals("")) {

                        diffY = Math.abs(yy - y);
                        diffX = Math.abs(xx - x);

                        //TODO: implement several piece movement in swap()
                        if (diffY == 1 && diffX == 0 || diffX == 1 && diffY == 0) {
                            swap(A, btnList[yy][xx]);
                            break OUTER;
                        }

                    }
                }
            }

            if (gameIsWon()) {

                System.out.println("game is won");
                runGameIsWonState();
            }

//                    System.out.println(btnList[btnList.length - 1][btnList.length - 1].pos());
        });

    }

    public boolean gameIsWon() {
        System.out.println("");
        int k = 0;

        for (int yy = 0; yy < btnList.length; yy++) {
            for (int xx = 0; xx < btnList[yy].length; xx++) {
                k++;
                if (k != this.gridSize) {
                    System.out.print(btnList[yy][xx].getText().equals(Integer.toString(btnList[yy][xx].pos())) + " ");

                    if (!btnList[yy][xx].getText().equals(Integer.toString(btnList[yy][xx].pos()))) {
                        return false;
                    }
                }

            }
            System.out.println("");
        }

        return true;
    }

    public void swap(sliderButton A, sliderButton B) {

        B.setIcon(A.getIcon());
        A.setIcon(null);

        B.setText(A.getText());
        A.setText("");

        paneLListeners.forEach(PaneLListener::incrementMove);
    }

//    public boolean tileIsMoveable(){
//        
//    }
    public int[] getEmptyTile() {
        int[] emptyTile = new int[2];
        for (int yy = 0; yy < btnList.length; yy++) {
            for (int xx = 0; xx < btnList[yy].length; xx++) {
                if (btnList[yy][xx].getText().equals("")) {
//                    System.out.println(yy);
//                    System.out.println(xx);

                    emptyTile[0] = yy;
                    emptyTile[1] = xx;
                    break;
                }
            }
        }
        return emptyTile;
    }

    public void randomize() {

        do {

            int iterations = (gridSize * gridSize * gridSize);
            String[] dirs = new String[]{"up", "down", "left", "right"};
            Random rand = new Random();

            for (int i = 0; i < iterations; i++) {
                move(dirs[rand.nextInt(4)]);

            }

        } while (gameIsWon());

    }

    @Override
    public void move(String dir) {

        emptyY = getEmptyTile()[0];
        emptyX = getEmptyTile()[1];

        switch (dir.toLowerCase()) {
            case "up":
                newY = getEmptyTile()[0] + 1;
                newX = getEmptyTile()[1];

                break;
            case "down":
                newY = getEmptyTile()[0] - 1;
                newX = getEmptyTile()[1];

                break;
            case "left":
                newY = getEmptyTile()[0];
                newX = getEmptyTile()[1] + 1;

                break;
            case "right":
                newY = getEmptyTile()[0];
                newX = getEmptyTile()[1] - 1;

                break;

        }
//        System.out.println("moving");

        try {
            swap(btnList[newY][newX], btnList[emptyY][emptyX]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("no can do");
        }
    }

}
