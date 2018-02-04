package com.tayloraliss.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;


	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(150, 200, 20, 0);
		paddle = new Paddle(30, 30, 150, 20);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ball.update();
		paddle.update();
		ball.checkCollision(paddle);

		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.draw(shape);
		paddle.draw(shape);
		shape.end();
	}
}