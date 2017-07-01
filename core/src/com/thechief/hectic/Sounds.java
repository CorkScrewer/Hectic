package com.thechief.hectic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Sounds {
	
	private Sounds() {}
	
	public static Sound enemyHitGround, enemyHitGround1, meteorHitGround, meteorGoingDown, healthPickup;
	
	public static final void INIT() {
		enemyHitGround = Gdx.audio.newSound(Gdx.files.internal("enemyHitGround.ogg"));
		enemyHitGround1 = Gdx.audio.newSound(Gdx.files.internal("enemyHitGround1.ogg"));
		meteorHitGround = Gdx.audio.newSound(Gdx.files.internal("meteorHitGround.ogg"));
		meteorGoingDown = Gdx.audio.newSound(Gdx.files.internal("meteorGoingDown.ogg"));
		healthPickup = Gdx.audio.newSound(Gdx.files.internal("healthPickup.ogg"));
	}
	
	public static final void DISPOSE() {
		enemyHitGround.dispose();
		enemyHitGround1.dispose();
		meteorHitGround.dispose();
		healthPickup.dispose();
		meteorGoingDown.dispose();
	}
	
}
