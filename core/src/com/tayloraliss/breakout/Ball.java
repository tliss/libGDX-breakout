package com.tayloraliss.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball{
    private int x;
    private int y;
    private int size;
    private int xSpeed, ySpeed;
    private int ballLeftLimit;
    private int ballRightLimit;
    private int ballTopLimit;
    private int ballBottomLimit;

    public Ball(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = this.ySpeed = speed;
        this.ballLeftLimit = this.x - this.size;
        this.ballRightLimit = this.x + this.size;
        this.ballTopLimit = this.y + this.size;
        this.ballBottomLimit = this.y - this.size;
    }

    public void addxSpeed(){
        this.x += this.getxSpeed();
        updateBallLimits();
    }

    public void addySpeed(){
        this.y += this.getySpeed();
        updateBallLimits();
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void updateBallLimits(){
        this.ballLeftLimit = this.x - this.size;
        this.ballRightLimit = this.x + this.size;
        this.ballTopLimit = this.y + this.size;
        this.ballBottomLimit = this.y - this.size;
    }

    public void update(){
        this.addxSpeed();
        this.addySpeed();
        if (this.ballRightLimit > Gdx.graphics.getWidth() || this.ballLeftLimit < 0) {
            this.xSpeed = -this.xSpeed;
        }
        if (this.ballTopLimit >  Gdx.graphics.getHeight() || this.ballBottomLimit < 0) {
            this.ySpeed = -this.ySpeed;
        }
    }

    public void draw(ShapeRenderer shape){
        shape.circle(x, y, size);
    }
}
