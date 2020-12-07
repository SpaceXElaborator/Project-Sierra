package com.Archangels.ProjectSierra.Entities.Projectiles;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Entities.Entity;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class Projectile extends Entity implements GameElement {

	private Location loc;
	private Velocity vel;
	private ImageIcon icon;
	
	public Projectile(ImageIcon image, Velocity vel, Location loc) {
		super(loc, image);
		icon = image;
		this.vel = vel;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public Velocity getVelocity() {
		return vel;
	}
	
	public void setVelocity(Velocity v) {
		vel = v;
	}

	public void update() {
		loc.setX(loc.getX() + vel.getX());
		loc.setY(loc.getY() + vel.getY());
	}

	public void render(Graphics g) {
		g.drawImage(icon.getImage(), (int)loc.getX(), (int)loc.getY(), null);
	}

	
	
}