package com.Archangels.ProjectSierra.Item.Weapons;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Item.Weapon;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class Gun extends Weapon {

	public Gun(String s, String j) {
		super(s, j);
	}

	public void onLeftClick() {
		Controllable cont = ProjectSierra.getLauncher().getHandler().getControlledEntity();
		
		Velocity v = null;
		
		if(cont.getVelocity().getDirection() == Direction.LEFT) {
			v = new Velocity(-10, 0);
		} else {
			v = new Velocity(10, 0);
		}
		
		Projectile p = new Projectile(((ImageIcon)ProjectSierra.getResources().getObject("Projectiles/Bullet.png")).getImage(), v, cont.getLocation());
		cont.fireProjectile(p);
	}

	public void onRightClick() {
		
	}

	public Location getLocation() {
		return null;
	}
	
}