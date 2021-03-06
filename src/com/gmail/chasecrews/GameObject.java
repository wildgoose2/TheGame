package com.gmail.chasecrews;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class GameObject {

	protected int x, y;
	protected ID id;
	protected int velX, velY;
	protected Game game;
	protected int grid_x, grid_y;
	
	public GameObject(int x, int y, ID id, Game game){
		this.x = x;
		this.y = y;
		this.id = id;
		this.game = game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);

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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getGrid_x() {
		return grid_x;
	}

	public void setGrid_x(int grid_x) {
		this.grid_x = grid_x;
	}

	public int getGrid_y() {
		return grid_y;
	}

	public void setGrid_y(int grid_y) {
		this.grid_y = grid_y;
	}

	
	
}
