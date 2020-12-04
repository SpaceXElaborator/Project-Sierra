package com.Archangels.ProjectSierra.Entities;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Util.Location;

public abstract class Controllable extends Entity {

	private double movespeed = 5;
	
	public Controllable(Location loc, ImageIcon i) {
		super(loc, i);
	}
	
	public double getMoveSpeed() {
		return movespeed;
	}
	
	public void setMoveSpeed(double d) {
		movespeed = d;
	}
	
}