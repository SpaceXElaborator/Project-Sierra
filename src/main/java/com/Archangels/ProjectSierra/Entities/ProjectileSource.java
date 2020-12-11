package com.Archangels.ProjectSierra.Entities;

import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Velocity;

public interface ProjectileSource {
	
	// Fires a projectile at a default velocity (Will be a speed of 1)
	public <T extends Projectile> void fireProjectile(T projectile);
	
	// Fires a projectile at the given velocity
	public <T extends Projectile> void fireProjectile(T projectile, Velocity vel);
	
}