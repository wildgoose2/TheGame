package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject{
	
	private int direction = 0;
	private int size;
	
	private int old_x, old_y, old_grid_x, old_grid_y;
	private int length = 1;
	private int targetLength = 1;
	
	public Player(int x, int y, ID id, int size, Game game) {
		super(x, y, id, game);
		this.size = size;
		old_x = x;
		old_y = y;
		grid_x = x / game.SIZE;
		grid_y = y / game.SIZE;
	}

	public void tick() {
		switch(direction){
			case 0: y += size; grid_y++; break;
			case 1: x += size; grid_x++; break;
			case 2: y -= size; grid_y--; break;
			case 3: x -= size; grid_x--; break;
		}
		
		System.out.println("CHECK: " + game.getHandler().checkTile(grid_x, grid_y));
		System.out.println("Size: " + game.bodies.size());
		
		if(x > game.WIDTH || x < 0 || y > game.HEIGHT || y < 0 || game.getHandler().checkTile(grid_x, grid_y) == ID.PlayerBody)
			game.gameOver();
		
		if(game.getHandler().checkTile(grid_x, grid_y) == ID.Food)
		{
			Food food = (Food) game.getHandler().getTileObject(grid_x, grid_y);
			food.newLocation();
			targetLength++;
		}
			
			
		if(targetLength > length){
			game.bodies.add((PlayerBody) game.getHandler().addObject(new PlayerBody(old_grid_x, old_grid_y, ID.PlayerBody, game)));
			length++;
		}
		else
		{
			game.bodies.add((PlayerBody) game.getHandler().addObject(new PlayerBody(old_grid_x, old_grid_y, ID.PlayerBody, game)));
			game.removeLastBody();
		}
		
		old_x = x;
		old_y = y;
		old_grid_x = grid_x;
		old_grid_y = grid_y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOld_x() {
		return old_x;
	}

	public void setOld_x(int old_x) {
		this.old_x = old_x;
	}

	public int getOld_y() {
		return old_y;
	}

	public void setOld_y(int old_y) {
		this.old_y = old_y;
	}

	public int getOld_grid_x() {
		return old_grid_x;
	}

	public void setOld_grid_x(int old_grid_x) {
		this.old_grid_x = old_grid_x;
	}

	public int getOld_grid_y() {
		return old_grid_y;
	}

	public void setOld_grid_y(int old_grid_y) {
		this.old_grid_y = old_grid_y;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getTargetLength() {
		return targetLength;
	}

	public void setTargetLength(int targetLength) {
		this.targetLength = targetLength;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, size, size);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case 87: direction = 2; break;
			case 83: direction = 0; break;
			case 68: direction = 1; break;
			case 65: direction = 3; break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()){
		case 87: case 83:	velY = 0;
							break;
		case 68: case 65:	velX = 0;
							break;
	}
	}

}
