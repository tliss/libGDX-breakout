package com.tayloraliss.breakout;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball{
    private int x;
    private int y;
    private int size;
    private int xSpeed;
    private int ySpeed;
    private int ballLeftLimit;
    private int ballRightLimit;
    private int ballTopLimit;
    private int ballBottomLimit;

    public Ball() {
        this.x = 50;
        this.y = 50;
        this.size = 50;
        this.xSpeed = 5;
        this.ySpeed = 5;
        this.ballLeftLimit = this.x - this.size;
        this.ballRightLimit = this.x + this.size;
        this.ballTopLimit = this.y + this.size;
        this.ballBottomLimit = this.y - this.size;
    }

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
        updateBallLimits();
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getBallLeftLimit() {
        return ballLeftLimit;
    }

    public int getBallRightLimit() {
        return ballRightLimit;
    }

    public int getBallTopLimit() {
        return ballTopLimit;
    }

    public int getBallBottomLimit() {
        return ballBottomLimit;
    }

    public void reverseX(){
        this.xSpeed = -this.xSpeed;
    }

    public void reverseY(){
        this.ySpeed = -this.ySpeed;
    }

    public void updateBallLimits(){
        this.ballLeftLimit = this.x - this.size;
        this.ballRightLimit = this.x + this.size;
        this.ballTopLimit = this.y + this.size;
        this.ballBottomLimit = this.y - this.size;
    }

    public void checkBoundaries(int boundaryWidth, int boundaryHeight){
        if (this.getBallRightLimit() > boundaryWidth || this.getBallLeftLimit() < 0) {
            this.reverseX();
        }
        if (this.getBallTopLimit() > boundaryHeight ||this.getBallBottomLimit() < 0) {
            this.reverseY();
        }
    }

    public void move(){
        this.addxSpeed();
        this.addySpeed();
    }

    public void draw(ShapeRenderer shape){
        shape.circle(x, y, size);
    }
}
