package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject{

	private static final int MAX_VEL_Y = 5, MAX_VEL_X = 5;
	private static final int STEP_VEL_Y = 5, STEP_VEL_X = 5;
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 50, 50);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case 87:	if(Math.abs(velY) + STEP_VEL_Y <= MAX_VEL_Y) velY -= STEP_VEL_Y;
						break;
			case 83:	if(Math.abs(velY) + STEP_VEL_Y <= MAX_VEL_Y) velY += STEP_VEL_Y;
						break;
			case 68:	if(Math.abs(velX) + STEP_VEL_X <= MAX_VEL_X) velX += STEP_VEL_X;
						break;
			case 65:	if(Math.abs(velX) + STEP_VEL_X <= MAX_VEL_X) velX -= STEP_VEL_X;
						break;
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
