package com.Archangels.ProjectSierra.Entities;

import java.awt.Graphics;

import com.Archangels.ProjectSierra.Util.Location;

public abstract class Controllable extends Entity {

	private double movespeed = 5;
	
	public Controllable(Location loc) {
		super(loc);
	}
	
	public void update() {
		getLocation().setX(getLocation().getX() + getVelocity().getX());
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture().getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
	}
	
	public double getMoveSpeed() {
		return movespeed;
	}
	
	public void setMoveSpeed(double d) {
		movespeed = d;
	}
	
}