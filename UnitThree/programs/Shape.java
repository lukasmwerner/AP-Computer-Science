import java.awt.Color;

public class Shape {
    private int x;
    private int y;
    private int width;
    private Color color;
    private boolean invertedX;
    private boolean invertedY;
    private int speed;
    
    /*
     * default constructor
     */
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 20;
        color = new Color(0,255,0);
        invertedX = true;
        invertedY = true;
        speed = 1;
    }
    public Shape(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        color = new Color(0,255,0);
        invertedX = true;
        invertedY = true;
        speed = 1;
    }
    public Shape(int x, int y, int width, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        color = new Color(0,255,0);
        invertedX = true;
        invertedY = true;
        this.speed = speed;
    }
    public Shape(int x, int y, int width, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
        invertedX = true;
        invertedY = true;
        speed = 1;
    }
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = 10;
        this.color = color;
        invertedX = true;
        invertedY = true;
        speed = 1;
    }
    public Shape(int x, int y, int width, Color color, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
        invertedX = true;
        invertedY = true;
        this.speed = speed;
    }
    public Shape(int x, int y, int width, Color color, boolean dir) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
        speed = 1;
        invertedX = dir;
        invertedY = dir;
    }


    public void move() {
        if (x < 0 || x+width > 800) {invertedX = !invertedX;}
        if (y < 0 || y+width > 800-23) {invertedY = !invertedY;}

        if (invertedX) {x+=speed;}
        else {x-=speed;}

        if (invertedY) {y+=speed;}
        else {y-=speed;}
    }






    
    public void collide(Shape other) {
        if(x+width > other.getX() && x < other.getX()+other.getWidth()){
            if (y+width > other.getY() && y < other.getY()+other.getHeight()) {
                invertedY = !invertedY;
                invertedX = !invertedX;
            }
            
        }
        
    }

    public int getWidth() {return width;}
    public int getHeight() {return width;}
    public int getX() {return x;}
    public int getY() {return y;}
    public Color getColor() {return color;}
}