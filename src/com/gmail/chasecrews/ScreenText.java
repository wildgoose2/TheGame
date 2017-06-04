package com.gmail.chasecrews;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class ScreenText extends GameObject{
	
	private String text;
	private Color color;

	public ScreenText(int x, int y, ID id, Game game) {
		super(x, y, id, game);
		this.text = "";
		this.color = Color.WHITE;
	}
	public ScreenText(int x , int y, ID id, Game game, String text, Color color){
		super(x, y , id, game);
		this.text = text;
		this.color = color;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
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
