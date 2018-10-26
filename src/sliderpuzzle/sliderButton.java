package sliderpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;

/**
 *
 * @author nikalsh
 *
 */
public class sliderButton extends JButton {

    private int pos;
    private int x;
    private int y;
    
    public sliderButton(String s, int x, int y, int pos) {
        super(s);
        this.pos = pos;
        this.x = x;
        this.y = y;
        
     

    }
    
    public void setMoveable(){
        
    }
    
    public int x(){
        return this.x;
    }
    
    public int y(){
        return this.y;
    }

}
