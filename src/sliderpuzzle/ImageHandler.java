package sliderpuzzle;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author nikalsh
 */
public class ImageHandler {

    BufferedImage img = null;
    URL url = new URL("https://cdn.psychologytoday.com/sites/default/files/styles/article-inline-half/public/field_blog_entry_images/2018-02/vicious_dog_0.png?itok=nsghKOHs");

    ImageHandler() throws MalformedURLException {

    }

    public void setURL(String url) throws MalformedURLException {

        this.url = new URL(url);

    }

    public void load() {

        try {
            img = ImageIO.read(url);
            img = scaleToWindow(img);

        } catch (IOException ex) {
            System.out.println("error " + ex);
        }
    }

    public BufferedImage scaleToWindow(Image src/*, int width, int height*/) {
//        double widthScale = width / src.getWidth(null);
//        double heightScale = height / src.getHeight(null);
        AffineTransform tx = new AffineTransform();
        tx.scale(1.5, 0.5);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage re = null;
        re = op.filter((BufferedImage) src, null);

        return re;
    }
}
