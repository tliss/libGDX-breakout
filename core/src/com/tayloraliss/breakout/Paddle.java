package com.tayloraliss.breakout;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    private int x, y, width, height;

    public Paddle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shape){
        shape.rect(x, y, width, height);
    }

    public void update(){
        this.x = (Gdx.input.getX() - this.width / 2);
        this.y = (Gdx.graphics.getHeight() - (Gdx.input.getY() + this.height / 2));
    }

}
