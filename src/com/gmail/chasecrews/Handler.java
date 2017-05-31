package com.gmail.chasecrews;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject obj = object.get(i);
			
			obj.tick();
		}
	}
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject obj = object.get(i);
			
			obj.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void keyPressed(KeyEvent e) {
		for(int i = 0; i < object.size(); i++){
			GameObject obj = object.get(i);
			
			obj.keyPressed(e);
		}
	}
	public void keyReleased(KeyEvent e) {
		for(int i = 0; i < object.size(); i++){
			GameObject obj = object.get(i);
			
			obj.keyReleased(e);
		}
	}
}
