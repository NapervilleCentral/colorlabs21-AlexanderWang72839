/**
* sheparFairey-ify an images 3 times
*
* @author Alexander Wang
* @version 11/12/21
*/

import java.awt.*;
import java.util.*;
import java.util.List;
    
public class SheparFaireyLab {
    public static void main(String[] args) {
        Picture p1 = new Picture("images/mickey-mouse-shoes.jpg");
        Picture p2 = new Picture("images/mickey-mouse-shoes.jpg");
        Picture p3 = new Picture("images/mickey-mouse-shoes.jpg");
        int r, g, b, average;
        int dimmest = 255, brightest = 0;
        
        //method 1
        //gets grayscale value of pixel
        //converts pixel to white if pixel is < 25% of 255
        //converts pixel to light blue if pixel is < 25% of 255
        //converts pixel to red if pixel is < 25% of 255
        //converts pixel to dark blue if pixel is < 25% of 255
            
        Pixel[] picture;
        picture = p1.getPixels();
        for (Pixel pixelObj : picture) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            average = (r + g + b)/3;
                
                
            if (average < 1 * (255 / 4)) {
                pixelObj.setColor(new Color(64, 96, 192));
            }
                
            else if (average < 2 * (255 / 4)) {
                pixelObj.setColor(new Color(128, 32, 32));
            }
            
            else if (average < 3 * (255 / 4)) {
                pixelObj.setColor(new Color(64, 64, 128));
            }
            
            else {
                pixelObj.setColor(new Color(200, 200, 170));
            }
        }
        p1.explore();
        p1.write("images/SheparFaireyBalenced.jpg");
        
        //method 2
        //convert to grayscale
        //find dimmest pixel
        //find brightest pixel
        //do method 1 with brighest and dimmest
        
        picture = p2.getPixels();
        for (Pixel pixelObj : picture) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            average = (r + g + b)/3;
            pixelObj.setColor(new Color(average, average, average));
            
            if (average < dimmest)
                dimmest = average;
            if (average > brightest)
                brightest = average;
        }
        System.out.println(dimmest + "  " + brightest);
        for (Pixel pixelObj : picture) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            average = (r + g + b)/3;
            
            if (average < 1 * ((brightest - dimmest) / 4)) {
                pixelObj.setColor(new Color(64, 96, 192));
            }
                
            else if (average < 2 * ((brightest - dimmest) / 4)) {
                pixelObj.setColor(new Color(128, 32, 32));
            }
            
            else if (average < 3 * ((brightest - dimmest) / 4)) {
                pixelObj.setColor(new Color(64, 64, 128));
            }
            
            else {
                pixelObj.setColor(new Color(200, 200, 170));
            }
            
           }
        System.out.println(dimmest + ":" + brightest);
        p2.explore();
        p2.write("images/SheparFaireyIntense.jpg");
        
        //method3
        //does method 1
        //uses different color palette
        
        picture = p3.getPixels();
        for (Pixel pixelObj : picture) {
            r = pixelObj.getRed();
            g = pixelObj.getGreen();
            b = pixelObj.getBlue();
            average = (r + g + b)/3;
                
                
            if (average < 1 * (255 / 4)) {
                pixelObj.setColor(new Color(3, 43, 48));
            }
                
            else if (average < 2 * (255 / 4)) {
                pixelObj.setColor(new Color(74, 173, 91));
            }
            
            else if (average < 3 * (255 / 4)) {
                pixelObj.setColor(new Color(102, 128, 141));
            }
            
            else {
                pixelObj.setColor(new Color(249, 182, 249));
            }
        }
        p3.explore();
        p3.write("images/SheparFaireyCustomPalette.jpg");
    }
}
