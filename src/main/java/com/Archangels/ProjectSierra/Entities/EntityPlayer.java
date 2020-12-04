package com.Archangels.ProjectSierra.Entities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Entities.Player.Classes;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class EntityPlayer extends Controllable implements ProjectileSource {
	
	private Classes playerClass;
	
	public EntityPlayer(Location loc, Classes c) {
		super(loc);
		playerClass = c;
		
		ImageIcon icon = null;
		BufferedImage img;
		try {
			img = ImageIO.read(getClass().getResource(c.getImage()));
			Image dimb = img.getScaledInstance(64, 128, Image.SCALE_SMOOTH);
			icon = new ImageIcon(dimb);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setTexture(icon);
	}
	
	public void teleport() {
		if(getVelocity().getDirection() == null) return;
		if(getVelocity().getDirection() == Direction.LEFT) getLocation().setX(getLocation().getX() - 60);
		if(getVelocity().getDirection() == Direction.RIGHT) getLocation().setX(getLocation().getX() + 60);
	}

	public Classes getPlayerClass() {
		return playerClass;
	}
	
	@Override
	public void createCollisionBox() {
		// TODO Auto-generated method stub
		
	}

	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile) {
		// TODO Auto-generated method stub
		
	}

	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile, Velocity dir) {
		// TODO Auto-generated method stub
		
	}
	
}