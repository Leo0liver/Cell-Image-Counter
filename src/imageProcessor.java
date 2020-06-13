import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class imageProcessor {
    public static void main(String[] args) {

        BufferedImage images = new BufferedImage(1000,1000,BufferedImage.TYPE_BYTE_GRAY);
        try {


            images = ImageIO.read(new File(args[0]));
            ImageIO.write(images,"jpg",new File("output1.jpg"));

            AutoContrast.process(args[0]);
            Sharpen.process("output.JPG");

            images = ImageIO.read(new File("output.JPG"));
            ImageIO.write(images,"jpg",new File("output2.jpg"));

            MedianFilter.process("output.JPG");
            GaussianFilter.process("output.JPG", 8);

            images = ImageIO.read(new File("output.JPG"));
            ImageIO.write(images,"jpg",new File("output3.jpg"));

            Threshold.process("output.JPG", 195);
            MedianFilter.process("output.JPG");

            images = ImageIO.read(new File("output.JPG"));
            ImageIO.write(images,"jpg",new File("output4.jpg"));

            Opener.process("output.JPG");
            Threshold.process("output.JPG", 150);

            images = ImageIO.read(new File("output.JPG"));
            ImageIO.write(images,"jpg",new File("output5.jpg"));

            Opener.process("output.JPG");
            Threshold.process("output.JPG", 150);
            Threshold.process("output.jpg",0);

            images = ImageIO.read(new File("output.JPG"));
            ImageIO.write(images,"jpg",new File("output6.jpg"));




        }
        catch (Exception e){
            System.err.println(e);
        }

    }
}
