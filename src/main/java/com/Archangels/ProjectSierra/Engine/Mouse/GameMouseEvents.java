package com.Archangels.ProjectSierra.Engine.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.Archangels.ProjectSierra.Util.Location;

public class GameMouseEvents implements MouseMotionListener {

	private Location loc;
	
	public void mouseDragged(MouseEvent e) {
		
	}

	public void mouseMoved(MouseEvent e) {
		loc = new Location(e.getX(), e.getY());
	}
	
	public Location getMouseLoc() {
		return loc;
	}
	
}