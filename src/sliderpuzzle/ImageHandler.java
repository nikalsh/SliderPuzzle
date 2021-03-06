package sliderpuzzle;

import java.awt.Dimension;
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

    private URL url = null;

    ImageHandler() throws MalformedURLException {

    }

    public void setURL(String url) throws MalformedURLException {

        this.url = new URL(url);

    }

    public URL getUrl() {
        return url;
    }

    public BufferedImage loadFromUrl() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(url);

        } catch (IOException ex) {
            System.out.println("error " + ex);
        }

        return img;
    }

    public BufferedImage resize(BufferedImage img, double width, double height) {
        double widthScale = width / img.getWidth(null);
        double heightScale = height / img.getHeight(null);
        AffineTransform tx = new AffineTransform();

        tx.scale(widthScale, heightScale);

        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage resized = null;
        resized = op.filter((BufferedImage) img, null);

        return resized;

    }

    public BufferedImage[][] slice(int rows, int cols, BufferedImage src) {

        BufferedImage[][] slicedImageArray = new BufferedImage[rows][cols];

        int orgWidth = src.getWidth();
        int orgHeight = src.getHeight();

        System.out.println("Image Dimension: " + orgWidth + "x" + orgHeight);

        //width and height of each piece
        int eWidth = orgWidth / cols;
        int eHeight = orgHeight / rows;

        int x = 0;
        int y = 0;

        for (int i = 0; i < rows; i++) {
            y = 0;
            for (int j = 0; j < cols; j++) {
                try {

                    BufferedImage SubImgage = src.getSubimage(y, x, eWidth, eHeight);
                    slicedImageArray[i][j] = SubImgage;

                    y += eWidth;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            x += eHeight;
        }

        return slicedImageArray;
    }
}
