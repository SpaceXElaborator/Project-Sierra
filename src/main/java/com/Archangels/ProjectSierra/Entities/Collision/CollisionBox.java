package com.Archangels.ProjectSierra.Entities.Collision;

import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Entities.Entity;

public class CollisionBox {

	private Entity e;
	
	public CollisionBox(Entity e) {
		this.e = e;
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()/2) - ((e.getTexture().getIconWidth()/2)/2), (int)e.getLocation().getY() + (e.getTexture().getIconHeight()/2) + 60, e.getTexture().getIconWidth()/2, (e.getTexture().getIconHeight()/2) - 60);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()/2) - ((e.getTexture().getIconWidth()/2)/2), (int)e.getLocation().getY(), e.getTexture().getIconWidth()/2, e.getTexture().getIconHeight()/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()-5) - 5, (int)e.getLocation().getY() + 5, 5, e.getTexture().getIconHeight() - 10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)e.getLocation().getX() + 5, (int)e.getLocation().getY() + 5, 5, e.getTexture().getIconHeight() - 10);
	}
	
}