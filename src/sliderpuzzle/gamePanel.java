package sliderpuzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
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

    private List<PaneLListener> listeners = new ArrayList<>();

    private ImageHandler imgWiz = new ImageHandler();
    private JLabel label;
    private int gridSize;
    private int size;
    private sliderButton[][] btnList;
    private BufferedImage image = null;
    private BufferedImage[][] buttonImage;

    public gamePanel(int size) throws MalformedURLException {

        this.size = size;
        init();
        randomize();
    }

    public void addListener(PaneLListener toAdd) {
        listeners.add(toAdd);
    }

    
    
    
    @Override
    public void newGame() {

        this.removeAll();
        init();
        randomize();

    }

    public void init() {
        
        try {
            imgWiz.setURL("https://news.nationalgeographic.com/content/dam/news/2016/10/08/drill-monkey-waq/drill-monkey-01.ngsversion.1475926206479.adapt.1900.1.jpg");
        } catch (MalformedURLException ex) {
            System.out.println("failed to read URL");
            
        }
        setPreferredSize(new Dimension(500, 500));
        buttonImage = new BufferedImage[size][size];

        image = imgWiz.loadFromUrl();

        image = imgWiz.scale(image, 500.0, 500.0);

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

                if (k != this.gridSize) {

                    ico = new ImageIcon(buttonImage[i][j]);

                    btn.setIcon(ico);
                }
                btnList[i][j] = btn;
                add(btn);

                this.setButtonActionListener(btn);

            }

        }

        setPreferredSize(new Dimension(500, 500));

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

                        //diffY/X >= 1 to incrementMove several pieces
                        //TODO: implement several piece movement in swap()
                        if (diffY == 1 && diffX == 0 || diffX == 1 && diffY == 0) {
                            swap(A, btnList[yy][xx]);
                            break OUTER;
                        }

                    }
                }
            }

            System.out.println("");

            for (int yy = 0; yy < btnList.length; yy++) {
                for (int xx = 0; xx < btnList[yy].length; xx++) {

                    System.out.print(btnList[yy][xx].getText().equals(Integer.toString(btnList[yy][xx].pos())) + " ");
                }
                System.out.println("");
            }

//                    System.out.println(btnList[btnList.length - 1][btnList.length - 1].pos());
        });

    }

    public void swap(sliderButton A, sliderButton B) {

//        System.out.println(B.y() - A.y());
//        if (B.y() - A.y() == 0) {
//
//            int diff = Math.abs(B.x() - A.x());
//            int i = 0;
//            while (diff > 1) {
//                
//                
//                
//                System.out.println(btnList[A.y()][A.x()+1].getText());
//        
//
//                diff--;
//                i++;
//
//            }
//        }
//        B.setText(A.getText());
        B.setIcon(A.getIcon());
        A.setIcon(null);

//        A.setText("");
        B.setText(A.getText());
        A.setText("");

        listeners.forEach(PaneLListener::incrementMove);
    }

//    public boolean tileIsMoveable(){
//        
//    }
    public int[] getEmptyTile() {
        int[] emptyTile = new int[2];
        for (int yy = 0; yy < btnList.length; yy++) {
            for (int xx = 0; xx < btnList[yy].length; xx++) {
                if (btnList[yy][xx].getText().equals("")) {
                    System.out.println(yy);
                    System.out.println(xx);

                    emptyTile[0] = yy;
                    emptyTile[1] = xx;
                    break;
                }
            }
        }
        return emptyTile;
    }
    
    
    public void randomize(){
       int iterations = gridSize * gridSize;
       String[] dirs = new String[]{"up", "down", "left", "right"};
       Random rand = new Random();
       
        for (int i = 0; i < iterations; i++) {
                   move(dirs[rand.nextInt(4)]);

        }
       
        
       
    }

    @Override
    public void move(String dir) {

        emptyY = getEmptyTile()[0];
        emptyX = getEmptyTile()[1];

        switch (dir.toLowerCase()) {
            case "up":
                newY = getEmptyTile()[0] - 1;
                newX = getEmptyTile()[1];

                break;
            case "down":
                newY = getEmptyTile()[0] + 1;
                newX = getEmptyTile()[1];

                break;
            case "left":
                newY = getEmptyTile()[0];
                newX = getEmptyTile()[1] - 1;

                break;
            case "right":
                newY = getEmptyTile()[0];
                newX = getEmptyTile()[1] + 1;

                break;

        }
        System.out.println("moving");

        try {
            swap(btnList[newY][newX],btnList[emptyY][emptyX]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("no can do");
        }
    }

   
}
