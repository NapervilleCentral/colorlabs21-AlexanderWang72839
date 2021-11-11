/**
 * destroys images
 *
 * @author Alexander Wang
 * @version 11/10/21
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class ColorLab {
    public void maxRed() {
        
    }
    
    public static void main(String[] args) {
        Picture p1 = new Picture("images/femaleLionAndHall.jpg");
        Picture p2 = new Picture("images/femaleLionAndHall.jpg");
        Picture p3 = new Picture("images/femaleLionAndHall.jpg");
        Picture p4 = new Picture("images/femaleLionAndHall.jpg");
        Picture p5 = new Picture("images/femaleLionAndHall.jpg");
        Picture p6 = new Picture("images/femaleLionAndHall.jpg");
        Picture p7 = new Picture("images/femaleLionAndHall.jpg");
        Picture p8 = new Picture("images/femaleLionAndHall.jpg");
        
        int r, g, b, light;
        double redFactor;
        
        p1.explore();
        
        //swap3
        Pixel[] swap3;
        swap3 = p8.getPixels();
        for (Pixel pixelObj : swap3) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            
            pixelObj.setRed(b);
            pixelObj.setGreen(r);
            pixelObj.setBlue(g);
        }
        p8.explore();
        
        //swap2
        Pixel[] swap2;
        swap2 = p7.getPixels();
        for (Pixel pixelObj : swap2) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            
            pixelObj.setRed(g);
            pixelObj.setGreen(r);
        }
        p7.explore();
        
        //colorify
        Pixel[] colorify;
        colorify = p6.getPixels();
        for (Pixel pixelObj : colorify) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            
            if (r < 25 && g < 25 && b < 25) {
                pixelObj.setColor(new Color(184, 153, 27));
            }
        }
        p6.explore();
        
        //lighten
        light = 50;
        Pixel[] lighten;
        lighten = p5.getPixels();
        for (Pixel pixelObj : lighten) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            
            pixelObj.setRed(r + light);
            pixelObj.setGreen(g + light);
            pixelObj.setBlue(b + light);
        }
        p5.explore();
        
        //grayscale
        Pixel[] grayscale;
        grayscale = p4.getPixels();
        for (Pixel pixelObj : grayscale) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            
            pixelObj.setColor(new Color((r + g + b)/3, (r + g + b)/3, (r + g + b)/3));
        }
        p4.explore();
        
        //adjustRed
        redFactor = 0.5;
        Pixel[] adjustRed;
        adjustRed = p3.getPixels();
        for (Pixel pixelObj : adjustRed) {
            r = pixelObj.getRed();
            pixelObj.setRed(r * (int)redFactor);
        }
        p3.explore();
        
        //negate
        Pixel[] negate;
        negate = p2.getPixels();
        for (Pixel pixelObj : negate) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            
            pixelObj.setRed(255 - r);
            pixelObj.setGreen(255 - g);
            pixelObj.setBlue(255 - b);
        }
        
        p2.explore();
        //maxRed
        Pixel[] maxRed;
        maxRed = p1.getPixels();
        for (Pixel pixelObj : maxRed) {
            pixelObj.setRed(255);
        }
    }
}
