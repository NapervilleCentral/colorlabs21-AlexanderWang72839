/**
 * Write a description of class PosterIntro here.
 *
 * @author Alexander Wang
 * @version 5/5/2022
 */

import java.awt.*;
import java.util.*;

public class PosterIntro {
    public static void main(String[] args) {
        Picture apic = new Picture("images/BLITZCRANK.jpg");
        Picture temple = new Picture("images/temple.jpg");
        
        Picture sourcePic = new Picture("images/caterpillar.jpg");
        Picture targetPic = new Picture("images/640x480.jpg");
        
        
        temple.explore();
        
        something(apic);
        mirrorVertical(apic);
        //mirrorTemple(16, 23, 276, 108, temple);
        mirrorTemple(16, 23, 282, 108, temple);
        
        //apic.explore();
        temple.explore();
        
        
        targetPic.explore();
        copyTo(sourcePic, targetPic, 0, 0);
        targetPic.explore();
    }
    
    public static void something (Picture apic) {
        int height = apic.getHeight();
        int width = apic.getWidth();
        Pixel spot;
        
        for (int r = 0 ; r < width ; r++) {
            for (int c = 0 ; c < height ; c++) {
                spot = apic.getPixel(r, c);
                
                spot.setGreen(spot.getGreen() + 50);
            }
        }
    }
    
    public static void mirrorVertical(Picture apic) {
        int height = apic.getHeight();
        int width = apic.getWidth();
        int mirrorPoint = width / 2;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int x = 0 ; x <= mirrorPoint ; x++) {
            for (int y = 0 ; y < height ; y++) {
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(width - x - 1, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    public static void diagonal(Picture apic, int intesity) {
        int height = apic.getHeight();
        int width = apic.getWidth();
        Pixel spot;
        Pixel temp;
        
        for (int x = 0 ; x <= width ; x++) {
            for (int y = 0 ; y < height * x ; y++) {
                temp = 
                spot = apic.getPixel(x, y);
            }
        }
    }
    
    public static void mirrorTemple(int startX, int startY, int endX, int endY, Picture apic) {
        int width = apic.getWidth();
        int height = apic.getHeight();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        
        for (int x = startX ; x <= endX; x++) {
            for (int y = startY ; y < endY ; y++) {
                leftPixel = apic.getPixel(x, y);
                rightPixel = apic.getPixel(width - x - 1, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    /**
     * copy Source to Target at pos x, y
     * @param Picture sorce, taget, x, y
     */
    public static void copyTo(Picture source, Picture target, int xOffset, int yOffset) {
        int height = source.getHeight();
        int width = source.getWidth();
        Pixel t = null;
        Pixel s = null;
        
        for (int x = 0 ; x < width ; x++) {
           for (int y = 0 ; y < height ; y++) {
                t = target.getPixel(x + xOffset, y + yOffset);
                s = source.getPixel(x, y);
                
                t.setColor(s.getColor());
           }    
        }
    }
}
