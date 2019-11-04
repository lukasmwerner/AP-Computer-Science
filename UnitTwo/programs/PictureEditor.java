import java.awt.Color;
import java.lang.Math;

public class PictureEditor {
    static Color black = new Color(255,255,255);
    static Color white = new Color(0,0,0);
    static Picture pic;
    
    public static void main(String[] args) {
        
        String filename = "javapic.jpg";
        
        pic = new Picture(filename);
        System.out.println("Warning this may take a while.");
        System.out.println(pic.width() + "w x " + pic.height()+"h");
        
        long startTime = System.currentTimeMillis();
        
        testKernelConvo();
        //sharpen();
        //border();
        //printPixelColors();
        //drawDarkerLine();
        //drawSquare(0,0,200);
        //greyScale(256);
        //invertPic();
        //sepia();
        //ordered3x3Dither();
        //droppedCam(16, 10);
        //invertPic();
        //meanBlur(1);
        
        //ordered2x2Dither();
        //coloredOrdered2x2Dither();
        //floydDither();
        long endTime = System.currentTimeMillis();
        if ((endTime - startTime) < 1000) {
            System.out.println("That took " + (endTime - startTime) + " miliseconds");
        }
        else {
            System.out.println("That took " + (endTime - startTime)/1000 + " seconds");
        }

        pic.show();
    }
    
    
    public static void printPixelColors() {
        int x = 0;
        int y = 0;
        Color pixelColor = pic.get(x, y);
        int red = pixelColor.getRed();
        int green = pixelColor.getGreen();
        int blue = pixelColor.getBlue();
        System.out.println("red:"+red+",green:"+green+",blue:"+blue);
    }

    public static void drawDarkerLine() {
        int y = 10;
        int width = 200;
        for (int x = 0; x < width; x++) {
            int red = 10;
            int blue = 10;
            int green = 10;
            Color pixelColor = new Color(red, green, blue);
            pic.set(x, y, pixelColor);
        }
    }
    public static void darken() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height; y++) {
                Color darkend = pic.get(x,y).darker();
                pic.set(x,y,darkend);
            }
        }
    }
    public static void lighten() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height; y++) {
                Color darkend = pic.get(x,y).brighter();
                pic.set(x,y,darkend);
            }
        }
    }
    public static void sepia() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height; y++) {
                double inputRed = pic.get(x,y).getRed();
                double inputGreen = pic.get(x,y).getGreen();
                double inputBlue = pic.get(x,y).getBlue();
                int outputRed = (int)((inputRed * .393) + (inputGreen *.769) + (inputBlue * .189));
                int outputGreen = (int)((inputRed * .349) + (inputGreen *.686) + (inputBlue * .168));
                int outputBlue = (int)((inputRed * .272) + (inputGreen *.534) + (inputBlue * .131));
                if (outputRed > 255) outputRed = 255;
                if (outputGreen > 255) outputGreen = 255;
                if (outputBlue > 255) outputBlue = 255;

                pic.set(x,y, new Color(outputRed, outputGreen, outputBlue));

            }
        }
        
    }


    public static void border() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<20; y++) {
                pic.set(x,y,Color.GREEN);
            }
        }
        for (int y = 0; y<height; y++) {
            for (int x = 0; x<20; x++) {
                pic.set(x,y,Color.GREEN);
            }
        }
        for (int y = 0; y<height; y++) {
            for (int x = width-10; x<20; x++) {
                pic.set(x,y,Color.BLUE);
            }
        }
    }

    public static void drawSquare(int startX, int startY, int width) {
        Color myColor = new Color(255, 255, 255);
        for (int x = startY; x<=width; x++) {
            for (int y = startY; y<=width; y++) {
                pic.set(x,y,myColor);
            }
        }
    }
    
    public static void drawCenteredSquare() {
        
    }
    
    public static void drawTriangleTop() {
        
    }
    

    public static void convolveKernel(int[] kernels) {
        int size = kernels.length;
        int width = pic.width();
        int height = pic.height();
        Picture editPic = new Picture(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y<height; y++) {
                
                double sum = 0;
                double avg = 0;
                int counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy) ).getRed();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                if (value > 255) {value = 250;}
                modChannel(x, y, 'r', value, editPic);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y<height; y++) {
                
                double sum = 0;
                double avg = 0;
                int counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy) ).getGreen();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                if (value > 255) {value = 250;}
                modChannel(x, y, 'g', value, editPic);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y<height; y++) {
                
                double sum = 0;
                double avg = 0;
                int counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy) ).getBlue();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                if (value > 255) {value = 250;}
                modChannel(x, y, 'b', value, editPic);
            }
        }
        pic = editPic;
    }

    public static void testKernelConvo() {
        int[] kernel = {0,0,0,0,1,0,0,0,0};
        convolveKernel(kernel);
    }

    public static void sharpen() {
        int[] kernel = {0,-1,0,-1,5,-1,0,-1,0};
        convolveKernel(kernel);
    }

    public static void invertPic() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height;y++) {
                Color myPixel = pic.get(x,y);
                int red   = 255 - myPixel.getRed();
                int green = 255 - myPixel.getGreen();
                int blue  = 255 - myPixel.getBlue();
                Color inverted = new Color(red, green, blue);
                pic.set(x,y,inverted);
            }
        }
    }
    
    public static void greyScale(int shades) {
        
        int width = pic.width();
        int height = pic.height();
        
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height;y++) {
                Color myPixel = pic.get(x,y);
                int red   = myPixel.getRed();
                int green = myPixel.getGreen();
                int blue  = myPixel.getBlue();
                int greyscale = (red+green+blue) / 3;
                double convFac = 255 / (shades - 1.0);
                int shaded = (int)((greyscale / convFac ) + 0.5) * (int)convFac;
                Color inverted = new Color(shaded, shaded, shaded);
                pic.set(x,y,inverted);
            }
        }
    }
    public static void ordered2x2Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x<width; x+=2) {
            for (int y = 0; y<height;y+=2) {
                int topLeft = pic.get(x,y).getRed();
                int topRight = pic.get(x+1,y).getRed();
                int bottomLeft = pic.get(x, y+1).getRed();
                int bottomRight = pic.get(x+1, y+1).getRed();
                if (topLeft > 64) {editPic.set(x,y, black);}
                if (topRight > 128) {editPic.set(x+1,y, black);}
                if (bottomLeft > 192) {editPic.set(x,y+1, black);}
                if (bottomRight > 0) {editPic.set(x+1, y+1, black);}

            }
        }
        pic = editPic;
    }
    public static void coloredOrdered2x2Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x<width; x+=2) {
            for (int y = 0; y<height;y+=2) {
                try {int topLeft = pic.get(x,y).getRed(); if (topLeft > 64) {picModChannel(x,y,'r', 255);}} catch (Exception e) {;}
                try {int topRight = pic.get(x+1,y).getRed(); if (topRight > 128) {picModChannel(x+1,y,'r', 255);}} catch (Exception e) {;}
                try {int bottomLeft = pic.get(x, y+1).getRed(); if (bottomLeft > 192) {picModChannel(x,y+1,'r', 255);}} catch (Exception e) {;}
                try {int bottomRight = pic.get(x+1, y+1).getRed(); if (bottomRight > 0) {picModChannel(x+1, y+1,'r', 255);}} catch (Exception e) {;}
            }
        }
        for (int x = 0; x<width; x+=2) {
            for (int y = 0; y<height;y+=2) {
                try {int topLeft = pic.get(x,y).getGreen(); if (topLeft > 64) {picModChannel(x,y,'g', 255);}} catch (Exception e) {;}
                try {int topRight = pic.get(x+1,y).getGreen();if (topRight > 128) {picModChannel(x+1,y,'g', 255);}} catch (Exception e) {;}
                try {int bottomLeft = pic.get(x, y+1).getGreen();if (bottomLeft > 192) {picModChannel(x,y+1,'g', 255);}} catch (Exception e) {;}
                try {int bottomRight = pic.get(x+1, y+1).getGreen();if (bottomRight > 0) {picModChannel(x+1, y+1,'g', 255);}} catch (Exception e) {;}
            }
        }
        for (int x = 0; x<width; x+=2) {
            for (int y = 0; y<height;y+=2) {
                try {int topLeft = pic.get(x,y).getBlue(); if (topLeft > 64) {picModChannel(x,y,'b', 255);}} catch (Exception e) {;}
                try {int topRight = pic.get(x+1,y).getBlue(); if (topRight > 128) {picModChannel(x+1,y,'b', 255);}} catch (Exception e) {;}
                try {int bottomLeft = pic.get(x, y+1).getBlue(); if (bottomLeft > 192) {picModChannel(x,y+1,'b', 255);}} catch (Exception e) {;}
                try {int bottomRight = pic.get(x+1, y+1).getBlue(); if (bottomRight > 0) {picModChannel(x+1, y+1,'b', 255);}} catch (Exception e) {;}
                
                
                
                
            }
        }
        pic = editPic;
    }
    public static void picModChannel(int x, int y, char color, int ColorInt) {
        modChannel(x,y,color,ColorInt, pic);
    }

    public static void modChannel(int x, int y, char color, int ColorInt, Picture editPic) {
        if (color != 'r' || color != 'g' || color != 'b') {return;}
        Color oldColor = pic.get(x,y);
        Color modded = new Color(255,255,255);
        if (ColorInt > 255) {ColorInt = 255;}
        if (color == 'r') {modded = new Color(ColorInt, oldColor.getGreen(), oldColor.getBlue());}
        if (color == 'g') {modded = new Color(oldColor.getRed(), ColorInt, oldColor.getBlue());}
        if (color == 'b') {modded = new Color(oldColor.getRed(), oldColor.getGreen(), ColorInt);}
        editPic.set(x,y,modded);
    }

    public static void ordered3x3Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x<width; x+=3) {
            for (int y = 0; y<height;y+=3) {
                try {int topLeft = pic.get(x,y).getRed();
                if (topLeft > 0) {editPic.set(x,y, black);}} catch (Exception e) {;}
                try {int topCenter = pic.get(x+1,y).getRed();
                if (topCenter > 197) {editPic.set(x+1,y, black);}} catch (Exception e) {;}
                try {int topRight = pic.get(x+2,y).getRed();
                if (topRight > 85) {editPic.set(x+2,y, black);}} catch (Exception e) {;}
                try {int centerLeft = pic.get(x,y+1).getRed();
                if (centerLeft > 170) {editPic.set(x,y+1,black);}} catch (Exception e) {;}
                try {int centerCenter = pic.get(x+1,y+1).getRed();
                if (centerCenter > 141) {editPic.set(x+1,y+1,black);}} catch (Exception e) {;}
                try {int centerRight = pic.get(x+2, y+1).getRed();
                if (centerRight > 56) {editPic.set(x+2,y+1,black);}} catch (Exception e) {;}
                try {int bottomLeft = pic.get(x, y+2).getRed();
                if (bottomLeft > 113) {editPic.set(x,y+2, black);}} catch (Exception e) {;}
                try {int bottomCenter = pic.get(x+1, y+2).getRed();
                if (bottomCenter > 28) {editPic.set(x+1,y+2, black);}} catch (Exception e) {;}
                try {int bottomRight = pic.get(x+2, y+2).getRed();    
                if (bottomRight > 226) {editPic.set(x+2, y+2, black);}} catch (Exception e) {;}

            }
        }
        pic = editPic;
    }


    public static void floydDither() {
        int width = pic.width();
        int height = pic.height();
        
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height;y++) {
                int tempCalc = 0;
                
                    int current;
                    int below = 255;
                    int belowLeft = 255;
                    int belowRight = 255;
                    boolean belowYN = true;
                    boolean belowLeftYN = true;
                    boolean belowRightYN = true;
                    int right = 255;
                    boolean rightYN = true;
                    current = pic.get(x,y).getRed();
                    try {below = pic.get(x,y+1).getRed(); belowYN = true;} catch (ArrayIndexOutOfBoundsException e) {below = 0; belowYN = false;}
                    try {belowLeft = pic.get(x-1,y+1).getRed(); belowLeftYN = true;}  catch (ArrayIndexOutOfBoundsException e) {belowLeft = 0; belowLeftYN = false;}
                    try {belowRight = pic.get(x+1, y+1).getRed(); belowRightYN = true;} catch (ArrayIndexOutOfBoundsException e) {belowRight = 0; belowRightYN = false;}
                    try {right = pic.get(x+1, y).getRed(); rightYN = true;} catch (ArrayIndexOutOfBoundsException e) {right = 0;rightYN = false;}
                    int newVal = (int)Math.ceil(current /255);
                    if (current > 127) {pic.set(x,y, new Color(255, 255, 255));}
                    else {pic.set(x,y, new Color(0, 0, 0));}
                    int error = current - newVal;
                    try {
                        tempCalc = below + error * 5/16;
                        if (belowYN) {pic.set(x,y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    } catch (IllegalArgumentException e) {
                        tempCalc = 0;
                        if (belowYN) {pic.set(x,y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    }
                    try {
                        tempCalc = belowLeft + error * 3/16;
                        if (belowLeftYN) {pic.set(x-1,y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    } catch (IllegalArgumentException e) {
                        tempCalc = 0;
                        if (belowLeftYN) {pic.set(x-1,y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    }
                    try {
                        tempCalc = belowRight + error * 1/16;
                        if (belowRightYN) {pic.set(x+1, y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    } catch (IllegalArgumentException e) {
                        tempCalc = 0;
                        if (belowRightYN) {pic.set(x+1, y+1, new Color(tempCalc, tempCalc, tempCalc));}
                    }
                    try {
                        tempCalc = right + error * 7/16;
                        if (rightYN) {pic.set(x+1, y, new Color(tempCalc, tempCalc, tempCalc));}
                    } catch (IllegalArgumentException e) {
                        tempCalc = 0;
                        if (rightYN) {pic.set(x+1, y, new Color(tempCalc, tempCalc, tempCalc));}
                    }
            }
        }
    }

    public static void meanBlur(int size) {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height;y++) {
                /*int avg = 0;
                int topLeft = 0;
                int topCenter = 0;
                int topRight = 0;
                int centerLeft = 0;
                int centerCenter = 0;
                int centerRight = 0;
                int bottomLeft = 0;
                int bottomCenter = 0;
                int bottomRight = 0;
                try {topLeft = pic.get(x-1,y-1).getRed();avg++;} catch (Exception e) {;}
                try {topCenter = pic.get(x,y-1).getRed();avg++;} catch (Exception e) {;}
                try {topRight = pic.get(x+1,y-1).getRed();avg++;} catch (Exception e) {;}
                try {centerLeft = pic.get(x-1,y).getRed();avg++;} catch (Exception e) {;}
                try {centerCenter = pic.get(x,y).getRed();avg++;} catch (Exception e) {;}
                try {centerRight = pic.get(x+1, y).getRed();avg++;} catch (Exception e) {;}
                try {bottomLeft = pic.get(x-1, y+1).getRed();avg++;} catch (Exception e) {;}
                try {bottomCenter = pic.get(x, y+1).getRed();avg++;} catch (Exception e) {;}
                try {bottomRight = pic.get(x+1, y+1).getRed();avg++;} catch (Exception e) {;}
                
                int mean = ((topLeft + topCenter + topRight + centerLeft + centerCenter + centerRight + centerLeft + bottomLeft + bottomCenter + bottomRight)/avg);*/
                double sum = 0;
                double avg = 0;
                int mean = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy) ).getRed();
                            sum += color;
                            avg++;
                        } catch (Exception e) {;}

                    }
                }
                mean = (int)(sum / avg);
                if (mean > 255) {mean = 255;}
                editPic.set(x,y, new Color(mean,mean,mean));
            }
        }
        
        pic = editPic;
    }

    public static double calcGuassianStrength(double x, double y, double strength) {
        double res = ( 1.0/(2.0 * Math.PI * Math.pow(strength, 2.0)) * Math.exp( -( (Math.pow(x, 2.0) + Math.pow(y, 2.0) ) / ( 2.0 * Math.pow(strength, 2.0) ) ) ) );
        return res;
    }
    
    public static void droppedCam(int size, double strength) {
        
        int width = pic.width();
        int height = pic.height();
        Picture editPic = new Picture(width, height);//pic;
        double[] kernels = new double[(int)Math.pow(size, 3)];
        int counter = 0;

        //calculate kernel
        for (int ox = -size; ox <= size; ox++) {
            for (int oy = -size; oy <= size; oy++) {
                kernels[counter] = calcGuassianStrength(ox, oy, strength);
                counter++;
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) { 
                editPic.set(x,y, new Color(255,255,255));
            }
        }

        //calculate red
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy) ).getRed();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                editPic.set(x,y, new Color(value, 255, 255));
                //modChannel(x, y, 'r', value, editPic);
            }
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy)).getBlue();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                int red = editPic.get(x,y).getRed();
                editPic.set(x,y, new Color(red,value,255));
                //modChannel(x, y, 'b', value, editPic);
            }
        }
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                counter = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x-Math.abs(ox), y-Math.abs(oy)).getGreen();
                            double kernel = kernels[counter];
                            color = color * kernel;
                            sum += color;
                            avg+= kernel;
                            counter++;
                        } catch (Exception e) {counter++;}

                    }
                }
                int value = (int)(sum/avg);
                int red = editPic.get(x,y).getRed();
                int green = editPic.get(x,y).getGreen();
                editPic.set(x,y, new Color(red, green, value));
                //modChannel(x, y, 'g', value, editPic);
            }
        }

        


        
        


        pic = editPic;
    }
}