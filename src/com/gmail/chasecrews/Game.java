package com.gmail.chasecrews;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -621324396250590664L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH * 9/12;
	public static final String TITLE = "Wat";
	
	private Thread thread;
	private boolean running = false;
	
	public Game() {
		new Window(WIDTH, HEIGHT, TITLE, this);
	}
	
	public synchronized void start() {
		thread = new Thread();
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
	}
	
	public static void main(String args[]) {
		new Game();
	}

	
}
