package com.Archangels.ProjectSierra.Item;

public abstract class Weapon extends Item implements Usable {

	private boolean ammo;
	
	public Weapon(String s, String j) {
		super(s, j);
	}

	public void requiresAmmo(boolean b) {
		ammo = b;
	}
	
	public boolean requiresAmmo() {
		return ammo;
	}
	
}