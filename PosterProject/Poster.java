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
        //String picturePath = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src\\images\\BEEMO.jpg";

        //String canvasPath = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src\\images\\PosterCanvas.png";
        //String canvasPath = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src\\images\\LargePosterCanvas.png";

        
        String picturePath = "images/BEEMO_Downscaled.jpg";
        String otherPicturePath = "images/SBTEEMO_Downscaled.jpg";
        
        String canvasPath = "images/PosterCanvas.png";

        Picture pic1 = new Picture(picturePath);
        Picture pic2 = new Picture(picturePath);
        Picture pic3 = new Picture(picturePath);
        Picture pic4 = new Picture(picturePath);
        Picture pic5 = new Picture(picturePath);
        Picture pic6 = new Picture(picturePath);
        
        Picture otherPic = new Picture(otherPicturePath);

        Picture canvas = new Picture(canvasPath);

        final int WIDTH = pic1.getWidth();
        final int HEIGHT = pic1.getHeight();
        
        //mirrorVertical(pic1);
        //flipHorizontal(pic2);
        //grayscale(pic3);
        //invertColors(pic4);
        //fadeToWhite(pic5, WIDTH / 2, HEIGHT / 2);
        blend(pic6, otherPic);
        
        //pic1.explore();
        //pic2.explore();
        //pic3.explore();
        //pic4.explore();
        //pic5.explore();
        pic6.explore();
        
        
        /*
         * layout of poster
         * 
         * 1 2 3
         * 4 5 6
         */
        //copyToCanvas(pic1, canvas, 0 * WIDTH + 5, 0 * HEIGHT + 5); //1
        //copyToCanvas(pic2, canvas, 1 * WIDTH + 5, 0 * HEIGHT + 5); //2
        //copyToCanvas(pic3, canvas, 0 * WIDTH + 5, 1 * HEIGHT + 5); //3
        //copyToCanvas(pic4, canvas, 1 * WIDTH + 5, 1 * HEIGHT + 5); //4
        //copyToCanvas(pic5, canvas, 0 * WIDTH + 5, 2 * HEIGHT + 5); //5
        //copyToCanvas(pic6, canvas, 1 * WIDTH + 5, 2 * HEIGHT + 5); //6

        canvas.write(canvasPath);
    }

    /**
     * copies the source image to 
     * the canvas at a designation location
     * 
     * @param source image to copy over
     * @param canvas the blank image to copy to
     * @param xOff the x location of the canvas to copy to
     * @param yOff the y location of the canvas to copy to
     */
    public static void copyToCanvas(Picture source, Picture canvas, int xOff, int yOff) {
        Pixel c;
        Pixel s;

        int height = source.getHeight();
        int width = source.getWidth();

        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                c = canvas.getPixel(x + xOff, y + yOff);
                s = source.getPixel(x, y);

                c.setColor(s.getColor());
            }
        }
    }

    /**
     * Mirrors the image verticaly along its center
     * 
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
     * 
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
     * 
     * @param pic the picture to be modified
     */
    public static void grayscale(Picture pic) {
        Pixel pixel;

        int r, g, b, gray;

        int width = pic.getWidth();
        int height = pic.getHeight();

        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                pixel = pic.getPixel(x, y);

                r = pixel.getColor().getRed();
                g = pixel.getColor().getGreen();
                b = pixel.getColor().getBlue();
                
                gray = (int)(0.299 * r + 0.587 * g + 0.114 * b);

                pixel.setColor(new Color(gray, gray, gray));
            }
        }
    }

    /**
     * Inverts all colors
     * 
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
     * blends the image with another
     * 
     * @param pic1 the picture to be blended
     * @param pic2 the picture to be blended
     */
    public static void blend(Picture pic1, Picture pic2) {
        Pixel pixel1, pixel2;

        int r, g, b;

        int width = pic1.getWidth();
        int height = pic1.getHeight();
        int width2 = pic2.getWidth();
        int height2 = pic2.getHeight();
        
        if (width != width2 || height != height2) {
            System.out.println("Picture resolutions are not the same");
            return;
        }
        
        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                pixel1 = pic1.getPixel(x, y);
                pixel2 = pic2.getPixel(x, y);

                r = (pixel1.getColor().getRed() + pixel2.getColor().getRed()) / 2;
                g = (pixel1.getColor().getGreen() + pixel2.getColor().getGreen()) / 2;
                b = (pixel1.getColor().getBlue() + pixel2.getColor().getBlue()) / 2;

                pixel1.setColor(new Color(r, g, b));
            }
        }
    }

    /**
     * sets up and calls the recursive function that fades 
     * the picture to white from startX and startY
     * 
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
        fadeToWhite(pic, startX, startY, (int)(distance * 1.5) / 255, 0, 1, Direction.all);
    }

    /**
     * recursivly fades the picture to white
     * 
     * @param pic the picture to be modified
     * @param startX the starting x value of the darkest spot
     * @param startY the starting y value of the darkest spot
     * @param intensity the speed that colors turn to white
     * @param count the progress of each color until the color is lightend a bit more
     * @param progress keeps track of the amount to add to each color each time
     * @param direction the direction that the gradient is going
     */
    public static void fadeToWhite(Picture pic, int startX, int startY, int intensity, int count, int progress, Direction direction) {
        Pixel pixel = pic.getPixel(startX, startY);
        
        int width = pic.getWidth();
        int height = pic.getHeight();
        
        //base case
        try {
            pixel.getColor();
        } catch (Exception e) {
            return;
        }

        int r = pixel.getColor().getRed();
        int g = pixel.getColor().getGreen();
        int b = pixel.getColor().getBlue();

        if (count >= intensity) {
            count = 0;
            progress++;
        }

        r += progress;
        g += progress;
        b += progress;

        if (r > 255)
            r = 255;

        if (g > 255)
            g = 255;

        if (b > 255)
            b = 255;

        pixel.setColor(new Color(r, g, b));

        count++;

        if (direction == Direction.all) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, progress, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, progress, Direction.down);
            fadeToWhite(pic, startX - 1, startY, intensity, count, progress, Direction.left);
            fadeToWhite(pic, startX + 1, startY, intensity, count, progress, Direction.right);
        }
        else if (direction == Direction.left) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, progress, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, progress, Direction.down);
            fadeToWhite(pic, startX - 1, startY, intensity, count, progress, Direction.left);
        }
        else if (direction == Direction.right) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, progress, Direction.up);
            fadeToWhite(pic, startX, startY + 1, intensity, count, progress, Direction.down);
            fadeToWhite(pic, startX + 1, startY, intensity, count, progress, Direction.right);
        }

        else if (direction == Direction.up) {
            fadeToWhite(pic, startX, startY - 1, intensity, count, progress, Direction.up);
        }

        else if (direction == Direction.down) {
            fadeToWhite(pic, startX, startY + 1, intensity, count, progress, Direction.down);
        }
    }
}
