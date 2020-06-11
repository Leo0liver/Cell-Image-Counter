import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;

public class AutoContrast{


    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("invalid input");
            System.exit(0);
        }
        process(args[0]);
    }
    public static void process(String file){
        try {
            System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
            Mat source = Imgcodecs.imread(file,
                    Imgcodecs.IMREAD_GRAYSCALE);
            Mat destination = new Mat(source.rows(),source.cols(),source.type());

            Imgproc.equalizeHist(source, destination);
            Imgcodecs.imwrite("output.JPG", destination);

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}