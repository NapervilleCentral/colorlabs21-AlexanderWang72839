/**
 * Write a description of class PosterIntro here.
 *
 * @author Alexander Wang
 * @version 5/5/2022
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class PosterIntro {
    public static void main(String[] args) {
        Picture apic = new Picture("images/BLITZCRANK.jpg");
        
        something(apic);
        mirrorTempleVertical(apic);
        
        apic.explore();
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
    
    public static void mirrorTempleVertical(Picture apic) {
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
            for (int y = 0 ; y < height ; y++) {
                spot = apic.getPixel(x, y % height);
            }
        }
    }
}
