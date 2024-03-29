
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      //opens picture using a dialog box
      /**/
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     
     //picture loads all of the pixels into a n array uses a relative path
     //Picture apic = new Picture("images\\beach.jpg");
     Picture ferris1 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris2 = new Picture("images/2000 ferris wheel2.jpg");
     Picture ferris3 = new Picture("images/2000 ferris wheel2.jpg");
     Picture somepic = new Picture("images/robot.jpg");
     Picture katie = new Picture("images/KatieFancy.jpg");
     
     katie.explore();
     Pixel[] katieP;
     katieP = katie.getPixels();
     
     int r, b, g;
     
     for (Pixel pixelObj : katieP) {
         r = pixelObj.getRed();
         g = pixelObj.getGreen();
         b = pixelObj.getBlue();
         
         if (125 < r && r < 160 && 130 < g && g < 155 && 115 < b && b < 145)
            pixelObj.setColor(new Color(224, 176, 255));
     }
     
     katie.explore();
     
     //apic.explore();
     //ferris1.explore();
     //somepic.explore();
     
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /**/
        //access each index
    System.out.println(pixels[17]);
    //access each pixel by -- Picture.getPixel(x,y);
    Pixel spot = ferris1.getPixel(100,100);
    
    spot.setColor(new Color (171, 205, 239));
    System.out.println("spot" + spot);
    //ferris1.explore();
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);

    ferris1.explore();
/**/
   // loop to access indexes of array or collection

    //for each loop spot  is a ?
    /*int count = 0;
    int r, g ,b;
    for (Pixel spot3 : pixels) {
        r = spot3.getRed();
        spot3.setRed(r*2);
        
        g = spot3.getGreen();
        spot3.setGreen(g*5);
        
        b = spot3.getBlue();
        spot3.setBlue(b * (int)Math.random() * 10);
        count++;
    }*/
    
    
    
    
    
    


   
 /**/

 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
    pixels = ferris2.getPixels();
    for (Pixel ferris2 : pixels) {
        ferris2.getRed();

    }
    ferris2.explore();
    
/**/
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();

  /**/ 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg");
    Picture apic = new Picture("images/bluemark.jpg");
    Pixel[] markspixs = apic.getPixels();

    /**
       Method to change  he picture to grayscale
       Gray is a rgb values of all the same
       what values would you pic to set all of the rgb
       */
      int grayLevel;
      for (Pixel apix : markspixs) {
        grayLevel = (int)(0.299 * r + 0.587 * g + 0.114 * b);
      }  
  }//main
}//class
