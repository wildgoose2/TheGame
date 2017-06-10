package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Food extends GameObject{

	public Food(int grid_x, int grid_y, ID id, Game game) {
		super(grid_x * game.SIZE, grid_y * game.SIZE, id, game);
		super.setGrid_x(grid_x);
		super.setGrid_y(grid_y);
		newLocation();
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x + game.SIZE / 4, y + game.SIZE / 4, game.SIZE / 2, game.SIZE / 2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void newLocation()
	{
		Random random = new Random();
		int new_x = random.nextInt(game.GRID_X);
		int new_y = random.nextInt(game.GRID_Y);
		while(game.getHandler().checkTile(new_x, new_y) != null){
			new_x = random.nextInt(game.GRID_X);
			new_y = random.nextInt(game.GRID_Y);
		}
		super.setGrid_x(new_x);
		super.setGrid_y(new_y);
		super.setX(new_x * game.SIZE);
		super.setY(new_y * game.SIZE);
	}

}
