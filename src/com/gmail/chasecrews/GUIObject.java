package com.gmail.chasecrews;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class GUIObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected Game game;
	
	public GUIObject(int x, int y, ID id, Game game){
		this.x = x;
		this.y = y;
		this.id = id;
		this.game = game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);

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

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	
	
}
