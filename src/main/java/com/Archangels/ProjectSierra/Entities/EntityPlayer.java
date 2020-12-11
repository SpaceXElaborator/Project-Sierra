package com.Archangels.ProjectSierra.Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Entities.Player.Classes;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;

public class EntityPlayer extends Controllable {
	
	private Classes playerClass;
	
	// Get the image from the ImageBundler and scale to play size
	public EntityPlayer(Location loc, Classes c) {
		super(loc, ((ImageIcon)ProjectSierra.getResources().getObject(c.getImage())).getImage().getScaledInstance(64, 128, Image.SCALE_SMOOTH));
		playerClass = c;
	}
	
	public void teleport() {
		if(getVelocity().getDirection() == null) return;
		if(getVelocity().getDirection() == Direction.LEFT) getLocation().setX(getLocation().getX() - 60);
		if(getVelocity().getDirection() == Direction.RIGHT) getLocation().setX(getLocation().getX() + 60);
	}

	public Classes getPlayerClass() {
		return playerClass;
	}
	
}