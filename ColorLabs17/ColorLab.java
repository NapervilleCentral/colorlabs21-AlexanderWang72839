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
        Pixel[] maxRed;
        maxRed = p1.getPixels();
        for (Pixel pixelObj : maxRed) {
            pixelObj.setRed(255);
        }
    }
    
    public static void main(String[] args) {
        Picture p1 = new Picture("images/femaleLionAndHall.jpg");
        Picture p2 = new Picture("images/femaleLionAndHall.jpg");
        Picture p3 = new Picture("images/femaleLionAndHall.jpg");
        
        int r, g, b;
        
        p1.explore();
        p1.maxRed();
        //maxRed
        Pixel[] maxRed;
        maxRed = p1.getPixels();
        for (Pixel pixelObj : maxRed) {
            pixelObj.setRed(255);
        }
        p1.explore();
        
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
    }
    
    
}
