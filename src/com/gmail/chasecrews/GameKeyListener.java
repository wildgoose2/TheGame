package com.gmail.chasecrews;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener{

	private Handler handler;
	private Game game;
	
	public GameKeyListener(Handler handler, Game game){
		System.out.println("new listener");
		this.handler = handler;
		this.game = game;
	}
	
	public void keyPressed(KeyEvent e) {
		handler.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		handler.keyReleased(e);
	}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'b')
			game.reset();
	}

}
