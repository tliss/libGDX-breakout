package com.tayloraliss.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private int x, y, width, height;

    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

}
