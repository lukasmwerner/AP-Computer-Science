import java.awt.Color;
import java.lang.Math;
import java.util.Arrays;
import java.io.File;
import java.util.*;

public class PictureEditor {
    static Color black = new Color(255, 255, 255);
    static Color white = new Color(0, 0, 0);
    static Picture pic;

    public static void main(String[] args) {
        String filename;
        if (args.length > 0) {
            filename = args[0];
        } else {
            filename = "grandCanyon.JPG";
        }
        

        pic = new Picture(filename);
        System.out.println("Warning this may take a while.");
        System.out.println(pic.width() + "w x " + pic.height() + "h");

        long startTime = System.currentTimeMillis();

        // SortByBrightness();
        // derezer();
        // jumble();
        // addNoise();
        // drawTriangleTop();
        // removeRed();
        // removeBlue();
        // removeGreen();
         vMirror();
         mirror();
        // vFlip();
        // flip();
        // outline();
        // intensifiedSharpen();
        // emboss();
        // randomKernelRun();
        // testKernelConvo();
        // sharpen();
        // meanBlur(1);
        // greyScale(255);
         guassianBlur(13, 10);
        // guassianBlur(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
        // detectEdge();
        // border();
        // printPixelColors();
        // drawDarkerLine();
        // drawSquare(0,0,200);
        // sepia();
        // ordered3x3Dither();
        // guassianBlur(10, 30);
        //guass();
        // invertPic();
        // ordered2x2Dither();
        // coloredOrdered2x2Dither();
        // floydDither();

        // SortByBrightness();

        long endTime = System.currentTimeMillis();
        if ((endTime - startTime) < 1000) {
            System.out.println("That took " + (endTime - startTime) + " miliseconds");
        } else {
            System.out.println("That took " + (endTime - startTime) / 1000 + " seconds");
        }

        if (args.length >= 3) {
            pic.show();
        }
        if (args.length > 1) {
            pic.save(new File(args[1])); // Save our progeess
        } else {
            pic.save(new File("output.png")); // Save our progeess
        }
    }

    public static void printPixelColors() {
        int x = 0;
        int y = 0;
        Color pixelColor = pic.get(x, y);
        int red = pixelColor.getRed();
        int green = pixelColor.getGreen();
        int blue = pixelColor.getBlue();
        System.out.println("red:" + red + ",green:" + green + ",blue:" + blue);
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

    public static void flip() {
        int width = pic.width();
        int height = pic.height();
        int[][] rowImageOne = new int[width][3];
        int[][] rowImageTwo = new int[width][3];
        for (int y = 0; y < height / 2; y++) {
            // read row 1
            for (int x = 0; x < width; x++) {
                rowImageOne[x][0] = pic.get(x, y).getRed();
                rowImageOne[x][1] = pic.get(x, y).getGreen();
                rowImageOne[x][2] = pic.get(x, y).getBlue();
            }
            int yTwo = (height - 1) - y;
            // read row 2
            for (int x = 0; x < width; x++) {
                rowImageTwo[x][0] = pic.get(x, yTwo).getRed();
                rowImageTwo[x][1] = pic.get(x, yTwo).getGreen();
                rowImageTwo[x][2] = pic.get(x, yTwo).getBlue();
            }
            // set row 1
            int x = 0;
            for (int[] colors : rowImageTwo) {
                pic.set(x, y, new Color(colors[0], colors[1], colors[2]));
                x++;
            }
            // set row 1
            int x2 = 0;
            for (int[] colorsT : rowImageOne) {
                pic.set(x2, yTwo, new Color(colorsT[0], colorsT[1], colorsT[2]));
                x2++;
            }

        }
    }

    public static void mirror() {
        int width = pic.width();
        int height = pic.height();
        int[][] rowImageOne = new int[width][3];
        for (int y = 0; y < height / 2; y++) {
            // read row 1
            for (int x = 0; x < width; x++) {
                rowImageOne[x][0] = pic.get(x, y).getRed();
                rowImageOne[x][1] = pic.get(x, y).getGreen();
                rowImageOne[x][2] = pic.get(x, y).getBlue();
            }
            int yTwo = (height - 1) - y;
            // set row 1
            int x2 = 0;
            for (int[] colorsT : rowImageOne) {
                pic.set(x2, yTwo, new Color(colorsT[0], colorsT[1], colorsT[2]));
                x2++;
            }

        }
    }

    public static void vFlip() {
        int width = pic.width();
        int height = pic.height();
        int[][] rowImageOne = new int[height][3];
        int[][] rowImageTwo = new int[height][3];
        for (int x = 0; x < width / 2; x++) {
            // read row 1
            for (int y = 0; y < height; y++) {
                rowImageOne[y][0] = pic.get(x, y).getRed();
                rowImageOne[y][1] = pic.get(x, y).getGreen();
                rowImageOne[y][2] = pic.get(x, y).getBlue();
            }
            int xTwo = (width - 1) - x;
            // read row 2
            for (int y = 0; y < height; y++) {
                rowImageTwo[y][0] = pic.get(xTwo, y).getRed();
                rowImageTwo[y][1] = pic.get(xTwo, y).getGreen();
                rowImageTwo[y][2] = pic.get(xTwo, y).getBlue();
            }
            // set row 1
            int y = 0;
            for (int[] colors : rowImageTwo) {
                pic.set(x, y, new Color(colors[0], colors[1], colors[2]));
                y++;
            }
            // set row 1
            y = 0;
            for (int[] colorsT : rowImageOne) {
                pic.set(xTwo, y, new Color(colorsT[0], colorsT[1], colorsT[2]));
                y++;
            }

        }
    }

    public static void vMirror() {
        int width = pic.width();
        int height = pic.height();
        int[][] rowImageOne = new int[height][3];
        for (int x = 0; x < width / 2; x++) {
            // read row 1
            for (int y = 0; y < height; y++) {
                rowImageOne[y][0] = pic.get(x, y).getRed();
                rowImageOne[y][1] = pic.get(x, y).getGreen();
                rowImageOne[y][2] = pic.get(x, y).getBlue();
            }
            int xTwo = (width - 1) - x;
            // set row 1
            int y = 0;
            for (int[] colorsT : rowImageOne) {
                pic.set(xTwo, y, new Color(colorsT[0], colorsT[1], colorsT[2]));
                y++;
            }

        }
    }

    public static void darken() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color darkend = pic.get(x, y).darker();
                pic.set(x, y, darkend);
            }
        }
    }

    public static void lighten() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color darkend = pic.get(x, y).brighter();
                pic.set(x, y, darkend);
            }
        }
    }

    public static void sepia() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double inputRed = pic.get(x, y).getRed();
                double inputGreen = pic.get(x, y).getGreen();
                double inputBlue = pic.get(x, y).getBlue();
                int outputRed = (int) ((inputRed * .393) + (inputGreen * .769) + (inputBlue * .189));
                int outputGreen = (int) ((inputRed * .349) + (inputGreen * .686) + (inputBlue * .168));
                int outputBlue = (int) ((inputRed * .272) + (inputGreen * .534) + (inputBlue * .131));
                if (outputRed > 255)
                    outputRed = 255;
                if (outputGreen > 255)
                    outputGreen = 255;
                if (outputBlue > 255)
                    outputBlue = 255;

                pic.set(x, y, new Color(outputRed, outputGreen, outputBlue));

            }
        }

    }

    public static void removeRed() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int green = pic.get(x, y).getGreen();
                int blue = pic.get(x, y).getBlue();
                pic.set(x, y, new Color(0, green, blue));
            }
        }
    }

    public static void removeGreen() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = pic.get(x, y).getRed();
                int blue = pic.get(x, y).getBlue();
                pic.set(x, y, new Color(red, 0, blue));
            }
        }
    }

    public static void removeBlue() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int red = pic.get(x, y).getRed();
                int green = pic.get(x, y).getGreen();
                pic.set(x, y, new Color(red, green, 0));
            }
        }
    }

    public static void border() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < 20; y++) {
                pic.set(x, y, Color.GREEN);
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < 20; x++) {
                pic.set(x, y, Color.GREEN);
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = width - 10; x < 20; x++) {
                pic.set(x, y, Color.BLUE);
            }
        }
    }

    public static void drawSquare(int startX, int startY, int width) {
        Color myColor = new Color(255, 255, 255);
        for (int x = startY; x <= width; x++) {
            for (int y = startY; y <= width; y++) {
                pic.set(x, y, myColor);
            }
        }
    }

    public static void drawCenteredSquare() {

    }

    public static void drawTriangleTop() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height - x; y++) {
                pic.set(x, y, new Color(0, 0, 255));
            }
        }
    }
    public static void convolveKernel(double[][] kernel) {
        int width = pic.width() - kernel.length + 1;
        int height = pic.height() - kernel.length + 1;
        int size = kernel.length;
        int part = (int)(size-1.0)/2;
        Picture editPic = new Picture(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                modChannel(i, j, 'r', (int)(pixelConvolve(pic, i, j, kernel, 'r')), editPic);
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                modChannel(i, j, 'g', (int)(pixelConvolve(pic, i, j, kernel, 'g')), editPic);
            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                modChannel(i, j, 'b', (int)(pixelConvolve(pic, i, j, kernel, 'b')), editPic);
            }
        }
        pic = editPic;
    }

    public static double pixelConvolve(Picture img, int x, int y, double[][] k, char color) {
        int kernelWidth = k[0].length;
        int kernelHeight = k.length;
        double ret = 0;
        for (int i = 0; i < kernelWidth; ++i) {
            for (int j = 0; j < kernelHeight; ++j) {
                if (color == 'b') {
                    ret += (img.get(x + i,y + j).getBlue() * k[i][j]);
                } else if (color == 'g') {
                    ret += (img.get(x + i,y + j).getGreen() * k[i][j]);
                } else {
                    ret += (img.get(x + i,y + j).getRed() * k[i][j]);
                }
                
            }
        }
        return ret;
    }

    public static void testKernelConvo() {
        //double[] kernel = { 0, 0, 0, 0, 1, 0, 0, 0, 0 };
        //convolveKernel(kernel);
        double[][] kernel = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        convolveKernel(kernel);
    } 

    public static void sharpen() {
       // double[] kernel = { 0, -1, 0, -1, 5, -1, 0, -1, 0 };
       double[][] kernel = {
            {0, -1, 0},
            {-1, 5, -1},
            {0, -1, 0}
       };
        convolveKernel(kernel);
    }
    public static void guass() {
        double[][] kernel = {
            {0.077847, 	0.123317, 0.077847},
            {0.123317, 	0.195346, 0.123317},
            {0.077847, 	0.123317, 0.077847}
        };
        convolveKernel(kernel);
    }

    public static void detectEdge() {
        // int[] gX = {1,0,-1, 2, 0, -2, 1, 0, -1};
        // convolveKernel(gX);
        double[][] gY = { 
            {-1, -2, -1},
            {0, 0, 0}, 
            {1, 2, 1} 
        };
        convolveKernel(gY);
    }

    public static void emboss() {
        double[][] kernels = { {-2, -1, 0}, {-1, 1, 1}, {0, 1, 2} };
        convolveKernel(kernels);
    }

    public static void intensifiedSharpen() {
        double[][] kernels = { {-1, -1, -1}, {-1, 5, -1}, {-1, -1, -1} };
        convolveKernel(kernels);
    }

    public static void outline() {
        double[][] kernels = { {-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1} };
        convolveKernel(kernels);
    }

    public static void randomKernelRun() {
        double[][] kernels = { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
        for (int i = 0; i < kernels.length; i++) {
            for (int j = 0; j < kernels.length; j++) {
                int randomInt =  (int) (Math.random() * 32) - 16;
                kernels[i][j] = randomInt;
                System.out.print(randomInt + " ");
            }
            System.out.println();
        }        
        convolveKernel(kernels);
    }

    public static void invertPic() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color myPixel = pic.get(x, y);
                int red = 255 - myPixel.getRed();
                int green = 255 - myPixel.getGreen();
                int blue = 255 - myPixel.getBlue();
                Color inverted = new Color(red, green, blue);
                pic.set(x, y, inverted);
            }
        }
    }

    public static void greyScale(int shades) {

        int width = pic.width();
        int height = pic.height();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color myPixel = pic.get(x, y);
                int red = myPixel.getRed();
                int green = myPixel.getGreen();
                int blue = myPixel.getBlue();
                int greyscale = (red + green + blue) / 3;
                double convFac = 255 / (shades - 1.0);
                int shaded = (int) ((greyscale / convFac) + 0.5) * (int) convFac;
                Color inverted = new Color(shaded, shaded, shaded);
                pic.set(x, y, inverted);
            }
        }
    }

    public static void ordered2x2Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                int topLeft = pic.get(x, y).getRed();
                int topRight = pic.get(x + 1, y).getRed();
                int bottomLeft = pic.get(x, y + 1).getRed();
                int bottomRight = pic.get(x + 1, y + 1).getRed();
                if (topLeft > 64) {
                    editPic.set(x, y, black);
                }
                if (topRight > 128) {
                    editPic.set(x + 1, y, black);
                }
                if (bottomLeft > 192) {
                    editPic.set(x, y + 1, black);
                }
                if (bottomRight > 0) {
                    editPic.set(x + 1, y + 1, black);
                }

            }
        }
        pic = editPic;
    }

    public static void coloredOrdered2x2Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                try {
                    int topLeft = pic.get(x, y).getRed();
                    if (topLeft > 64) {
                        picModChannel(x, y, 'r', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int topRight = pic.get(x + 1, y).getRed();
                    if (topRight > 128) {
                        picModChannel(x + 1, y, 'r', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomLeft = pic.get(x, y + 1).getRed();
                    if (bottomLeft > 192) {
                        picModChannel(x, y + 1, 'r', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomRight = pic.get(x + 1, y + 1).getRed();
                    if (bottomRight > 0) {
                        picModChannel(x + 1, y + 1, 'r', 255);
                    }
                } catch (Exception e) {
                    ;
                }
            }
        }
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                try {
                    int topLeft = pic.get(x, y).getGreen();
                    if (topLeft > 64) {
                        picModChannel(x, y, 'g', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int topRight = pic.get(x + 1, y).getGreen();
                    if (topRight > 128) {
                        picModChannel(x + 1, y, 'g', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomLeft = pic.get(x, y + 1).getGreen();
                    if (bottomLeft > 192) {
                        picModChannel(x, y + 1, 'g', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomRight = pic.get(x + 1, y + 1).getGreen();
                    if (bottomRight > 0) {
                        picModChannel(x + 1, y + 1, 'g', 255);
                    }
                } catch (Exception e) {
                    ;
                }
            }
        }
        for (int x = 0; x < width; x += 2) {
            for (int y = 0; y < height; y += 2) {
                try {
                    int topLeft = pic.get(x, y).getBlue();
                    if (topLeft > 64) {
                        picModChannel(x, y, 'b', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int topRight = pic.get(x + 1, y).getBlue();
                    if (topRight > 128) {
                        picModChannel(x + 1, y, 'b', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomLeft = pic.get(x, y + 1).getBlue();
                    if (bottomLeft > 192) {
                        picModChannel(x, y + 1, 'b', 255);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomRight = pic.get(x + 1, y + 1).getBlue();
                    if (bottomRight > 0) {
                        picModChannel(x + 1, y + 1, 'b', 255);
                    }
                } catch (Exception e) {
                    ;
                }

            }
        }
        pic = editPic;
    }

    public static void picModChannel(int x, int y, char color, int ColorInt) {
        modChannel(x, y, color, ColorInt, pic);
    }

    public static void modChannel(int x, int y, char color, int ColorInt, Picture editPic) {
        Color oldColor = editPic.get(x, y);
        Color modded = new Color(255, 255, 255);
        if (ColorInt > 255) {
            ColorInt = 255;
        } else if (ColorInt < 0) {
            ColorInt = 0;
        }

        if (color == 'r') {
            modded = new Color(ColorInt, oldColor.getGreen(), oldColor.getBlue());
        }
        if (color == 'g') {
            modded = new Color(oldColor.getRed(), ColorInt, oldColor.getBlue());
        }
        if (color == 'b') {
            modded = new Color(oldColor.getRed(), oldColor.getGreen(), ColorInt);
        }
        editPic.set(x, y, modded);
    }

    public static void ordered3x3Dither() {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x < width; x += 3) {
            for (int y = 0; y < height; y += 3) {
                try {
                    int topLeft = pic.get(x, y).getRed();
                    if (topLeft > 0) {
                        editPic.set(x, y, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int topCenter = pic.get(x + 1, y).getRed();
                    if (topCenter > 197) {
                        editPic.set(x + 1, y, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int topRight = pic.get(x + 2, y).getRed();
                    if (topRight > 85) {
                        editPic.set(x + 2, y, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int centerLeft = pic.get(x, y + 1).getRed();
                    if (centerLeft > 170) {
                        editPic.set(x, y + 1, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int centerCenter = pic.get(x + 1, y + 1).getRed();
                    if (centerCenter > 141) {
                        editPic.set(x + 1, y + 1, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int centerRight = pic.get(x + 2, y + 1).getRed();
                    if (centerRight > 56) {
                        editPic.set(x + 2, y + 1, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomLeft = pic.get(x, y + 2).getRed();
                    if (bottomLeft > 113) {
                        editPic.set(x, y + 2, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomCenter = pic.get(x + 1, y + 2).getRed();
                    if (bottomCenter > 28) {
                        editPic.set(x + 1, y + 2, black);
                    }
                } catch (Exception e) {
                    ;
                }
                try {
                    int bottomRight = pic.get(x + 2, y + 2).getRed();
                    if (bottomRight > 226) {
                        editPic.set(x + 2, y + 2, black);
                    }
                } catch (Exception e) {
                    ;
                }

            }
        }
        pic = editPic;
    }

    public static void floydDither() {
        int width = pic.width();
        int height = pic.height();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
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
                current = pic.get(x, y).getRed();
                try {
                    below = pic.get(x, y + 1).getRed();
                    belowYN = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    below = 0;
                    belowYN = false;
                }
                try {
                    belowLeft = pic.get(x - 1, y + 1).getRed();
                    belowLeftYN = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    belowLeft = 0;
                    belowLeftYN = false;
                }
                try {
                    belowRight = pic.get(x + 1, y + 1).getRed();
                    belowRightYN = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    belowRight = 0;
                    belowRightYN = false;
                }
                try {
                    right = pic.get(x + 1, y).getRed();
                    rightYN = true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    right = 0;
                    rightYN = false;
                }
                int newVal = (int) Math.ceil(current / 255);
                if (current > 127) {
                    pic.set(x, y, new Color(255, 255, 255));
                } else {
                    pic.set(x, y, new Color(0, 0, 0));
                }
                int error = current - newVal;
                try {
                    tempCalc = below + error * 5 / 16;
                    if (belowYN) {
                        pic.set(x, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                } catch (IllegalArgumentException e) {
                    tempCalc = 0;
                    if (belowYN) {
                        pic.set(x, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                }
                try {
                    tempCalc = belowLeft + error * 3 / 16;
                    if (belowLeftYN) {
                        pic.set(x - 1, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                } catch (IllegalArgumentException e) {
                    tempCalc = 0;
                    if (belowLeftYN) {
                        pic.set(x - 1, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                }
                try {
                    tempCalc = belowRight + error * 1 / 16;
                    if (belowRightYN) {
                        pic.set(x + 1, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                } catch (IllegalArgumentException e) {
                    tempCalc = 0;
                    if (belowRightYN) {
                        pic.set(x + 1, y + 1, new Color(tempCalc, tempCalc, tempCalc));
                    }
                }
                try {
                    tempCalc = right + error * 7 / 16;
                    if (rightYN) {
                        pic.set(x + 1, y, new Color(tempCalc, tempCalc, tempCalc));
                    }
                } catch (IllegalArgumentException e) {
                    tempCalc = 0;
                    if (rightYN) {
                        pic.set(x + 1, y, new Color(tempCalc, tempCalc, tempCalc));
                    }
                }
            }
        }
    }

    public static void meanBlur(int size) {
        int width = pic.width();
        int height = pic.height();
        Picture editPic = pic;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                int mean = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x - Math.abs(ox), y - Math.abs(oy)).getRed();
                            sum += color;
                            avg++;
                        } catch (Exception e) {
                            ;
                        }

                    }
                }
                mean = (int) (sum / avg);
                if (mean > 255) {
                    mean = 255;
                }
                modChannel(x, y, 'r', mean, editPic);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                int mean = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x - Math.abs(ox), y - Math.abs(oy)).getGreen();
                            sum += color;
                            avg++;
                        } catch (Exception e) {
                            ;
                        }

                    }
                }
                mean = (int) (sum / avg);
                if (mean > 255) {
                    mean = 255;
                }
                modChannel(x, y, 'g', mean, editPic);
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double sum = 0;
                double avg = 0;
                int mean = 0;
                for (int ox = -size; ox <= size; ox++) {
                    for (int oy = -size; oy <= size; oy++) {
                        try {
                            double color = pic.get(x - Math.abs(ox), y - Math.abs(oy)).getBlue();
                            sum += color;
                            avg++;
                        } catch (Exception e) {
                            ;
                        }

                    }
                }
                mean = (int) (sum / avg);
                if (mean > 255) {
                    mean = 255;
                }
                modChannel(x, y, 'b', mean, editPic);
            }
        }

        pic = editPic;
    }

    public static double calcGuassianStrength(double x, double y, double strength) {
        double res = (1.0 / (2.0 * Math.PI * Math.pow(strength, 2.0))
                * Math.exp(-((Math.pow(x, 2.0) + Math.pow(y, 2.0)) / (2.0 * Math.pow(strength, 2.0)))));
        return res;
    }

    public static void guassianBlur(int size, double strength) {
        int pos = (int)((size-1.0)/2.0);
        int width = pic.width();
        int height = pic.height();
        double[][] kernels = new double[size][size];
        double sum = 0;
        int y = -pos;
       for (int i = 0; i < kernels.length; i++) {
           int x = -pos;
           for (int j = 0; j < kernels.length; j++) {
               kernels[i][j] = calcGuassianStrength(x, y, strength);
               sum += kernels[i][j];
               x++;
           }
           y++;
       }
       for (int i = 0; i < kernels.length; i++) {
           for (int j = 0; j < kernels.length; j++) {
               kernels[i][j] /= sum;
           }
       }
        convolveKernel(kernels);

    }
    public static void addNoise() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int doOrDoNot = (int)(Math.random() * 25) +1;
                if (doOrDoNot < 4) {
                    pic.set(x,y, new Color(0, 0, 0));
                }
            }
        }
    }
    public static void jumble() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int doOrDoNot = (int)(Math.random() * 25) +1;
                if (doOrDoNot < 20) {
                    int moveX = (int)(Math.random() * 21);
                    int moveY = (int)(Math.random() * 21);
                    try {
                        pic.set(moveX+x, moveY+y, pic.get(x,y));
                    } catch (Exception e) {;}
                }   
            }
        }
    }

    public static void derezer() {
        int width = pic.width();
        int height = pic.height();
        try {
            for (int x = 0; x < width; x+=3) {
                for (int y = 0; y < height; y+=3) {
                    int sum = 0;
                    for (int ox = -1; ox <= 1; ox++) {
                        for (int oy = -2; oy <= 2; oy++) {
                            try {
                                sum += pic.get(x+ox,y+oy).getRed();
                            }catch (Exception e) {;}
                        }
                    }
                    for (int ox = -1; ox <= 1; ox++) {
                        for (int oy = -2; oy <= 2; oy++) {
                            try {
                                picModChannel(x+ox, y+oy, 'r', sum);
                            }catch (Exception e) {;}
                        }
                    }

                }
            }
            for (int x = 0; x < width; x+=3) {
                for (int y = 0; y < height; y+=3) {
                    int sum = 0;
                    for (int ox = -1; ox <= 1; ox++) {
                        for (int oy = -1; oy <= 1; oy++) {
                            try {
                                sum += pic.get(x+ox,y+oy).getBlue();
                            }catch (Exception e) {;}
                        }
                    }
                    for (int ox = -1; ox <= 1; ox++) {
                        for (int oy = -1; oy <= 1; oy++) {
                            try {
                                picModChannel(x+ox, y+oy, 'b', sum);
                            }catch (Exception e) {;}
                        }
                    }

                }
            }
            for (int x = 0; x < width; x+=3) {
                for (int y = 0; y < height; y+=3) {
                    int sum = 0;
                    for (int ox = -2; ox <= 2; ox++) {
                        for (int oy = -2; oy <= 2; oy++) {
                            try {
                                sum += pic.get(x+ox,y+oy).getGreen();
                            }catch (Exception e) {;}
                        }
                    }
                    for (int ox = -2; ox <= 2; ox++) {
                        for (int oy = -2; oy <= 2; oy++) {
                            try {
                                picModChannel(x+ox,y+oy, 'g', sum);
                            }catch (Exception e) {;}
                        }
                    }

                }
            }
        } catch (Exception e) {;}
    }

    public static void SortByBrightness() {
		int width = pic.width();
		int height = pic.height();
		int[][] imageRow = new int[width][4];
		int[] averages = new int[width];
		
		for (int y = 0; y < height; y++) {

			for (int x = 0; x < width; x++) {
				int red = pic.get(x,y).getRed();
				int green = pic.get(x,y).getGreen();
				int blue = pic.get(x,y).getBlue();
				
				int average = (red + green + blue) / 3;
				imageRow[x][0] = red;
				imageRow[x][1] = green;
				imageRow[x][2] = blue;
				imageRow[x][3] = average;
				averages[x] = average;
			}
			Arrays.sort(averages);
			for (int x = 0; x < width; x++) {
				int greyScaled = averages[x];
				int[] colors = new int[3];
				for (int[] pixel : imageRow) {
					if (pixel[3] == greyScaled) {
						colors[0] = pixel[0];
						colors[1] = pixel[1];
						colors[2] = pixel[2];
						break;
					}
				}
				pic.set(x,y, new Color(colors[0], colors[1], colors[2]));
			}
		}

	}
}