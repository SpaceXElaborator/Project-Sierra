package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;

import com.Archangels.ProjectSierra.Util.Location;

public interface GameElement {
	
	// Represents the X/Y points of the game element
	public Location getLocation();
	
	// What will be changed on each iteration of the game clock
	public void update();
	
	// What will be drawn to screen for each iteration of the game clock's render function
	public void render(Graphics g);
	
}