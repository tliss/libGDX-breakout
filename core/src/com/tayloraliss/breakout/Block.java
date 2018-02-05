package com.tayloraliss.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {

    int x,y,width,height, leftLimit, rightLimit, topLimit, bottomLimit;

    boolean destroyed = false;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        updateLimits();
    }

    public void updateLimits(){
        this.leftLimit = x;
        this.rightLimit = x + this.width;
        this.bottomLimit = y;
        this.topLimit = y + this.height;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public int getTopLimit() {
        return topLimit;
    }

    public int getBottomLimit() {
        return bottomLimit;
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
