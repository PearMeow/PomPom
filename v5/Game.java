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

        while (true) {
            delay(400);
            frameImage.addPixelsFuzz(100);
            System.out.println("painted" + ", " + frameImage.getText());
            delay(400);
            frameImage.reSize(3);
            System.out.println("resized");
            delay(400);
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
          textField.setText("");
        }
      });
      textField.setBounds(0,200,200,200);
      f.add(textField);

      JButton ton0 = new JButton("Difficulty Zero");
      ton0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          currFlag = frameImage.changeFlag(difficulty);
           difficulty = 0;

        }
      });
      ton0.setMnemonic(KeyEvent.VK_T);
      ton0.setBounds(0,100,200,100);
      f.add(ton0);



      JButton ton1 = new JButton("Difficulty One");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          currFlag = frameImage.changeFlag(difficulty);
           difficulty = 1;
           
        }
      });
      ton1.setMnemonic(KeyEvent.VK_E);
      ton1.setBounds(300,100,200,100);
      f.add(ton1);
      


      JButton ton2 = new JButton("Difficulty Two");
      ton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          difficulty = 2;
          currFlag = frameImage.changeFlag(difficulty);

        }
      });
      ton2.setMnemonic(KeyEvent.VK_W);
      ton2.setBounds(600,100,200,100);
      f.add(ton2);


      JButton ton3 = new JButton("Difficulty Three");
      ton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          difficulty = 3;
          currFlag = frameImage.changeFlag(difficulty);


        }
      });
      ton3.setMnemonic(KeyEvent.VK_Q);
      ton3.setBounds(900,100,200,100);
      f.add(ton3);




      f.setSize(2000,1000);
      f.setLayout(null);

      f.setVisible(true);

  }
}
