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
  static int addType = 2;

  static JFrame f;
  static JTextField textField;
  static JButton tonPix, tonSeg, ton0, ton1, ton2, ton3;



  private static void delay( int n ) {
        try {
        Thread.sleep(n);
        }
        catch( InterruptedException e ) {
        System.exit(0);
        }
    }
  public static void loop() {

        while (true) {
            delay(400);
            if( addType == 0){
               frameImage.addPixelsFuzz(100);
            }
            if( addType == 1){
               frameImage.addPixelsSeg(5,5);
            }

            delay(500);
            frameImage.reSize(10);
            frameImage.repaint();

        }
  }
  public static void startGame() {
      f = new JFrame("Load Image Sample");

      f.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });

      frameImage.displayCall();
      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);
      frameImage.setBlank();
          frameImage.reSize(5);

      // JLabel title = new JLabel("Welcome to Narnia");
      // title.setBounds(0,0,200,100);
      // f.add(title);


      textField = new JTextField(20);
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
      textField.setBackground(new Color(0));

      f.add(textField);




//Buttons

      tonPix = new JButton("Add by Pixels");
      tonPix.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 0;

        }
      });
      tonPix.setBounds(110,10,100,50);
      tonPix.setBackground(new Color(0));
      tonPix.setOpaque(true);
      f.add(tonPix);

      tonSeg = new JButton("Add by Segments");
      tonSeg.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 1;


        }
      });
      tonSeg.setBounds(10,10,100,50);
      tonSeg.setBackground(new Color(0));
      tonSeg.setOpaque(true);
      f.add(tonSeg);



    // difficulty buttons
      ton0 = new JButton("Difficulty Zero");
      ton0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          currFlag = frameImage.changeFlag(difficulty);
           difficulty = 0;

        }
      });
      ton0.setBounds(0,100,200,100);
      ton0.setBackground(new Color(0));
      ton0.setOpaque(true);
      f.add(ton0);



      ton1 = new JButton("Difficulty One");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          currFlag = frameImage.changeFlag(difficulty);
           difficulty = 1;

        }
      });

      ton1.setBounds(300,100,200,100);
      ton1.setBackground(new Color(0));
      ton1.setOpaque(true);
      f.add(ton1);



      ton2 = new JButton("Difficulty Two");
      ton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          difficulty = 2;
          currFlag = frameImage.changeFlag(difficulty);

        }
      });
      ton2.setBounds(600,100,200,100);
      ton2.setBackground(new Color(0));
      ton2.setOpaque(true);
      f.add(ton2);


      ton3 = new JButton("Difficulty Three");
      ton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          difficulty = 3;
          currFlag = frameImage.changeFlag(difficulty);


        }
      });
      ton3.setBounds(900,100,200,100);
      ton3.setBackground(new Color(0));
      ton3.setOpaque(true);
      f.add(ton3);




      f.setSize(2000,1000);


      f.setLayout(null);

      f.setVisible(true);


  }
}
