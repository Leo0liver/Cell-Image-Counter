import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


class sharpen
{
    int width;
    int height;
    BufferedImage image;
    BufferedImage image_copy;
    
    public static void main(String [] args)throws IOException
    {
         if(args.length!=1)
         {
            System.out.println("invalid input");
            System.exit(0);
         } 
         sharpen s = new sharpen();
         s.process(args[0]);
    }

    public void process(String file)throws IOException
    {    File f = new File(file);
         image = ImageIO.read(f);
        
         
         image_copy = image;
        
         Kernel kernel = new Kernel(3, 3, new float[] { -1, -1, -1, -1, 9, -1, -1,
            -1, -1});
         BufferedImageOp op = new ConvolveOp(kernel);
         image = op.filter(image_copy,null);

         
      
        ImageIO.write(image,"JPG",new File("sharp.JPG"));
    }
   
   
}