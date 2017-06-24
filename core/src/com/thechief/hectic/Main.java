package com.thechief.hectic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thechief.hectic.states.GameState;
import com.thechief.hectic.states.StateManager;

public class Main extends ApplicationAdapter {

	public static final int WIDTH = 900, HEIGHT = 900 / 16 * 9;
	public static final String TITLE = "As You Can See, This Game Is Very Hectic";

	private SpriteBatch sb;

	private long lastTime;

	@Override
	public void create() {
		// DO THESE BEFORE THE MAIN INITIALIZATION OF THE GAME.
		sb = new SpriteBatch();
		Textures.INIT_ALL();

		lastTime = System.currentTimeMillis();
		StateManager.setCurrentState(new GameState());
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Updating the current state
		StateManager.updateAndRenderCurrentState(sb, Gdx.graphics.getDeltaTime());

		// Writing the fps to the title of the screen
		if (System.currentTimeMillis() - lastTime > 1000) {
			Gdx.graphics.setTitle(TITLE + " | FPS: " + Gdx.graphics.getFramesPerSecond());
			lastTime = 0;
		}
	}

	@Override
	public void dispose() {
		sb.dispose();
		Textures.DISPOSE_ALL();
		StateManager.getCurrentState().dispose();
	}
}