import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class Threshold {

    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("invalid input");
            System.exit(0);
        }
        Threshold t = new Threshold();
        t.process(args[0]);
    }

    public void process(String file)throws IOException {
        int threshold = 80;
        BufferedImage image;
        File f = new File(file);
        image = ImageIO.read(f);
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        result.getGraphics().drawImage(image, 0, 0, null);
        WritableRaster raster = result.getRaster();
        int[] pixels = new int[image.getWidth()];
        for (int y = 0; y < image.getHeight(); y++) {
            raster.getPixels(0, y, image.getWidth(), 1, pixels);
            for (int i = 0; i < pixels.length; i++) {
                if (pixels[i] < threshold) pixels[i] = 255;
                else pixels[i] = 0;
            }
            raster.setPixels(0, y, image.getWidth(), 1, pixels);
        }
        ImageIO.write(result, "JPG", new File("output.JPG"));
    }
}
