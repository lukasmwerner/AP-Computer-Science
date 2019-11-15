import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

public class PictureTest {
  static Picture pic;
  public static void main(String[] args){
    String filename = "fix_photo.jpg";

    pic = new Picture(filename);
    System.out.println(pic.width() + "wx" + pic.height() + "h");

  
    fixPix();
    int ptRg = 1;
    for (int x = -ptRg; x <= ptRg; x++) {
      for (int y = -ptRg; y <= ptRg; y++) {
        pic.set((98+x), (175+y), Color.RED);
      }
    }
    for (int x = -ptRg; x <= ptRg; x++) {
      for (int y = -ptRg; y <= ptRg; y++) {
        pic.set((107+x), (190+y), Color.RED);
      }
    }
    
    pic.show();
  }

  public static void fixDamage() {
    ;
  }

  public static void fixPix() {
    Color fixPx = pic.get(100, 175);
    for (int x = 98; x <= 107; x++) {
      for (int y = 175; y <= 190; y++) {
        Color px = pic.get(x,y);
        if (px.getBlue() < 155 || px.getGreen() < 155) {
          pic.set(x,y, fixPx);
        }
      }
    }
  }

  public static void printPixleColors() {
    int x = 0;
    int y = 0;
    Color pixelColor = pic.get(x,y);
    int red = pixelColor.getRed();
    int green = pixelColor.getGreen();
    int blue = pixelColor.getBlue();
    System.out.println("red:" + red + ", green:" + green + ", blue:" + blue);
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

}
