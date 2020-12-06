package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;

import com.Archangels.ProjectSierra.Util.Location;

public interface GameElement {
	
	public Location getLocation();
	public void update();
	public void render(Graphics g);
	
}