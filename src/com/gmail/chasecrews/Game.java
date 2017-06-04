package com.gmail.chasecrews;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -621324396250590664L;
	
	public static final int SIZE = 20;
	public static final int GRID_X = 20, GRID_Y = 20;
	
	public static final int WIDTH = SIZE * GRID_X, HEIGHT = SIZE * GRID_Y;
	public static final String TITLE = "Wat";
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Window window;
	
	private Player p;
	private ScreenText text;
	private int score = 0;
	
	public int[][] grid = new int[GRID_X][GRID_Y];
			
	public Game() {
		handler = new Handler();
		
		window = new Window(WIDTH, HEIGHT, TITLE, this);
		
		p = new Player(0, 0, ID.Player, SIZE, this);
		handler.addObject(p);
		text = (ScreenText) handler.addObject(new ScreenText(10, 10, ID.GUI, this, "0", Color.WHITE));
		
	}
	
	public synchronized void start() {
		System.out.println("start");
		thread = new Thread(this);
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
		System.out.println("run");
		long lastTime = System.nanoTime();
		double amountOfTicks = 10.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running)
					render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		stop();
	}
	
	private void tick(){
		handler.tick();
		window.tick();
	}
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	public static void main(String args[]) {
		System.out.println("main");
		new Game();
	}
	
	public Handler getHandler(){
		return handler;
	}
	
	public void gameOver()
	{
		ScreenText text = new ScreenText(WIDTH / 2, HEIGHT / 2, ID.GUI, this, "Game Over", Color.RED);
		handler.addObject(text);
		handler.render(this.getGraphics());
		running = false;
	}
}
