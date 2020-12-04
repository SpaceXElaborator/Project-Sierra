package com.Archangels.ProjectSierra.Entities;

import com.Archangels.ProjectSierra.Util.Location;

public abstract class Enemy extends Entity {

	public Enemy(Location loc) {
		super(loc);
	}
	
	public abstract void setTarget(Player p);
	public abstract Player getTarget();
	
}