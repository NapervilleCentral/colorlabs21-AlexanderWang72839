
/**
 * Makes Poster project
 *
 * @author Alexander Wang
 * @version 5/10/22
 */

import java.awt.*;
import java.util.*;
import java.util.List;

public class Poster {
    public static void main(String[] args) {
        Picture pic1 = new Picture("images/Poros&nunu.jpg");
        Picture pic2 = new Picture("images/Poros&nunu.jpg");
        Picture pic3 = new Picture("images/Poros&nunu.jpg");
        Picture pic4 = new Picture("images/Poros&nunu.jpg");
        Picture pic5 = new Picture("images/Poros&nunu.jpg");
        Picture pic6 = new Picture("images/Poros&nunu.jpg");
        Picture pic7 = new Picture("images/Poros&nunu.jpg");
        
        Picture canvas = new Picture();
        
        final int WIDTH = pic1.getWidth();
        final int HEIGHT = pic1.getHeight();
        
        //mirrorVertical(pic1);
        //flipHorizontal(pic2);
        //grayscale(pic3);
        //invertColors(pic4);
        fadeToWhite(pic5, WIDTH / 2, HEIGHT / 2);
        
        //pic1.explore();
        //pic2.explore();
        //pic3.explore();
        //pic4.explore();
        pic5.explore();        
    }
    
    /**
     * copies the source image to the canvas at a desgination location
     * @param source image to copy over
     * @param the blank image to copy to
     * @param the x location of the canvas to copy to
     * @param the y location of the canvas to copy to
     */
    public static void copyToCanvas(Picture source, Picture canvas, int xOff, int yOff) {
        Pixel c;
        Pixel s;
        
        int height = source.getHeight();
        int width = source.getWidth();
        
        for (int x = 0 ; x < width ; x++) {
           for (int y = 0 ; y < height ; y++) {
                c = canvas.getPixel(x, y);
                s = source.getPixel(x, y);
                
                c.setColor(s.getColor());
           }    
        }
    }
    
    /**
     * Mirrors the image verticaly along its center
     * @param pic the picture to be modified
     */
    public static void mirrorVertical(Picture pic) {
        Pixel leftPixel;
        Pixel rightPixel;
        
        int height = pic.getHeight();
        int width = pic.getWidth();
        
        for (int x = 0 ; x <= width / 2 ; x++) {
            for (int y = 0 ; y < height ; y++) {
                leftPixel = pic.getPixel(x, y);
                rightPixel = pic.getPixel(width - x - 1, y);
                
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    
    /**
     * Flips the image horizontaly along its center
     * @param pic the picture to be modified
     */
    public static void flipHorizontal(Picture pic) {
        Pixel top;
        Pixel bot;
        
        Color temp = new Color(0, 0, 0);
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height / 2 ; y++) {
                top = pic.getPixel(x, y);
                bot = pic.getPixel(x, height - y - 1);
                
                temp = top.getColor();
                top.setColor(bot.getColor());
                bot.setColor(temp);
            }
        }
    }
    
    /**
     * Grayscales the image
     * @param pic the picture to be modified
     */
    public static void grayscale(Picture pic) {
        Pixel pixel;
        
        int r, g, b, average;
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                pixel = pic.getPixel(x, y);
                
                r = pixel.getColor().getRed();
                g = pixel.getColor().getGreen();
                b = pixel.getColor().getBlue();
                
                average = (r + g + b) / 3;
                
                pixel.setColor(new Color(average, average, average));
            }
        }
    }
    
    /**
     * Inverts all colors
     * @param pic the picture to be modified
     */
    public static void invertColors(Picture pic) {
        Pixel pixel;
        
        int r, g, b;
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                pixel = pic.getPixel(x, y);
                
                r = pixel.getColor().getRed();
                g = pixel.getColor().getGreen();
                b = pixel.getColor().getBlue();
                
                pixel.setColor(new Color(255 - r, 255 - g, 255 - b));
            }
        }
    }
    
    /**
     * recursivly blures the image
     * @param pic the picture to be modified
     */
    public static void blur(Picture pic) {
        
    }
    
    /**
     * recursivly fades the picture to white
     * @param pic the picture to be modified
     * @param startX the starting x value of the darkest spot
     * @param startY the starting y value of the darkest spot
     */
    public static void fadeToWhite(Picture pic, int startX, int startY) {
        Pixel up, down, left, right;
        
        Pixel pixel = pic.getPixel(startX, startY);
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        int[] distances = new int[] {startX, startY, width - startX, height - startY};
        
        //gets largest distance to the edge
        int distance = distances[1];
        for (int i : distances) {
            if (i > distance)
                distance = i;
        }
        
        fadeToWhite(pic, startX, startY, distance / 255, 0, Direction.all);
    }
    
    /**
     * recursivly fades the picture to white
     * @param pic the picture to be modified
     * @param startX the starting x value of the darkest spot
     * @param startY the starting y value of the darkest spot
     * @param intensity the speed that colors turn to white
     * @param count the progress of each color until the color is lightend a bit more
     * @param Direction the direction that the gradient is going
     */
    public static void fadeToWhite(Picture pic, int startX, int startY, int intensity, int count, Direction direction) {
        //System.out.println("!");
        Pixel pixel = pic.getPixel(startX, startY);
        
        try {
            boolean a = pixel.getColor().getRed() < 255;
        } catch (Exception e) {
            return;
        }
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        if (count >= intensity) {
            count = 0;
            if (pixel.getColor().getRed() < 255)
                pixel.setColor(new Color(pixel.getRed() + 1, pixel.getGreen(), pixel.getBlue()));
                
            if (pixel.getColor().getGreen() < 255)
                pixel.setColor(new Color(pixel.getRed(), pixel.getGreen() + 1, pixel.getBlue()));
                
            if (pixel.getColor().getBlue() < 255)
                pixel.setColor(new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue() + 1));
        }    
        
        count++;
        
        if (direction == Direction.all) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, Direction.down);
            fadeToWhite(pic, startX - 1, startY, intensity, count, Direction.left);
            fadeToWhite(pic, startX + 1, startY, intensity, count, Direction.right);
        }
        
        if (direction == Direction.left) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, Direction.down);
            fadeToWhite(pic, startX - 1, startY, intensity, count, Direction.left);
        }
        
        if (direction == Direction.right) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, Direction.down);
            fadeToWhite(pic, startX + 1, startY, intensity, count, Direction.right);
        }
        
        if (direction == Direction.up) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, Direction.up);
        }
        
        if (direction == Direction.down) {
            fadeToWhite(pic, startX, startY + 1, intensity, count, Direction.down);
        }
    }
}
