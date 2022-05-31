import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Woo {
  static int count = 0;
  static String[] countries = {"AD","AE","AF","AG","AI","AL","AM","AO","AQ","AR","AS","AT","AU","AW","AX","AZ","BA","BB","BD","BE","BF","BG","BH","BI","BJ","BL","BM","BN","BO","BQ","BR","BS","BT","BV","BW","BY","BZ","CA","CA","CC","CD","CF","CG","CH","CI","CK","CL","CM","CN","CO","CR","CU","CV","CW","CX","CY","CZ","DE","DJ","DK","DM","DO","DZ","EC","EE","EG","EH","ER","ES","ET","EU","FI","FJ","FK","FM","FO","FR","GA","GB","GD","GE","GF","GG","GH","GI","GL","GM","GN","GP","GQ","GR","GS","GT","GU","GW","GY","HK","HM","HN","HR","HT","HU","ID","IE","IL","IM","IN","IO","IQ","IR","IS","IT","JE","JM","JO","JP","KE","KG","KH","KI","KM","KN","KP","KR","KW","KY","KZ","LA","LB","LC","LI","LK","LR","LS","LT","LU","LV","LY","MA","MC","MD","ME","MF","MG","MH","MK","ML","MM","MN","MO","MP","MQ","MR","MS","MT","MU","MU","MV","MW","MX","MY","MZ","NA","NC","NE","NF","NG","NI","NL","NO","NP","NR","NU","NZ","OM","PA","PE","PF","PG","PH","PK","PL","PM","PN","PR","PS","PT","PW","PY","QA","RE","RO","RS","RU","RW","SA","SB","SC","SD","SE","SG","SH","SI","SJ","SK","SL","SM","SN","SO","SR","SS","ST","SV","SX","SY","SZ","TC","TD","TF","TG","TH","TJ","TK","TL","TM","TN","TO","TR","TT","TV","TW","TZ","UA","UG","UM","US","UY","UZ","VA","VC","VE","VG","VI","VN","VU","WF","WS","YE","YT","ZA","ZM","ZW"};
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
