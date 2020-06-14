import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class imageProcessor {
    //global variable to refer to the output image
   static BufferedImage images = new BufferedImage(1000,1000,BufferedImage.TYPE_BYTE_GRAY);
    public static void main(String[] args) {


        try {
            opimg(1);
            AutoContrast.process(args[0]);
            Sharpen.process("output.JPG");
            opimg(2);
            MedianFilter.process("output.JPG");
            GaussianFilter.process("output.JPG", 8);
            opimg(3);
            Threshold.process("output.JPG", 195);
            MedianFilter.process("output.JPG");
            opimg(4);
            Opener.process("output.JPG");
            Threshold.process("output.JPG", 150);
            opimg(5);
            Opener.process("output.JPG");
            Threshold.process("output.JPG", 150);
            Threshold.process("output.jpg",0);
            opimg(6);
        }
        catch (Exception e){
            System.err.println(e);
        }
    }

    //method to output intermediate output images for the GUI
    public static void opimg(int i)throws IOException
    {
        images = ImageIO.read(new File("output.JPG"));
        ImageIO.write(images,"jpg",new File("output"+i+".jpg"));
    }
}
