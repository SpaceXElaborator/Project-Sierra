package com.Archangels.ProjectSierra.Engine.CameraControl;

import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Util.Location;

public class PlayArea {

	private Controllable cont;
	private Location topBounds;
	private Location bottomBounds;
	
	public PlayArea(Controllable cont) {
		this.cont = cont;
		
		topBounds = new Location(0, 0);
		bottomBounds = new Location(0, 0);
	}
	
	public Location getTopBounds() {
		return topBounds;
	}
	
	public Location getBottomBounds() {
		return bottomBounds;
	}
	
	public void update() {
		double x1 = cont.getLocation().getX() - (1280/2);
		double y1 = cont.getLocation().getY() - ((720/2) + 100);
		
		double x2 = cont.getLocation().getX() + (1280/2);
		double y2 = cont.getLocation().getY() + ((720/2) + 100);
		
		topBounds.setX(x1);
		topBounds.setY(y1);
		
		bottomBounds.setX(x2);
		bottomBounds.setY(y2);
	}
	
}