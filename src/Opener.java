
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;

public class Opener {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("invalid input");
            System.exit(0);
        }
        process(args[0]);
    }

    public static void process(String file){
        try {
            //Loading the OpenCV core library
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat src = Imgcodecs.imread(file);
            //Creating destination matrix
            Mat dst = new Mat(src.rows(), src.cols(), src.type());
            //Preparing the kernel matrix object
            Mat kernel = Mat.ones(5, 5, CvType.CV_32F);
            //Applying dilate on the Image
            Imgproc.morphologyEx(src, dst, Imgproc.MORPH_OPEN, kernel);
            Image img = HighGui.toBufferedImage(dst);
            BufferedImage result = imageToBufferedImage(img);
            ImageIO.write(result, "JPG", new File("output.JPG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage
                (im.getWidth(null),im.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }
}

