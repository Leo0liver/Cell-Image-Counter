import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class GaussianFilter {
    public static void main(String[] args) throws Exception {
        if(args.length != 1){
            System.out.println("invalid input");
            System.exit(0);
        }
        GaussianFilter b = new GaussianFilter();
        b.process(args[0]);
    }

    public void process(String file)throws IOException{
        BufferedImage image;
        File f = new File(file);
        image = ImageIO.read(f);
        Kernel kernel = makeGaussianKernel(3);
        BufferedImageOp op = new ConvolveOp(kernel);
        image = op.filter(image, null);

        ImageIO.write(image, "JPG", new File("output.JPG"));
    }

    public static Kernel makeGaussianKernel(float radius) {
        int r = (int)Math.ceil(radius);
        int rows = r*2+1;
        float[] matrix = new float[rows];
        float sigma = radius/3;
        float sigma22 = 2*sigma*sigma;
        float sigmaPi2 = (float)(2*Math.PI*sigma);
        float sqrtSigmaPi2 = (float)Math.sqrt(sigmaPi2);
        float radius2 = radius*radius;
        float total = 0;
        int index = 0;
        for (int row = -r; row <= r; row++) {
            float distance = row*row;
            if (distance > radius2)
                matrix[index] = 0;
            else
                matrix[index] = (float)Math.exp(-(distance)/sigma22) / sqrtSigmaPi2;
            total += matrix[index];
            index++;
        }
        for (int i = 0; i < rows; i++)
            matrix[i] /= total;

        return new Kernel(rows, 1, matrix);
    }
}
