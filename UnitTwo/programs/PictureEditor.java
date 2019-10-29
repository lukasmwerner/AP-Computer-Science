import java.awt.Color;

public class PictureEditor {
    
    static Picture pic;
    
    public static void main(String[] args) {
        
        String filename = "galaxy.jpg";
        
        pic = new Picture(filename);
        System.out.println(pic.width() + "w x " + pic.height()+"h");
        
        printPixelColors();
        drawDarkerLine();
        //drawSquare(0,0,200);
        //invertPic();
        greyScale(3);
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


    public static void drawSquare(int startX, int startY, int width) {
        Color myColor = new Color(255, 255, 255);
        for (int x = startX; x<=width; x++) {
            for (int y = startY; y<=width; y++) {
                pic.set(x,y,myColor);
            }
        }
    }
    
    public static void drawCenteredSquare() {
        
    }
    
    public static void drawTriangleTop() {
        
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

    public static void dither() {
        int width = pic.width();
        int height = pic.height();
        for (int x = 0; x<width; x++) {
            for (int y = 0; y<height;y++) {
                int below = pic.get(x,y+1).getRed();


            }
        }
    }
}