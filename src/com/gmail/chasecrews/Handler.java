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
	
	public GameObject addObject(GameObject object){
		this.object.add(object);
		return object;
	}
	
	public GameObject removeObject(GameObject object){
		this.object.remove(object);
		return object;
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
	public ID checkTile(int grid_x, int grid_y)
	{
		for(int i = 0; i < object.size(); i++)
			if(object.get(i).getGrid_x() == grid_x && object.get(i).getGrid_y() == grid_y)
			{
				//System.out.println(object.get(i).getId());
				if(object.get(i).getId() != ID.Player)
					return object.get(i).getId();
			}
		
		return null;
	}
	public GameObject getTileObject(int grid_x, int grid_y)
	{
		for(int i = 0; i < object.size(); i++)
			if(object.get(i).getGrid_x() == grid_x && object.get(i).getGrid_y() == grid_y)
			{
				if(object.get(i).getId() != ID.Player)
					return object.get(i);
			}
		
		return null;
	}
	
	public void clear()
	{
		object = new LinkedList<GameObject>();
	}
	
}
