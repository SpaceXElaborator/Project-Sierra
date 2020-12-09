package com.Archangels.ProjectSierra.Item.Weapons;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Item.Weapon;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public class Gun extends Weapon {

	public Gun(String s, ImageIcon j) {
		super(s, j);
	}

	public void onLeftClick() {
		Controllable cont = ProjectSierra.getLauncher().getHandler().getControlledEntity();
		Projectile p = new Projectile(((ImageIcon)ProjectSierra.getResources().getObject("Projectiles/Bullit.png")).getImage(), new Velocity(10, 0), cont.getLocation());
		//Projectile p = new Projectile(new ImageIcon(ProjectSierra.class.getResource("Images/Projectiles/Bullet.png")), new Velocity(10, 0), cont.getLocation());
		cont.fireProjectile(p);
	}

	public void onRightClick() {
		
	}

	public Location getLocation() {
		return null;
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		
	}
	
}