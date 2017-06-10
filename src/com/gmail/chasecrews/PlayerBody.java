package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class PlayerBody extends GameObject{

	public PlayerBody(int grid_x , int grid_y , ID id, Game game){
		super(grid_x * game.SIZE, grid_y * game.SIZE, id, game);
		super.setGrid_x(grid_x);
		super.setGrid_y(grid_y);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, game.SIZE, game.SIZE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
