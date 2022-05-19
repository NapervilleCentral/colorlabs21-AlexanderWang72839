/**
 * Makes Poster project
 *
 * @author Alexander Wang
 * @version 5/10/22
 */

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Poster {
    public static void main(String[] args) throws IOException {
        System.out.println("Program started");

        final int NUM_OF_PICS = 144;

        /**/
        String picturePath1 = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src\\images\\BEEMO.jpg";
        String picturePath2 = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src\\images\\SBTEEMO.jpg";
        String canvasPath = "C:\\Users\\Alex Wang\\Documents\\GitHub\\APCSPoster\\src/images/TEEMOx144.jpg";

        Picture picture2 = new Picture(picturePath2);
        Picture canvas = new Picture(46314, 46320);

        Picture[] pictures = new Picture[NUM_OF_PICS];

        ArrayList remainingOperations = new ArrayList();

        Operation operation = null;

        int numOfEffects, index;

        //assigning picture paths
        for (int i = 0 ; i < pictures.length ; i++)
            pictures[i] = new Picture(picturePath1);

        canvas.write(canvasPath);

        System.out.println("Finished setup");

        /**/

        //applying a random amount of random operations to each picture
        for (int i = 0 ; i < NUM_OF_PICS ; i++) {
            ArrayList operationsDone = new ArrayList();
            remainingOperations = new ArrayList(Arrays.asList(Operation.mirror, Operation.flip, Operation.grayscale, Operation.invertColors, Operation.blur, Operation.fadeToWhite));
            numOfEffects = (int)(Math.random() * 6);
            for (int j = 0 ; j < numOfEffects ; j++) {
                index = (int)(Math.random() * remainingOperations.size());
                operation = (Operation) remainingOperations.remove(index);
                operationsDone.add(operation);

                if (operation == Operation.mirror)
                    mirror(pictures[j]);

                else if (operation == Operation.flip)
                    flip(pictures[j]);

                else if (operation == Operation.grayscale)
                    grayscale(pictures[j]);

                else if (operation == Operation.invertColors)
                    invertColors(pictures[j]);

                else if (operation == Operation.blur)
                    blend(pictures[j], picture2);

                else if (operation == Operation.fadeToWhite)
                    fadeToWhite(pictures[j], (int)(Math.random() * pictures[j].getWidth() - 1), (int)(pictures[j].getHeight() - 1));
            }
            System.out.println("image " + i + " has finished processing; added effect(s): " + operationsDone);
        }

        //writing all pictures to canvas
        //16x9
        for (int i = 0 ; i < NUM_OF_PICS ; i++) {
            copyToCanvas(pictures[i], canvas, pictures[i].getWidth() * (i % 9), pictures[i].getHeight() *  (i / 9));
            System.out.println(i + " finished copying image " + i + " (" + i % 9 + ", " + (i / 9) + ")");
        }

        System.out.println("Finished processing; writing image to file");

        canvas.write(canvasPath);

        /*

        int i = 0;
        mirrorVerticalLeft(pictures[++i]);
        pictures[i].explore();
        mirrorVerticalRight(pictures[++i]);
        pictures[i].explore();
        mirrorHorizontalUp(pictures[++i]);
        pictures[i].explore();
        mirrorHorizontalDown(pictures[++i]);
        pictures[i].explore();

        flipHorizontal(pictures[++i]);
        pictures[i].explore();
        flipVertical(pictures[++i]);
        pictures[i].explore();

        grayscale(pictures[++i]);
        pictures[i].explore();
        invertColors(pictures[++i]);
        pictures[i].explore();

        blend(pictures[++i], picture2);
        pictures[i].explore();

        fadeToWhite(pictures[++i], (int)(pictures[i].getWidth() / 2), (int)(pictures[i].getHeight() / 2));
        pictures[i].explore();

        /*

        //exploring each picture
        for (Picture pic : pictures)
            pic.explore();

         /**/
        System.out.println("Finished");
    }

    /**
     * randomly selects a mirror function and executes it on the given picture
     *
     * @param pic the picture to be modified
     */
    public static void mirror(Picture pic) {
        switch ((int)(Math.random() * 4) + 1) {
            case 1:
                mirrorVerticalLeft(pic);
                break;
            case 2:
                mirrorVerticalRight(pic);
                break;
            case 3:
                mirrorHorizontalUp(pic);
                break;
            case 4:
                mirrorHorizontalDown(pic);
                break;
        }
    }

    /**
     * randomly selects a flip function and executes it on the given picture
     *
     * @param pic the picture to be modified
     */
    public static void flip(Picture pic) {
        if ((int)(Math.random() * 1) == 0)
            flipHorizontal(pic);
        else
            flipVertical(pic);
    }

    /**
     * copies the source image to the canvas at a designation location
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
     * Mirrors the image vertically to the right along its center
     * @param pic the picture to be modified
     */
    public static void mirrorVerticalRight(Picture pic) {
        Pixel leftPixel;
        Pixel rightPixel;

        int height = pic.getHeight();
        int width = pic.getWidth();

        for (int x = 0 ; x < width / 2 ; x++) {
            for (int y = 0 ; y < height ; y++) {
                leftPixel = pic.getPixel(x, y);
                rightPixel = pic.getPixel(width - x - 1, y);

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Mirrors the image vertically to the left along its center
     * @param pic the picture to be modified
     */
    public static void mirrorVerticalLeft(Picture pic) {
        Pixel leftPixel;
        Pixel rightPixel;

        int height = pic.getHeight();
        int width = pic.getWidth();

        for (int x = width / 2 ; x < width ; x++) {
            for (int y = 0 ; y < height ; y++) {
                leftPixel = pic.getPixel(x, y);
                rightPixel = pic.getPixel(width - x - 1, y);

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Mirrors the image horizontal, top to down along its center
     * @param pic the picture to be modified
     */
    public static void mirrorHorizontalDown(Picture pic) {
        Pixel leftPixel;
        Pixel rightPixel;

        int height = pic.getHeight();
        int width = pic.getWidth();

        for (int x = 0 ; x < width ; x++) {
            for (int y = 0 ; y < height / 2; y++) {
                leftPixel = pic.getPixel(x, y);
                rightPixel = pic.getPixel(x, height - y - 1);

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Mirrors the image horizontally top to down along its center
     * @param pic the picture to be modified
     */
    public static void mirrorHorizontalUp(Picture pic) {
        Pixel leftPixel;
        Pixel rightPixel;

        int height = pic.getHeight();
        int width = pic.getWidth();

        for (int x = 0 ; x < width ; x++) {
            for (int y = height / 2 ; y < height ; y++) {
                leftPixel = pic.getPixel(x, y);
                rightPixel = pic.getPixel(x, height - y - 1);

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Flips the image up to down along its center
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
     * Flips the image left to right along its center
     * @param pic the picture to be modified
     */
    public static void flipVertical(Picture pic) {
        Pixel top;
        Pixel bot;

        Color temp = new Color(0, 0, 0);

        int width = pic.getWidth();
        int height = pic.getHeight();

        for (int x = 0 ; x < width / 2; x++) {
            for (int y = 0 ; y < height ; y++) {
                top = pic.getPixel(x, y);
                bot = pic.getPixel(width - x - 1, y);

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
     * recursively fades the picture to white
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

        //gets the largest distance to the edge
        int distance = distances[1];
        for (int i : distances) {
            if (i > distance)
                distance = i;
        }

        fadeToWhite(pic, startX, startY, (int)(distance * 1.5) / 255, 0, 1, Direction.all);
    }

    /**
     * recursivly fades the picture to white
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

        try {
            pixel.getColor();
        } catch (Exception e) {
            return;
        }

        int width = pic.getWidth();
        int height = pic.getHeight();

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
