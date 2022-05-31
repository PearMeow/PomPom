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
      LoadImageApp frameImage = new LoadImageApp("RU");
      frameImage.setBlank();
      frameImage.reSize(10);
      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);


      JLabel title = new JLabel("Welcome to Narnia");
      title.setBounds(0,0,1280,200);
      f.add(title);


      f.setSize(2000,1000);
      f.setLayout(null);

      f.setVisible(true);

      for (int i = 0; i < (128 * 4); i ++) {
        if (stop.isEnabled() == true) {
          return;
        }
        delay(1);
        frameImage.addPixelsFuzz(16);

        frameImage.repaint();
      }



  }
}
