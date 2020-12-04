package com.Archangels.ProjectSierra.Entities;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class Player extends Controllable implements ProjectileSource {
	
	public Player(Location loc, ImageIcon i) {
		super(loc);
		setTexture(i);
	}
	
	public void teleport() {
		if(getVelocity().getDirection() == null) return;
		if(getVelocity().getDirection() == Direction.LEFT) getLocation().setX(getLocation().getX() - 60);
		if(getVelocity().getDirection() == Direction.RIGHT) getLocation().setX(getLocation().getX() + 60);
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