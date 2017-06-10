package com.gmail.chasecrews;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -621324396250590664L;
	
	public final int SIZE = 20;
	public final int GRID_X = 20, GRID_Y = 20;
	
	public final int WIDTH = SIZE * GRID_X + SIZE;

	public final int HEIGHT = SIZE * GRID_Y + SIZE;
	public static final String TITLE = "Wat";
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private GUIHandler gHandler;
	private Window window;
	
	private Player p;
	private ScreenText text;
	private int score = 0;
	
	public List<PlayerBody> bodies = new ArrayList<PlayerBody>();
			
	public Game() {
		handler = new Handler();
		gHandler = new GUIHandler();
		
		window = new Window(WIDTH, HEIGHT, TITLE, this);
		
		p = new Player(0, 0, ID.Player, SIZE, this);
		handler.addObject(p);
		handler.addObject(new Food(0,0, ID.Food, this));
		text = (ScreenText) gHandler.addObject(new ScreenText(10, 10, ID.GUI, this, "0", Color.WHITE));
		
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
		long tick_lastTime = System.nanoTime();
		long frame_lastTime = System.nanoTime();
		double amountOfTicks = 10.0;
		double amountOfFrames = 60.0;
		double tick_ns = 1000000000 / amountOfTicks;
		double frame_ns = 1000000000 / amountOfFrames;
		double tick_delta = 0;
		double frame_delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			
			long now = System.nanoTime();
			tick_delta += (now - tick_lastTime) / tick_ns;
			tick_lastTime = now;
			
			while(tick_delta >= 1){
				tick();
				tick_delta--;
			}
			
			if(running)
			{
				now = System.nanoTime();
				frame_delta += (now - frame_lastTime) / frame_ns;
				frame_lastTime = now;
				
				while(frame_delta >= 1){
					render();
					frame_delta--;
					frames++;
				}
			}
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		
		stop();
	}
	
	private void tick(){
		handler.tick();
		gHandler.tick();
		window.tick();
		text.setText("Grid X: " + p.getGrid_x() + " Grid Y: " + p.getGrid_y());
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
		gHandler.render(g);
		
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
	public GUIHandler getGUIHandler(){
		return gHandler;
	}
	
	public void gameOver()
	{
		ScreenText text = new ScreenText(WIDTH / 2, HEIGHT / 2, ID.GUI, this, "Game Over", Color.RED);
		gHandler.addObject(text);
		gHandler.render(this.getGraphics());
		gHandler.removeObject(text);
		stop();
	}
	public void reset()
	{
		if(!running)
		{
			gHandler.clear();
			handler.clear();
			p = new Player(0, 0, ID.Player, SIZE, this);
			handler.addObject(p);
			handler.addObject(new Food(0,0, ID.Food, this));
			text = (ScreenText) gHandler.addObject(new ScreenText(10, 10, ID.GUI, this, "0", Color.WHITE));
			start();
		}
	}
	
	public void removeLastBody()
	{
		handler.removeObject(bodies.get(0));
		bodies.remove(0);
	}
}
