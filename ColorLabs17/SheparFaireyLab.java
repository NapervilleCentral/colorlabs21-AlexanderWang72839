    
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
            Picture original = new Picture("images/tyler-mickey-mouse-shoes.jpg");
            int r, g, b, average;
            //gets grayscale value of pixel
            //converts pixel to white if pixel is < 25% of 255
            //converts pixel to light blue if pixel is < 25% of 255
            //converts pixel to red if pixel is < 25% of 255
            //converts pixel to dark blue if pixel is < 25% of 255
            
            Pixel[] picture;
            picture = original.getPixels();
        for (Pixel pixelObj : picture) {
                r = pixelObj.getRed();
                g = pixelObj.getGreen();
                b = pixelObj.getBlue();
                average = (r + g + b)/3;
                
                
                if (average < 1 * 255 / 4) {
                    pixelObj.setColor();
                }
                
                else if (average < 2 * 255 / 4) {
                    pixelObj.setColor();
                }
            
                else if (average < 3 * 255 / 4) {
                    pixelObj.setColor();
                }
            
                else if (average < 4 * 255 / 4) {
                    pixelObj.setColor();
                }
        }
    }
}
