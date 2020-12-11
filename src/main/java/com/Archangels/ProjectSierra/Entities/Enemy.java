package com.Archangels.ProjectSierra.Entities;

import java.awt.Image;

import com.Archangels.ProjectSierra.Util.Location;

// Will create the behavior of the Enemy's and what will be called to control them
public abstract class Enemy extends Entity {

	public Enemy(Location loc, Image i) {
		super(loc, i);
	}
	
	public abstract void setTarget(EntityPlayer p);
	public abstract EntityPlayer getTarget();
	
}