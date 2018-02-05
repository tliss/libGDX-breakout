package com.tayloraliss.breakout;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private ArrayList<Block> blocks = new ArrayList<Block>();
	int blockWidth = 63;
	int blockHeight = 20;

	@Override
	public void create () {
		shape = new ShapeRenderer();
		ball = new Ball(150, 200, 10, 5);
		paddle = new Paddle(30, 30, 150, 20);

		for (int y = Gdx.graphics.getHeight()/2; y < Gdx.graphics.getHeight(); y += blockHeight + 10){
			for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x, y, blockWidth, blockHeight));
			}
		}
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
		for (Block block : blocks) {
			block.draw(shape);
			ball.checkCollision(block);
		}
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.destroyed) {
				blocks.remove(b);
				// we need to decrement i when a ball gets removed, otherwise we skip a block!
				i--;
			}
		}

		shape.end();
	}
}