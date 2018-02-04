package com.tayloraliss.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball{
    private int x;
    private int y;
    private int size;
    private int xSpeed, ySpeed;
    private int leftLimit;
    private int rightLimit;
    private int topLimit;
    private int bottomLimit;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int speed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = this.ySpeed = speed;
        updateLimits();
    }

    public void addxSpeed(){
        this.x += this.getxSpeed();
        updateLimits();
    }

    public void addySpeed(){
        this.y += this.getySpeed();
        updateLimits();
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void updateLimits(){
        this.leftLimit = this.x - this.size;
        this.rightLimit = this.x + this.size;
        this.topLimit = this.y + this.size;
        this.bottomLimit = this.y - this.size;
    }

    public void update(){
        this.addxSpeed();
        this.addySpeed();
        if (this.rightLimit > Gdx.graphics.getWidth() || this.leftLimit < 0) {
            this.xSpeed = -this.xSpeed;
        }
        if (this.topLimit >  Gdx.graphics.getHeight() || this.bottomLimit < 0) {
            this.ySpeed = -this.ySpeed;
        }
    }

    public void draw(ShapeRenderer shape){
        shape.setColor(color);
        shape.circle(x, y, size);
    }

    public void checkCollision(Paddle paddle){
        if (collidesWith(paddle)){
            color = Color.GREEN;
        }
        else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle){
        if ((paddle.getLeftLimit() < this.rightLimit) && (paddle.getLeftLimit() > this.leftLimit)){
            return true;
        } else {
            return false;
        }
    }
}
