package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class ScreenText extends GameObject{
	
	private String text = "";

	public ScreenText(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString(text, x, y);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
