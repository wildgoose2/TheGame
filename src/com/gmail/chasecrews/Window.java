package com.gmail.chasecrews;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = 6340999710482198099L;
	
	public Window(int width, int height, String title, Game game){
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
	}
	public void run() {
		
	}

}
