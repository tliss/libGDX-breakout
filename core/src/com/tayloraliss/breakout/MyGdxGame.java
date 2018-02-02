package com.tayloraliss.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Random r = new Random();


	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(150, 200, 20, 12, 5);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.move();
		ball.checkBoundaries(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		shape.end();

	}
}