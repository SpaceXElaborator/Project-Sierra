package com.Archangels.ProjectSierra.Util;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Engine.KeyBindings;
import com.Archangels.ProjectSierra.Entities.Controllable;

public class DefaultKeyBindings {

	private Handler handler;
	
	public DefaultKeyBindings(Handler handler) {
		KeyBindings kb = ProjectSierra.getKeyBindings();
		this.handler = handler;
		
		kb.addKeyBinding("A", moveLeft());
		kb.addKeyBinding("D", moveRight());
		kb.addKeyBinding("released A", stopLeft());
		kb.addKeyBinding("released D", stopRight());
		kb.addKeyBinding("SPACE", jump());
	}
	
	Action moveLeft() {
		return new AbstractAction() {
			private static final long serialVersionUID = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handler.getControlledEntity() != null) {
					Controllable con = (Controllable)handler.getControlledEntity();
					con.setDirection(Direction.LEFT);
					con.getVelocity().setX(-con.getMoveSpeed());
				}
			}
		};
	}
	
	Action moveRight() {
		return new AbstractAction() {
			private static final long serialVersionUID = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handler.getControlledEntity() != null) {
					Controllable con = (Controllable)handler.getControlledEntity();
					con.setDirection(Direction.RIGHT);
					con.getVelocity().setX(con.getMoveSpeed());
				}
			}
		};
	}
	
	Action stopRight() {
		return new AbstractAction() {
			private static final long serialVersionUID = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handler.getControlledEntity() != null) {
					Controllable con = (Controllable)handler.getControlledEntity();
					if(con.getVelocity().getX() < 0) return;
					con.getVelocity().setX(0);
				}
			}
		};
	}
	
	Action stopLeft() {
		return new AbstractAction() {
			private static final long serialVersionUID = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handler.getControlledEntity() != null) {
					Controllable con = (Controllable)handler.getControlledEntity();
					if(con.getVelocity().getX() > 0) return;
					con.getVelocity().setX(0);
				}
			}
		};
	}
	
	Action jump() {
		return new AbstractAction() {
			private static final long serialVersionUID = -1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(handler.getControlledEntity() != null) {
					Controllable con = (Controllable)handler.getControlledEntity();
					if(con.isJumping() || con.isFalling()) return;
					con.setJumping(true);
					con.getVelocity().setY(-15);
				}
			}
		};
	}
	
}