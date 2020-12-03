package com.Archangels.ProjectSierra.Entities;

import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Direction;

public interface ProjectileSource {
	
	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile);
	public <T extends Projectile> void fireProjectile(Class<? extends T> projectile, Direction dir);
	
}