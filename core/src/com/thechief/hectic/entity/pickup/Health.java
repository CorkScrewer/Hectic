package com.thechief.hectic.entity.pickup;

import com.badlogic.gdx.math.Vector2;
import com.thechief.hectic.Sounds;
import com.thechief.hectic.Textures;
import com.thechief.hectic.states.GameState;

public class Health extends Pickup {

	private GameState gs;
	private int addHealth;
	private long lastTime;
	
	
	public Health(int addHealth, Vector2 pos, GameState gs, int width, int height) {
		super(Textures.health, pos, width, height);
		this.gs = gs;
		this.addHealth = addHealth;
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void update(float dt) {
		bob(0.3f, 16);
		if (isColliding(gs.getPlayer())) {
			Sounds.healthPickup.play(0.35f);
			gs.getPlayer().setHp(gs.getPlayer().getHp() + addHealth);
			gs.entities.removeValue(this, false);
		}
		if (System.currentTimeMillis() - lastTime > 1500) {
			gs.entities.removeValue(this, false);
			lastTime = System.currentTimeMillis();
		}
	}
	
}
