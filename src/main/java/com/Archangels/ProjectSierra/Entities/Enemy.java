package com.Archangels.ProjectSierra.Entities;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Util.Location;

public abstract class Enemy extends Entity {

	public Enemy(Location loc, ImageIcon i) {
		super(loc, i);
	}
	
	public abstract void setTarget(EntityPlayer p);
	public abstract EntityPlayer getTarget();
	
}