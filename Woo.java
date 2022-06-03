import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Woo {
  static String text;
  static int count = 0;
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

      LoadImageApp frameImage = new LoadImageApp(2);
      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);
      frameImage.setBlank();
          frameImage.reSize(2);

      JLabel title = new JLabel("Welcome to Narnia");
      title.setBounds(0,0,200,100);
      f.add(title);



      JTextField textField = new JTextField(20);
      textField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          String text = textField.getText();
          if (text.equals(frameImage.getText())) {
            frameImage.changeFlag();
          }
        }
      });
      textField.setBounds(200,0,200,200);
      f.add(textField);

      JButton ton1 = new JButton("Edit");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          frameImage.changeFlag();
        }
      });
      ton1.setMnemonic(KeyEvent.VK_E);
      ton1.setBounds(0,100,200,100);
      f.add(ton1);

      f.setSize(2000,1000);
      f.setLayout(null);

      f.setVisible(true);

      while (true) {
          delay(300);
          frameImage.addPixelsFuzz(20);
          System.out.println("painted" + ", " + frameImage.getText());
          delay(300);
          frameImage.reSize(3);
          System.out.println("resized");
          delay(300);
          frameImage.repaint();
          System.out.println("repaint");


        }





  }
}
