import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class driver {
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
      LoadImageApp frameImage = new LoadImageApp();
      frameImage.setBlank();
      frameImage.addPixels(2000);
      f.add(frameImage);
      f.pack();
      f.setVisible(true);

      delay(3000);
      f.addNotify();
      frameImage.addPixels(80000);
      f.add(frameImage);
      f.pack();
      f.setVisible(true);

  }
}
