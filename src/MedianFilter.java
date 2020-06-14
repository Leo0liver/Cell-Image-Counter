import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;


class MedianFilter{

    public static void main(String [] args)throws IOException
    {
        //check input file
         if(args.length!=1)
         {
            System.out.println("invalid input");
            System.exit(0);
         }
         process(args[0]);
    }

    public static void process(String file)throws IOException
    {

        Color[] pixel=new Color[9];
        //arrays to store the RBG values of the current pixel and its neighbours
        int[] R=new int[9];
        int[] B=new int[9];
        int[] G=new int[9];
        //read the file to be denoised
        BufferedImage img=ImageIO.read(new File(file));
        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
                //get all the interested pixel values
               pixel[0]=new Color(img.getRGB(i-1,j-1));
               pixel[1]=new Color(img.getRGB(i-1,j));
               pixel[2]=new Color(img.getRGB(i-1,j+1));
               pixel[3]=new Color(img.getRGB(i,j+1));
               pixel[4]=new Color(img.getRGB(i+1,j+1));
               pixel[5]=new Color(img.getRGB(i+1,j));
               pixel[6]=new Color(img.getRGB(i+1,j-1));
               pixel[7]=new Color(img.getRGB(i,j-1));
               pixel[8]=new Color(img.getRGB(i,j));
               //splitting the pixel values
               for(int k=0;k<9;k++){
                   R[k]=pixel[k].getRed();
                   B[k]=pixel[k].getBlue();
                   G[k]=pixel[k].getGreen();
               }
               //sorting the RBG array and choosing the median value
               Arrays.sort(R);
               Arrays.sort(G);
               Arrays.sort(B);
               img.setRGB(i,j,new Color(R[4],B[4],G[4]).getRGB());
            }
        //outputting the image file
        ImageIO.write(img, "JPG", new File("output.JPG"));
   }
   
}