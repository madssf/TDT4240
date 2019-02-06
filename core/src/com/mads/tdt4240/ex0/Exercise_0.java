package com.mads.tdt4240.ex0;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mads.tdt4240.ex0.states.GameStateManagerSingleton;
import com.mads.tdt4240.ex0.states.MenuState;

public class Exercise_0 extends ApplicationAdapter {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 480;

	public static final String TITLE = "TDT4240 - Exercise 0";

	private GameStateManagerSingleton gsm;
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = GameStateManagerSingleton.getInstance();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
