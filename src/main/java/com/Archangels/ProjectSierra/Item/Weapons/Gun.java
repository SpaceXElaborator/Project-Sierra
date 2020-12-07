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
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onLeftClick() {
		Controllable cont = ProjectSierra.getLauncher().getHandler().getControlledEntity();
		Projectile p = new Projectile(new ImageIcon(ProjectSierra.class.getResource("Images/Projectiles/Bullet.png")), new Velocity(10, 0), cont.getLocation());
		cont.fireProjectile(p);
	}

	@Override
	public void onRightClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Location getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	
}