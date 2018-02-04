package com.tayloraliss.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private int x, y, width, height, leftLimit, rightLimit, topLimit, bottomLimit;

    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        updateLimits();
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

    public void updateLimits(){
        this.leftLimit = x;
        this.rightLimit = x + this.width;
        this.bottomLimit = y;
        this.topLimit = y + this.height;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    public void update(){
        this.x = (Gdx.input.getX() - this.width / 2);
        this.y = (Gdx.graphics.getHeight() - (Gdx.input.getY() + this.height / 2));
        updateLimits();
    }

}
