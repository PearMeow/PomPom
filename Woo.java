import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Woo {
  static int count = 0;
  static string[] = {"AD", "AE", "AF", "AG", "AI", "AL", "AM", "AO", "AQ","AR","AS","AT","AU","AW","AX","AZ","BA","BB","BD","BE","BF","BG","BH","BI","BJ","BL","BM","BN","BO","BQ","BR","BS","BT","BV","BW","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",}
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
      
      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);
      frameImage.setBlank();
          frameImage.reSize(2);

      JLabel title = new JLabel("Welcome to Narnia");
      title.setBounds(0,0,1280,200);
      f.add(title);

      JButton ton1 = new JButton("Edit");
      
      ton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          frameImage.setBlank();
          frameImage.reSize(2);
          count = 0;
        }
      });
      
      ton1.setMnemonic(KeyEvent.VK_E);
      ton1.setBounds(0,100,1280,100);
      f.add(ton1);

      f.setSize(2000,1000);
      f.setLayout(null);

      f.setVisible(true);
      
      while (count < 10) {
            delay(1);
            frameImage.addPixelsFuzz(16);
            count++;
            frameImage.repaint();
        }
        
      



  }
}
