import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {


    BufferedImage img;
    BufferedImage img2;
    BufferedImage resize;
    int _size;
    String image;
    int eRows;
    ArrayDeque<Integer>[] user;
    String text;
    FlagList sourcery;
    public void paint(Graphics g) {
        g.drawImage(resize, 0, 0, null);
    }

    public LoadImageApp(String n) {
      image = "PNG-128/" + n + "-128.png";
      text = n;
       try {
           img = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           img2 = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           resize = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       _size = 1;
       eRows = 0;
       user = dubq(img.getWidth(),img.getHeight());
       sourcery = new FlagList();

    }

    public void displayCall() {
      System.out.println(sourcery.toString());
    }
    public String getText() {
      return text;
    }


    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(600,600);
        } else {
           return new Dimension(img.getWidth(null) * _size, img.getHeight(null) * _size);
       }
    }

    public void reSize (int i) {
      int width = img.getWidth();
      int height = img.getHeight();
      _size = i;

      resize = new BufferedImage(width * i , height * i , 1);
      int Bwidth = resize.getWidth();
      int Bheight = resize.getHeight();
      for (int xcord = 0; xcord < (width * i); xcord += i) {
        for (int ycord = 0; ycord < (height * i); ycord += i) {

          for (int count = 0; count < i; count ++) {
            for (int count2 = 0; count2 < i; count2 ++) {

                resize.setRGB(xcord + count, ycord + count2, img.getRGB((xcord / i), (ycord / i)));
            }

          }
        }

      }
    }

    public void transfer () {
      int width = img.getWidth();
      int height = img.getHeight();
      int Bwidth = resize.getWidth();
      int Bheight = resize.getHeight();

      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height  ; ycord ++) {

          for (int count = 0; count < _size; count +=_size) {
            for (int count2 = 0; count2 < _size; count2 +=_size) {

                resize.setRGB(xcord + count, ycord + count2, img.getRGB((xcord / _size), (ycord / _size)));
            }
            }

          }
        }


    }

    public void setBlank() {
      int width = img.getWidth();
      int height = img.getHeight();
      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height; ycord ++) {
          img.setRGB(xcord,ycord,-1);
        }

      }

      user = dubq(img.getWidth(),img.getHeight());
      eRows = 0;
      transfer();

    }

    public void addPixelsFuzz(int repeat) {
      int width = img.getWidth();
      int height = img.getHeight();
      int i = 0;
      while (eRows < img.getWidth() && i < repeat) {
        int randRow = (int)(Math.random() * width);
        int x = randRow;
        int y = 0;
        if (user[randRow] == null){

        }
        else if (user[randRow].isEmpty()) {
          eRows++;
          user[randRow] = null;
        }
        else {
          y=user[randRow].remove();
          img.setRGB(x,y, img2.getRGB(x, y));
          i++;
        }
      }
      transfer();
    }


     public void addPixelsSeg(int repeat, int seg) {

        int width = img.getWidth() ;
        int height = img.getHeight();
        int smallW = width / seg;
        int smallH = height / seg;
        int i = 0;
        ArrayDeque<Integer>[] AD = dubq(smallW, smallH);
        while (eRows < smallW && i < repeat) {
        int randRow = (int)(Math.random() * smallW);
        int x = randRow * seg;
        int y = 0;
        if (AD[randRow] == null){

        }
        else if (AD[randRow].isEmpty()) {
          eRows++;
          AD[randRow] = null;
        }
        else {
          y=AD[randRow].remove() * seg;
          for (int count = 0; count < seg; count++) {
            for (int count2 = 0; count2 < seg; count2++) {
              img.setRGB(x + count,y+count2, img2.getRGB(x+count,y+count2));
            }
            
          }
          i++;
        }
      }
      transfer();
      //  for (int reps = 0; reps < repeat; reps++) {
      //    int w = (int)(Math.random() * (width - seg) );
      //    int h = (int)(Math.random() * (height - seg));
      //    for (int ww = 0; ww < seg; ww ++) {
      //      for (int hh = 0; hh < seg; hh ++) {
      //        img.setRGB(w+ww,h+hh, img2.getRGB(w+ww, h+hh));
      //    }
      //    }

      //  }
      //  transfer();

     }

    public ArrayDeque<Integer>[] dubq(int x, int y) {
      ArrayList<Integer> xx = new ArrayList<Integer>();
      ArrayList<Integer> yy = new ArrayList<Integer>();
      ArrayDeque<Integer>[] retVal = new ArrayDeque[x];
      for(int Y = 0; Y < y; Y++) {
        yy.add(Y);
      }
      for(int X = 0; X < x; X++) {
        xx.add(X);
      }

      for (int w = 0; w < x ; w ++) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int Y = 0; Y < y; Y++) {
          temp.add(Y);
        }

        for (int ww = 0; (!(temp.isEmpty())); ww++) {
          int randy = (int)(Math.random() * temp.size());
          int val = temp.remove(randy);
          if (retVal[w] == null) {
            retVal[w]=new ArrayDeque<Integer>();
          }

          retVal[w].add(val);
        }

      }
      return retVal;
    }

    

    public Flag changeFlag(int diffi) {


    //  int rando = (int)(Math.random() * source.getCash(diffi).length);
       
      Flag newC = sourcery.getCash(diffi); //[rando]

      text = newC.flagCode();
      image = "PNG-128/" + text + "-128.png";
       try {
           img = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           img2 = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           resize = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
        setBlank();
       return newC;
    }

}
