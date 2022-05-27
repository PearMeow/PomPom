import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Woo {
  private static void delay( int n )
  {
    try {
      Thread.sleep(n);
    } catch( InterruptedException e ) {
      System.exit(0);
    }
  }
  public static void main(String[] args) {

      JFrame f = new JFrame("Load Image Sample");

      f.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });
      LoadImageApp frameImage = new LoadImageApp("US");
      frameImage.setBlank();
      frameImage.reSize(10);
      

      f.add(frameImage);
      f.pack();
      f.setVisible(true);
      
      for (int i = 0; i < 50000; i ++) {
        delay(4);
        frameImage.addPixelsSeg(1, 10);

        frameImage.repaint();
      }
     


  }
}
