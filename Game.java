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
  static JButton tonPix, tonSeg, ton0, ton1, ton2, ton3, stop;
  static JLabel title, curr, open, ask;
  static int totalScore = 0;
  static int currentScore = (128 * 64);
  static int pixAdded = 0;

  static String text = "No country yet";
  static Boolean changed = false;
  static Boolean yup = false;
  static Font ser = new Font("Serif", Font.PLAIN, 50);
  static Font ser2 = new Font("Serif", Font.PLAIN, 75);


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

        while (yup) {
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
  public static void makeItems() {
      frameImage.setForeground(Color.black);
      currentScore = (128 * 64);
      f = new JFrame("Load Image Sample");
      f.addWindowListener(new WindowAdapter(){
              public void windowClosing(WindowEvent e) {
                  System.exit(0);
              }
          });
      f.setSize(1480,1040);
      f.setLayout(null);
      f.setVisible(true);

      frameImage.setBounds(0,200,1280,640);

      frameImage.setBlank();
          frameImage.reSize(5);

      open = new JLabel("Welcome to the Challenge", SwingConstants.CENTER);
      open.setFont(ser2);
      open.setBounds(0,0,1480,220);

      ask = new JLabel("Choose Your Skill Level", SwingConstants.CENTER);
      ask.setFont(ser);
      ask.setBounds(0,220,1480,220);

      title = new JLabel("Score: " + totalScore, SwingConstants.CENTER);
      title.setFont(ser);
      title.setBounds(0,0,640,200);


      curr = new JLabel("Available Score: " + currentScore / 100 * (difficulty + 1), SwingConstants.CENTER);
      curr.setFont(ser);
      curr.setForeground(Color.red);
      curr.setBounds(640,0,640,200);



      textField = new JTextField(20);
      textField.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          text = textField.getText();
          if (text.equals(currFlag.getName())) {


            totalScore += (currentScore / 100) * (difficulty + 1);
            title.setText("Score: " + totalScore);

            reset();
            pixAdded = 0;
            flagChange();
          }
          textField.setText("");
        }
      });
      textField.setFont(ser);
      textField.setBounds(0,840,1280,200);






//Buttons

      tonPix = new JButton("Add by Pixels");
      tonPix.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 0;
          selec = true;
        }
      });
      tonPix.setBounds(110,10,100,50);



      tonSeg = new JButton("Add by Segments");
      tonSeg.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           addType = 1;
            selec = true;

        }
      });
      tonSeg.setBounds(10,10,100,50);





    // difficulty buttons
      ton0 = new JButton("Beginner");
      ton0.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          f.getContentPane().remove(open);
          f.getContentPane().remove(ask);
          f.getContentPane().remove(ton0);
          f.getContentPane().remove(ton1);
          f.getContentPane().remove(ton2);
          f.getContentPane().remove(ton3);
          f.revalidate();
          f.repaint();
          addType = 0;
          selec = true;
          f.add(stop);
          f.add(textField);
          f.add(frameImage);
          f.add(title);
          f.add(curr);

          flagChange();
          difficulty = 0;
          reset();

        }
      });
      ton0.setFont(ser);
      ton0.setBounds(0,440,1480,150);




      ton1 = new JButton("5th Grader");
      ton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          f.getContentPane().remove(open);
          f.getContentPane().remove(ask);
          f.getContentPane().remove(ton0);
          f.getContentPane().remove(ton1);
          f.getContentPane().remove(ton2);
          f.getContentPane().remove(ton3);
          f.revalidate();
          f.repaint();
          addType = 0;
          selec = true;
          f.add(stop);
          f.add(textField);
          f.add(frameImage);
          f.add(title);
          f.add(curr);

          flagChange();
          difficulty = 1;
          reset();


        }
      });
      ton1.setFont(ser);
      ton1.setBounds(0,590,1480,150);




      ton2 = new JButton("PhD Candidate");
      ton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          f.getContentPane().remove(open);
          f.getContentPane().remove(ask);
          f.getContentPane().remove(ton0);
          f.getContentPane().remove(ton1);
          f.getContentPane().remove(ton2);
          f.getContentPane().remove(ton3);
          f.revalidate();
          f.repaint();
          addType = 0;
          selec = true;
          f.add(stop);
          f.add(textField);
          f.add(frameImage);
          f.add(title);
          f.add(curr);

          flagChange();
          difficulty = 2;
          reset();

        }
      });
      ton2.setFont(ser);
      ton2.setBounds(0,740,1480,150);



      ton3 = new JButton("The Guy Who\nInvented Chocolate");
      ton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          f.getContentPane().remove(open);
          f.getContentPane().remove(ask);
          f.getContentPane().remove(ton0);
          f.getContentPane().remove(ton1);
          f.getContentPane().remove(ton2);
          f.getContentPane().remove(ton3);
          f.revalidate();
          f.repaint();
          addType = 0;
          selec = true;
          f.add(stop);
          f.add(textField);
          f.add(frameImage);
          f.add(title);
          f.add(curr);

          flagChange();
          difficulty = 3;
          reset();


        }
      });
      ton3.setFont(ser);
      ton3.setBounds(0,890,1480,150);

      stop = new JButton("Stop");
      stop.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          f.getContentPane().remove(textField);
          f.getContentPane().remove(frameImage);
          f.getContentPane().remove(title);
          f.getContentPane().remove(curr);
          f.getContentPane().remove(stop);
          f.getContentPane().remove(open);
          f.getContentPane().remove(ask);
          f.getContentPane().remove(ton0);
          f.getContentPane().remove(ton1);
          f.getContentPane().remove(ton2);
          f.getContentPane().remove(ton3);
          f.revalidate();
          f.repaint();

          yup = false;
          delay(1000);
          curr.setBounds(0,0,1480,1040);
          curr.setText("Score: " + totalScore);
          f.add(curr);

        }
      });
      stop.setFont(ser);
      stop.setBounds(1280,0,200,1040);
  }



  public static void openSeq() {

    f.getContentPane().remove(textField);
    f.getContentPane().remove(frameImage);
    f.getContentPane().remove(title);
    f.getContentPane().remove(curr);
    f.getContentPane().remove(stop);
    f.revalidate();
    f.repaint();
    f.add(open);
    f.add(ask);
    f.add(ton0);
    f.add(ton1);
    f.add(ton2);
    f.add(ton3);
    selec = false;
    f.setSize(1480,1040);
    f.setLayout(null);

    f.setVisible(true);
    yup = true;
    loop();
  }
}
