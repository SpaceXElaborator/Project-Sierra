package com.Archangels.ProjectSierra.Entities.Collision;

import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Entities.Entity;

public class CollisionBox {

	private Entity e;
	
	public CollisionBox(Entity e) {
		this.e = e;
	}
	
	public Rectangle getBoundsBottom() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getWidth(null)/2) - ((e.getTexture().getWidth(null)/2)/2), (int)e.getLocation().getY() + (e.getTexture().getHeight(null)/2) + 60, e.getTexture().getWidth(null)/2, (e.getTexture().getHeight(null)/2) - 60);
	}
	
	public Rectangle getBoundsTop() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getWidth(null)/2) - ((e.getTexture().getWidth(null)/2)/2), (int)e.getLocation().getY(), e.getTexture().getWidth(null)/2, e.getTexture().getHeight(null)/2);
	}
	
	public Rectangle getBoundsRight() {
		return new Rectangle((int)e.getLocation().getX() + (e.getTexture().getWidth(null)-5) - 5, (int)e.getLocation().getY() + 5, 5, e.getTexture().getHeight(null) - 10);
	}
	
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)e.getLocation().getX() + 5, (int)e.getLocation().getY() + 5, 5, e.getTexture().getHeight(null) - 10);
	}
	
}