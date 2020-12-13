package com.Archangels.ProjectSierra.Block;

import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Util.Location;

public abstract class Block implements GameElement {
	
	private Location loc;
	private int x;
	private int y;
	private Rectangle collision;
	
	public Block(Location loc, int x, int y) {
		this.loc = loc;
		this.x = x;
		this.y = y;
		collision = new Rectangle((int)loc.getX(), (int)loc.getY(), x, y);
	}
	
	public int getWidth() {
		return x;
	}
	
	public int getHeight() {
		return y;
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public Rectangle getCollision() {
		return collision;
	}
	
	// Whether or not the block can be passed through using 'S' or if it can be jumped through from below
	public abstract boolean isPassable();
	
	// Whether or not the player can walk on the object
	public abstract boolean walkable();
	
}