package com.Archangels.ProjectSierra.Entities;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Util.Location;

public class Player extends Controllable {

	public Player(Location loc, ImageIcon i) {
		super(loc);
		setTexture(i);
	}

	public void update(double elapsed) {
		
	}

	public void render(Graphics g) {
		
	}
	
}