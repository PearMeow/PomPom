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

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImageApp() {
       try {
           img = ImageIO.read(new File("PNG-128/US-128.png"));
       } catch (IOException e) {
       }
       try {
           img2 = ImageIO.read(new File("PNG-128/US-128.png"));
       } catch (IOException e) {
       }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

    public String toString() {
      int width = img.getWidth();
      int height = img.getHeight();
      System.out.println(width + "by " + height);
      String retVal = "";
      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height; ycord ++) {
          retVal += ("(" + img.getRGB(xcord,ycord) +  "), ");
        }
        retVal += ("\n");
      }
      return retVal;
    }

    public void setBlank() {
      int width = img.getWidth();
      int height = img.getHeight();
      for (int xcord = 0; xcord < width ; xcord ++) {
        for (int ycord = 0; ycord < height; ycord ++) {
          img.setRGB(xcord,ycord,-201326593);
        }

      }
    }

    public void reSize(int multiple) {
      int width = img.getWidth();
      int height = img.getHeight();
      img = img.getScaledInstance(width * multiple,height * multiple, multiple);
      img2 = img2.getScaledInstance(width * multiple,height * multiple, multiple);
    }

    public void addPixels(int repeat) {
      int width = img.getWidth();
      int height = img.getHeight();
      for (int repeater = 0; repeater < repeat; repeater +=1) {
        int xcord = (int)(Math.random() * width);
        int ycord = (int)(Math.random() * height);
        System.out.println(xcord + ", " + ycord);
        img.setRGB(xcord, ycord, img2.getRGB(xcord,ycord));
      }
    }

}
