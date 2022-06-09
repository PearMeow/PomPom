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
  static boolean selec = false;

  static JFrame f;
  static JTextField textField;
  static JButton tonPix, tonSeg, ton0, ton1, ton2, ton3;
  static JLabel title, curr;
  static int totalScore = 0;
  static int currentScore = (128 * 64);
  static int pixAdded = 0;

  static String text = "No country yet";
  static Boolean changed = false;

  public static void reset() {
    currentScore = (128 * 64);
  }

  private static void delay( int n ) {
        try {
        Thread.sleep(n);
        }
        catch( InterruptedException e ) {
        System.exit(0);
        }
    }

  public static void flagChange() {
    if (text.equals(currFlag.getName())) {
      curr.setText("Correct!");
    }
    else {
      curr.setText(currFlag.getName());
    }
    currFlag = frameImage.changeFlag(difficulty);
    changed = true;
  }
  public static void loop() {
      while(!selec) {
        delay(1);
      }
        while (true) {
            if (changed) {
              changed = false;
              delay(2000);
            } else {
              if( addType == 0){
                 frameImage.addPixelsFuzz(100);
                 pixAdded +=100;

              }
              if( addType == 1){
                 frameImage.addPixelsSeg(5,5);
              }

              delay(500);
              frameImage.reSize(10);
              frameImage.repaint();
              if (pixAdded < (64 * 128)) {
                  currentScore -= 100;
                  curr.setText("Available Score: " + currentScore / 100 * (difficulty + 1));
              }
              else {
                reset();
                pixAdded = 0;
                flagChange();
              }
            }

        }
  }
  public static void startGame() {
      frameImage.setBackground(new Color(0));

      f = new JFrame("Load Image Sample");
      f.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });


      frameImage.setBounds(200,200,1280,640);
      f.add(frameImage);
      frameImage.setBlank();
          frameImage.reSize(5);

      title = new JLabel("Score: " + totalScore);
      title.setBounds(1200,100,200,100);
      f.add(title);

      curr = new JLabel("Available Score: " + currentScore / 100 * (difficulty + 1));
      curr.setBounds(1500,100,200,100);
      f.add(curr);


      textField = new JTextField(20);
      textField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          text = textField.getText();
          if (text.equals(currFlag.getName())) {


            totalScore += (currentScore / 100) * (difficulty + 1);
            title.setText("Score :" + totalScore);

            reset();
            pixAdded = 0;
            flagChange();
          }
          textField.setText("");
        }
      });
      textField.setBounds(0,200,200,200);

      f.add(textField);




//Buttons

      tonPix = new JButton("Add by Pixels");
      tonPix.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 0;
          selec = true;
        }
      });
      tonPix.setBounds(110,10,100,50);

      f.add(tonPix);

      tonSeg = new JButton("Add by Segments");
      tonSeg.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 1;
            selec = true;

        }
      });
      tonSeg.setBounds(10,10,100,50);

      f.add(tonSeg);



    // difficulty buttons
      ton0 = new JButton("Difficulty Zero");
      ton0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          flagChange();
          difficulty = 0;
          reset();

        }
      });
      ton0.setBounds(0,100,200,100);

      f.add(ton0);



      ton1 = new JButton("Difficulty One");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          flagChange();
          difficulty = 1;
          reset();


        }
      });

      ton1.setBounds(300,100,200,100);

      f.add(ton1);



      ton2 = new JButton("Difficulty Two");
      ton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          flagChange();
          difficulty = 2;
          reset();

        }
      });
      ton2.setBounds(600,100,200,100);

      f.add(ton2);


      ton3 = new JButton("Difficulty Three");
      ton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          flagChange();
          difficulty = 3;
          reset();


        }
      });
      ton3.setBounds(900,100,200,100);

      f.add(ton3);




      f.setSize(2000,1000);


      f.setLayout(null);

      f.setVisible(true);

      currentScore = (128 * 64);
  }
}
