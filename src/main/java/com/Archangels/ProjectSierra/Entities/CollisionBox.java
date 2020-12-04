package com.Archangels.ProjectSierra.Entities;

import java.awt.Rectangle;

public class CollisionBox {

	private Entity e;
	
	public CollisionBox(Entity e) {
		this.e = e;
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()/2) - ((e.getTexture().getIconWidth()/2)/2), (int)e.getLocation().getY() + (e.getTexture().getIconHeight()/2), e.getTexture().getIconWidth()/2, e.getTexture().getIconHeight()/2);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()/2) - ((e.getTexture().getIconWidth()/2)/2), (int)e.getLocation().getY(), e.getTexture().getIconWidth()/2, e.getTexture().getIconHeight()/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getIconWidth()-5), (int)e.getLocation().getY() + 5, 5, e.getTexture().getIconHeight() - 10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)e.getLocation().getX(), (int)e.getLocation().getY() + 5, 5, e.getTexture().getIconHeight() - 10);
	}
	
}