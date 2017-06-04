package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject{
	
	private int direction = 0;
	private int size;
	
	private int length = 1;
	
	public Player(int x, int y, ID id, int size, Game game) {
		super(x, y, id, game);
		this.size = size;
	}

	public void tick() {
		switch(direction){
			case 0: y += size; break;
			case 1: x += size; break;
			case 2: y -= size; break;
			case 3: x -= size; break;
		}
		
		if(x > game.WIDTH || x < 0 || y > game.HEIGHT || y < 0)
			game.gameOver();
		
		
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
