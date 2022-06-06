import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Game {
  static Flag currFlag = new Flag(0,"United States", "US");
  static LoadImageApp frameImage = new LoadImageApp(currFlag.flagCode());
  static int difficulty = 0;
  private static void delay( int n ) {
        try {
        Thread.sleep(n);
        }
        catch( InterruptedException e ) {
        System.exit(0);
        }
    }
  public void loop() {
        frameImage.changeFlag(0);
        while (true) {
            delay(300);
            frameImage.addPixelsFuzz(200);
            System.out.println("painted" + ", " + frameImage.getText());
            delay(300);
            frameImage.reSize(3);
            System.out.println("resized");
            delay(300);
            frameImage.repaint();
            System.out.println("repaint");
        }
  }
  public static void startGame() {

      JFrame f = new JFrame("Load Image Sample");

      f.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });

      frameImage.displayCall();
      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);
      frameImage.setBlank();
          frameImage.reSize(2);

      // JLabel title = new JLabel("Welcome to Narnia");
      // title.setBounds(0,0,200,100);
      // f.add(title);


      JTextField textField = new JTextField(20);
      textField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          String text = textField.getText();
          if (text.equals(currFlag.getName())) {
            currFlag = frameImage.changeFlag(difficulty);
          }
        }
      });
      textField.setBounds(0,200,200,200);
      f.add(textField);

      JButton ton1 = new JButton("Difficulty One");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Flag NewC = frameImage.changeFlag(1);
           difficulty = 1;
        }
      });
      ton1.setMnemonic(KeyEvent.VK_E);
      ton1.setBounds(0,100,200,100);
      f.add(ton1);


      JButton ton2 = new JButton("Difficulty Two");
      ton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Flag NewC = frameImage.changeFlag(2);
          difficulty = 2;

        }
      });
      ton2.setMnemonic(KeyEvent.VK_W);
      ton2.setBounds(300,100,200,100);
      f.add(ton2);


      JButton ton3 = new JButton("Difficulty Three");
      ton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          Flag NewC = frameImage.changeFlag(3);
          difficulty = 3;

        }
      });
      ton3.setMnemonic(KeyEvent.VK_Q);
      ton3.setBounds(600,100,200,100);
      f.add(ton3);




      f.setSize(2000,1000);
      f.setLayout(null);

      f.setVisible(true);

  }
}
