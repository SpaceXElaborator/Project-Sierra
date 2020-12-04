package com.Archangels.ProjectSierra.Entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;

public class Player extends Controllable {
	
	public Player(Location loc, ImageIcon i) {
		super(loc);
		setTexture(i);
	}

	public void update() {
		getLocation().setX(getLocation().getX() + getVelocity().getX());
	}

	public void render(Graphics g) {
		g.drawImage(getTexture().getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
	}
	
	public void teleport() {
		if(getVelocity().getDirection() == null) return;
		if(getVelocity().getDirection() == Direction.LEFT) getLocation().setX(getLocation().getX() - 20);
		if(getVelocity().getDirection() == Direction.RIGHT) getLocation().setX(getLocation().getX() + 20);
	}
	
}