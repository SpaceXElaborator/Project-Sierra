package com.Archangels.ProjectSierra.Block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Util.Location;

public class PassableBlock extends Block {

	private Location loc;
	private Rectangle collision;
	
	public PassableBlock(Location loc) {
		this.loc = loc;
		collision = new Rectangle((int)loc.getX(), (int)loc.getY(), 40, 15);
	}
	
	public Location getLocation() {
		return loc;
	}
	
	public Rectangle getCollision() {
		return collision;
	}
	
	public void update() {}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D)g;
		g2d.draw(collision);
	}

	public boolean isPassable() {
		return true;
	}
	
}