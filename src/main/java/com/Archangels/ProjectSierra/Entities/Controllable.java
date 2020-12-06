package com.Archangels.ProjectSierra.Entities;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Engine.Camera;
import com.Archangels.ProjectSierra.Util.Location;

public abstract class Controllable extends Entity {

	private double movespeed = 5;
	private Camera camera;
	
	public Controllable(Location loc, ImageIcon i) {
		super(loc, i);
		camera = new Camera(this);
	}
	
	public double getMoveSpeed() {
		return movespeed;
	}
	
	public void setMoveSpeed(double d) {
		movespeed = d;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
}