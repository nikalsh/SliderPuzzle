package sliderpuzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author nikalsh
 * @author johanone
 */
public class gamePanel extends JPanel {

    private JLabel label;
    private int gridSize;
    private sliderButton[][] btnList;

    public gamePanel(int size) {
        btnList = new sliderButton[size][size];

        this.gridSize = size * size;

//        gameLogic logic = new gameLogic(size);
        setLayout(new GridLayout(size, size));
        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                k++;

                sliderButton btn = new sliderButton((k == this.gridSize ? "" : Integer.toString(k)), i, j, k);
                btnList[i][j] = btn;
                add(btn);

                btn.addActionListener(l -> {
                    sliderButton A = ((sliderButton) l.getSource());
                    int y = A.x();
                    int x = A.y();
                    int diffY = 0;
                    int diffX = 0;
                    int diff;
                    int b = 0;

                    try {
                        OUTER: for (int yy = 0; yy < btnList.length; yy++) {
                            for (int xx = 0; xx < btnList.length; xx++) {

                                System.out.print(btnList[yy][xx].getText() + " ");
                                if (btnList[yy][xx].getText().equals("")) {

                                    diffY = Math.abs(yy - y);
                                    diffX = Math.abs(xx - x);

                                    if (diffY == 1 && diffX == 0) {
                                        
                                        btnList[yy][xx].setText(A.getText());
                                        A.setText("");
                                        break OUTER;
                                        
                                        
                                    }
                                    
                                      if (diffX == 1 && diffY == 0) {
                                        
                                        btnList[yy][xx].setText(A.getText());
                                        A.setText("");
                                        break OUTER;
                                        
                                        
                                    }

                                    System.out.println("diffy: " + diffY + " " + "diffx: " + diffX);

                                }
                            }

                            System.out.println("");

                        }

                        System.out.println(btnList[y][x - 1].getText());

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("touching edge");
                    }

                });

            }

        }

        setPreferredSize(new Dimension(500, 500));

    }

//    public boolean tileIsMoveable(){
//        
//    }
}
