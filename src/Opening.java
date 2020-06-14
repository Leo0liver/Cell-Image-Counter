import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


class Opening
{
    int width;
    int height;
    static BufferedImage image;
    static BufferedImage image_copy;
    
    public static void main(String [] args)throws IOException
    {
        //checking the input file
         if(args.length!=1)
         {
            System.out.println("invalid input");
            System.exit(0);
         }
         process(args[0]);
    }

    public static void process(String file)throws IOException
    {    File f = new File(file);
         image = ImageIO.read(f);
         image_copy = image;
         //creating a 3x3 kernel with the filter vales
         Kernel kernel = new Kernel(3, 3, new float[] { 0, 1, 0, 1, 0, 1, 0,
            1, 0});
         BufferedImageOp op = new ConvolveOp(kernel);
         image = op.filter(image_copy,null);
        ImageIO.write(image,"JPG",new File("output.JPG"));
    }
   
   
}