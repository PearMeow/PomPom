/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class demonstrates how to load an Image from an external file
 */
public class LoadImageApp extends Component {

    BufferedImage img;
    BufferedImage img2;
    BufferedImage resize;

    public void paint(Graphics g) {
        g.drawImage(resize, 0, 0, null);
    }

    public LoadImageApp() {
      String image = "PNG-128/WF-128.png";
       try {
           img = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           img2 = ImageIO.read(new File(image));
       } catch (IOException e) {
       }
       try {
           resize = ImageIO.read(new File(image));
       } catch (IOException e) {
       }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(600,600);
        } else {
           return new Dimension(img.getWidth(null) * 10, img.getHeight(null) * 10);
       }
    }

    public String toString() {
      int width = img.getWidth();
      int height = img.getHeight();
      
      
      String retVal = "";
      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height; ycord ++) {
          retVal += ("(" + img.getRGB(xcord,ycord) +  "), ");
        }
        retVal += ("\n");
      }
      return retVal;
    }

    public void reSize (int i) {
      int width = img.getWidth();
      int height = img.getHeight();

      resize = new BufferedImage(width * i, height * i, 1);
      for (int xcord = 0; xcord < width * i ; xcord += i) {
        for (int ycord = 0; ycord < height * i; ycord +=i) {
          for (int count = 0; count < i; count ++) {
            for (int count2 = 0; count2 < i; count2 ++) {
                
                resize.setRGB(xcord + count, ycord + count2, img.getRGB((xcord / i), (ycord / i)));
            }
            
          }
        }
        
      }
    }

    public void setBlank() {
      int width = img.getWidth();
      int height = img.getHeight();
      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height; ycord ++) {
          img.setRGB(xcord,ycord,-1);
        }

      }
    }

    public void addPixels(int repeat) {
      int width = img.getWidth();
      int height = img.getHeight();
      for (int repeater = 0; repeater < repeat; repeater +=1) {
        int xcord = (int)(Math.random() * width);
        int ycord = (int)(Math.random() * height);
        
        img.setRGB(xcord, ycord, img2.getRGB(xcord,ycord));
      }
    }
    
}
