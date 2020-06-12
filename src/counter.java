import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import javax.imageio.ImageIO;
import javafx.geometry.Point2D;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class counter
{
    static BufferedImage image ;
    static int count=2;
    static int[][] map;
    static int c=0;
    public static void main(String [] args)throws IOException
    {
         if(args.length!=1)
         {
            System.out.println("invalid input");
            System.exit(0);
         }
         process(args[0]);
    }

    public static void process(String file)throws IOException
     {


         File f = new File(file);
          image = ImageIO.read(f);
          map = new int[image.getWidth()][image.getHeight()];
          createMap();
          countCells();
          //pr();
          System.out.println(count-2);
          

    }
    public static void createMap()
    {
          for(int i=0;i<image.getWidth()-1;i++)
          {
               for(int j=0;j<image.getHeight()-1;j++)
               {
                    if(((image.getRGB(i, j) & 0x00FFFFFF) == 0))
                    {
                         map[i][j]= 1;
                         
                    }
                    else
                    {
                         map[i][j]= 0;
                    }
                    System.out.print(map[i][j]);
               }
               System.out.println();
          }
    }
    public static void countCells()
    {
         for(int i=0;i<image.getWidth();i++)
          {
               for(int j=0;j<image.getHeight();j++)
               {
                    if(map[i][j]==1)
                    {
                         FloodFill(i,j);
                            if(c>28)
                              count++; 
                            c=0;
                         

                         
                    }
               }
          }
    }
    public static void pr()
    {
     for(int i=0;i<image.getWidth()-1;i++)
     {
          for(int j=0;j<image.getHeight()-1;j++)
          {
               System.out.print(map[i][j]);
          }
          System.out.println();
     }
    }
    public static void FloodFill(int i,int j)
    {
        // c++;
          // Point2D p = new Point2D(i, j);
          // Stack<Point2D> sc = new Stack<Point2D>();
          // //System.out.println(p.getX()+" "+p.getY());
          // sc.push(p);

          // while (sc.empty()==false) {
          //      p = sc.pop();

          //      if((map[(int)p.getX()][(int)p.getY()]  == 1) && (int)p.getX()>0 && (int)p.getY()>0 && (int)p.getX()<image.getWidth()-1 && (int)p.getY()<image.getHeight()-1 )
          //      {
          //           map[(int)p.getX()][(int)p.getY()]  =0;
          //           sc.push(new Point2D(i+1,j));
          //           sc.push(new Point2D(i,j+1));
          //           sc.push(new Point2D(i,j-1));
          //           sc.push(new Point2D(i-1,j));
          //      }
          // }

          //recursive method
          
         // System.out.println(c);
          while(  i>=0 && j>=0 && i<=image.getWidth()-1 && j<=image.getHeight()-1 && (map[i][j]  == 1 ) )
          {
               c++;
               map[i][j] =count;
               FloodFill(i+1,j);
               FloodFill(i, j+1);
               FloodFill(i, j-1);
               FloodFill(i-1, j);


          }
          
    }
}