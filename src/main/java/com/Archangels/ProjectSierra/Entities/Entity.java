package com.Archangels.ProjectSierra.Entities;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Util.Velocity;
import com.Archangels.ProjectSierra.Util.Location;

public abstract class Entity implements GameElement {

	private Location loc;
	private Velocity dir;
	private ImageIcon i;
	
	public Entity(Location loc) {
		this.loc = loc;
		this.dir = new Velocity(0, 0);
	}
	
	public void setTexture(ImageIcon i) {
		this.i = i;
	}
	
	public ImageIcon getTexture() {
		return this.i;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return this.loc;
	}
	
	public Velocity getVelocity() {
		return dir;
	}
	
}