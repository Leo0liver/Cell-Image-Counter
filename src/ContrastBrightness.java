import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class ContrastBrightness {
    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("invalid input");
            System.exit(0);
        }
        process(args[0], 1.2f, 1f);
    }

    public static void process(String file, float contrast, float brightness)throws IOException {
        BufferedImage image;
        File f = new File(file);
        image = ImageIO.read(f);
        RescaleOp rescaleOp = new RescaleOp(contrast, brightness, null);
        image = rescaleOp.filter(image, null);

        ImageIO.write(image, "JPG", new File("output.JPG"));
    }
}
