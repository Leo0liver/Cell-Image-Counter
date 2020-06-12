import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;

public class Threshold {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("invalid input");
            System.exit(0);
        }
        process(args[0], 80);
    }

    public static void process(String file, int threshold)throws IOException {
        if(threshold!=0) {
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
        else
        {
            Mat src = Imgcodecs.imread(file);
            Mat d = new Mat();

            Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(src, d, 127, 255,Imgproc.THRESH_BINARY);
            Imgcodecs.imwrite("output.JPG",d);
        }

    }
}
