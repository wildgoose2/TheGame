package com.gmail.chasecrews;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class GUIHandler {

	LinkedList<GUIObject> object = new LinkedList<GUIObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GUIObject obj = object.get(i);
			
			obj.tick();
		}
	}
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GUIObject obj = object.get(i);
			
			obj.render(g);
		}
	}
	
	public GUIObject addObject(GUIObject object){
		this.object.add(object);
		return object;
	}
	
	public GUIObject removeObject(GUIObject object){
		this.object.remove(object);
		return object;
	}
	
	public void clear()
	{
		object = new LinkedList<GUIObject>();
	}
}