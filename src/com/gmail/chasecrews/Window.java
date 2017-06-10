package com.gmail.chasecrews;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 6340999710482198099L;
	
	public JFrame frame;
	
	public Window(int width, int height, String title, Game game){
		
		frame = new JFrame(title);
		
		KeyListener listener = new GameKeyListener(game.getHandler(), game);
		
		frame.addKeyListener(listener);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}
	public void run() {
		
	}
	
	public void tick(){
		frame.requestFocus();
	}

}
