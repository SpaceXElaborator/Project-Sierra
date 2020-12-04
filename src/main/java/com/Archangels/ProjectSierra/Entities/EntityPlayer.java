package com.Archangels.ProjectSierra.Entities;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Entities.Player.Classes;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class EntityPlayer extends Controllable implements ProjectileSource {
	
	private Classes playerClass;
	
	public EntityPlayer(Location loc, Classes c) throws IOException {
		super(loc, new ImageIcon(ImageIO.read(ProjectSierra.class.getResource(c.getImage())).getScaledInstance(64, 128, Image.SCALE_SMOOTH)));
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

	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile) {
		// TODO Auto-generated method stub
		
	}

	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile, Velocity dir) {
		// TODO Auto-generated method stub
		
	}
	
}