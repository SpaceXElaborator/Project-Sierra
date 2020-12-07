package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;

import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Util.Location;

public class Camera implements GameElement {

	private Controllable cont;
	private Location topBounds;
	
	public Camera(Controllable cont) {
		this.cont = cont;
		
		int x1 = (int) cont.getLocation().getX() - 576;
		int y1 = (int) (cont.getLocation().getY() - 540);
		
		topBounds = new Location(x1, y1);
	}
	
	public Controllable getPlayer() {
		return cont;
	}
	
	public Location getLocation() {
		return topBounds;
	}

	public void update() {
		int x = (int) ((-cont.getLocation().getX() - (cont.getTexture().getIconWidth()/2)) + 1280/2);
		int y = (int) (-cont.getLocation().getY() + 720/2);
		
		topBounds.setX(x);
		topBounds.setY(y);
	}

	public void render(Graphics g) {}
}