package CellSim;

import java.awt.*;
import java.util.Random;

public class Cell {
    private int xPos = 50;
    private int yPos = 50;
    private int size = 20;
    private Color color = Color.RED;

    private Rectangle border;

    public Random rnd = new Random();

    public Cell(Rectangle border){
        this.border = border;
    }

    public Cell(int startX, int startY, Rectangle border){
        xPos = startX;
        yPos = startY;
        this.border = border;
    }

    public int getX() {
        return xPos;
    }

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBorder(Rectangle border){
        this.border = border;
    }

    public Rectangle getRect(){
        return new Rectangle(xPos, yPos, size, size);
    }

    public void moveCell(int x, int y) {
        final int top = border.y;
        final int bottom = border.height+border.y;
        final int left = border.x;
        final int right = border.width+border.y;

        setX(getX() + x);
        if(getX() > right-size){
            setX(right-size);
        }
        if(getX() < left){
            setX(left);
        }

        setY(getY() + y);
        if(getY() > bottom-size){
            setY(bottom-size);
        }
        if(getY() < top){
            setY(top);
        }
    }

    public void paintCell(Graphics g){
        g.setColor(color);
        g.fillRect(xPos, yPos, size , size);
    }

}
