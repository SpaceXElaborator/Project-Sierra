package com.Archangels.ProjectSierra.Engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.Entity;
import com.Archangels.ProjectSierra.Util.Direction;

public class GameKeyListener extends KeyAdapter {

	private Handler handler;
	
	public GameKeyListener(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(handler.getControlledEntity() != null) {
			Controllable ent = (Controllable) handler.getControlledEntity();
			if(key == KeyEvent.VK_RIGHT) {
				ent.getVelocity().setDirection(Direction.RIGHT);
				ent.getVelocity().setX(5);
			}
			
			if(key == KeyEvent.VK_LEFT) {
				ent.getVelocity().setDirection(Direction.LEFT);
				ent.getVelocity().setX(-5);
			}
			
//			if(key == KeyEvent.VK_X) {
//				if(ent instanceof Player) {
//					Player p = (Player)ent;
//					p.teleport();
//				}
//			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(handler.getControlledEntity() != null) {
			Entity ent = (Entity) handler.getControlledEntity();
			if(key == KeyEvent.VK_RIGHT) {
				ent.getVelocity().setX(0);
				
			}
			
			if(key==KeyEvent.VK_LEFT) {
				ent.getVelocity().setX(0);
			}
		}
	}

}