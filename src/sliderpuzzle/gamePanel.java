package sliderpuzzle;

import com.sun.imageio.plugins.common.I18N;
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

                sliderButton btn = new sliderButton((k == this.gridSize ? "" : Integer.toString(k)), j, i, k);
                btnList[i][j] = btn;
                add(btn);

                btn.addActionListener(l -> {
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

                                if (diffY == 1 && diffX == 0 || diffX == 1 && diffY == 0) { //Sätt diffX/Y > 1 för korrekt logik, för att flytta fler krävs 
                                                                                            // diffX/Y >= 1 och fungerade algoritm i swap metoden 
                                    swap(A, btnList[yy][xx]);
                                    break OUTER;
                                }

                            }
                        }
                    }

                        System.out.println("");
                    for (int yy = 0; yy < btnList.length; yy++) {
                        for (int xx = 0; xx < btnList.length; xx++) {
                            System.out.print(btnList[yy][xx].getText().equals(Integer.toString(btnList[yy][xx].pos())) + " ");
                        }
                        System.out.println("");
                    }

//                    System.out.println(btnList[btnList.length - 1][btnList.length - 1].pos());
                });

            }

        }

        setPreferredSize(new Dimension(500, 500));

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
//        A.setText("");
        B.setText(A.getText());
        A.setText("");
    }

//    public boolean tileIsMoveable(){
//        
//    }
}
