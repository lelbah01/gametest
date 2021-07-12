package game;

import java.awt.*;

public abstract class GameObject {
    protected int x, y;
    protected ID id;
    // protected int velX, velY; // x and y speed? would need getters and setters

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick(); // what should be checked/updated either over time or as a result of user interaction
    public abstract void render(Graphics g);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
