package com.Archangels.ProjectSierra.Engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.EntityPlayer;
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
				if(!ent.isJumping()) {
					ent.setDirection(Direction.RIGHT);
					ent.getVelocity().setX(ent.getMoveSpeed());
				}
			}
			
			if(key == KeyEvent.VK_LEFT) {
				if(!ent.isJumping()) {
					ent.setDirection(Direction.LEFT);
					ent.getVelocity().setX(-ent.getMoveSpeed());
				}
			}
			
			if(key == KeyEvent.VK_SPACE) {
				if(!ent.isJumping()) {
					ent.setJumping(true);
					ent.getVelocity().setY(-15);
				}
			}
			
			if(key == KeyEvent.VK_X) {
				if(ent instanceof  EntityPlayer) {
					EntityPlayer p = (EntityPlayer)ent;
					p.teleport();
				}
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(handler.getControlledEntity() != null) {
			Controllable ent = (Controllable) handler.getControlledEntity();
			
			if(key == KeyEvent.VK_RIGHT) {
				if(!ent.isJumping())
					ent.getVelocity().setX(0);
			}
			
			if(key==KeyEvent.VK_LEFT) {
				if(!ent.isJumping())
					ent.getVelocity().setX(0);
			}
		}
	}

}