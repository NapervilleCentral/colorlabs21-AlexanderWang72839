------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Poster Project
PURPOSE OF PROJECT: To make cool posters and to lag out computers
VERSION or DATE: 5/16/22
AUTHORS: Alexander Wang
USER INSTRUCTIONS: If you decide(not recomended) Run this command in the folder of jar (without quotes): 
"java -Xss10m -jar PosterProject.jar"


The poster is composed of 144 images, in an array of 9 by 16. Each image is given a random amount of random effects. 
There are a total of 10 effects, though only 6 can be applied. This is because the mirror has 4 variations and the 
flip has 2. The effects are mirrorVerticalLeft,  mirrorVerticalRight, mirrorHorizontalLeft, mirrorHorizontalRight, 
FlipVertical, FlipHorizontal, Grayscale, invertColors, blend, and fadeToWhite.

Operations
Mirror
All variations of the mirror function uses two nested loops to go through each Pixel on half of the image and copies 
the rgb values the the corresponding Pixel on the other side of the image.

Flip
	All variations of the Flip method uses two nested loops that go through half of the image, saving the 
initial Color, copying the corresponding Pixel’s Color to the original one, and then finally setting the second 
Pixel to the saved Color.

Grayscale
	The grayscale function uses nested loops to go through each Pixel. The function then takes the rgb values, 
and uses a formula that is more accurate that averaging out the Colors. This formula takes into account that each 
Color is viewed by the human eye at a different brightness.

invertColors
	The invert color function goes through each Pixel with two nested loops, and takes each Color’s rgb value 
and gets the difference between it and 255.

Blend
	Blend takes two images and checks if they are the same resolution. If it is then it continues with the rest 
of the function. The function takes the average of the colors and copies it to the first picture.

fadeToWhite
	This function takes in a Picture and a coordinate. This  coordinate is the location where the image retains 
most of its color. The function puts all the distances from the point to the edge and puts it into a list. A for 
loop then finds the largest number. This number is first multiplied by 1.5 and then divided by 255. This number is 
the number of pixels that have the same color until the color is decremented by 1. This operation ensures that the 
edge of the pixel is faded but a little bit of the color is maintained. The function then calls the recursive function
that does the fading. An enum is used to give the function 5 different modes. This ensures that no Pixel is faded twice.
The function will call the pixel to the left or right, depending on the location of the previous pixel. The function also
calls the pixel above and below it. The functions that go up and down on the picture only call the pixel above or below it,
as any other pixel will already be modified by another function. All of these functions will run until it can’t without an error. 
This will end the function.
