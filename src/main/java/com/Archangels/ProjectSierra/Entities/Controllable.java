package com.Archangels.ProjectSierra.Entities;

import java.awt.Image;

import com.Archangels.ProjectSierra.Engine.CameraControl.Camera;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

// A class to represent player controlled objects and how they function
public abstract class Controllable extends Entity implements ProjectileSource {

	private double movespeed = 5;
	private Camera camera;
	
	public Controllable(Location loc, Image i) {
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
	
	public <T extends Projectile> void fireProjectile(T projectile) {
		projectile.setLocation(new Location(getLocation().getX(), getLocation().getY()));
		getHandler().addGameElement(projectile);
	}

	public <T extends Projectile> void fireProjectile(T projectile, Velocity dir) {
		
	}
	
}