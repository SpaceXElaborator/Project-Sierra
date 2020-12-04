package com.Archangels.ProjectSierra.Engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Archangels.ProjectSierra.Entities.Entity;

public class GameKeyListener extends KeyAdapter {

	private Handler handler;
	
	public GameKeyListener(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(handler.getControlledEntity() != null) {
			Entity ent = (Entity) handler.getControlledEntity();
			if(key == KeyEvent.VK_RIGHT) {
				ent.getDirection().setX(5);
			}
			
			if(key == KeyEvent.VK_LEFT) {
				ent.getDirection().setX(-5);
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(handler.getControlledEntity() != null) {
			Entity ent = (Entity) handler.getControlledEntity();
			if(key == KeyEvent.VK_RIGHT) {
				ent.getDirection().setX(0);
			}
			
			if(key==KeyEvent.VK_LEFT) {
				ent.getDirection().setX(0);
			}
		}
	}

}