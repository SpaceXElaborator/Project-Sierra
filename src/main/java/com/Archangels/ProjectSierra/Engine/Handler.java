package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;
import java.util.LinkedList;

import com.Archangels.ProjectSierra.Engine.CameraControl.Camera;
import com.Archangels.ProjectSierra.Engine.CameraControl.PlayArea;
import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.Entity;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Location;

public class Handler {

	// Stores any and all blocks/items that will be drawn to screen
	private LinkedList<GameElement> objects = new LinkedList<GameElement>();
	
	// Stores all controllable components (Must implement Controllable)
	private LinkedList<GameElement> controls = new LinkedList<GameElement>();
	
	// Stores all projectiles that will be created in the game (Must implement Projectile)
	private LinkedList<GameElement> projectiles = new LinkedList<GameElement>();
	
	// Stores all dead elements that will be removed from the above lists
	private LinkedList<GameElement> deadElements = new LinkedList<GameElement>();
	
	// What the player is currently controlling
	private Controllable focus = null;
	
	// The Camera object that moves with the player
	private Camera cam = null;
	
	// The area of which elements will be drawn in at
	private PlayArea pa = null;
	
	public void update() {
		if(cam != null) {
			cam.update();
		}
		
		if(pa != null) {
			pa.update();
		}
		
		// Find where the gameelement is stored in and delete it
		for(GameElement ge : deadElements) {
			if(objects.contains(ge)) objects.remove(ge);
			if(controls.contains(ge)) objects.remove(ge);
			if(projectiles.contains(ge)) objects.remove(ge);
		}
		
		for(GameElement gh : projectiles) {
			gh.update();
		}
		
		for(GameElement gh : controls) {
			gh.update();
		}
		
		for(GameElement gh : objects) {
			gh.update();
		}
	}
	
	public void render(Graphics g) {
		if(pa != null) {
			// Kill any projectile that floats off screen
			// TODO: Add a check for if it has collided with something
			for(GameElement gh : projectiles) {
				Location loc = gh.getLocation();
				Location tl = pa.getTopBounds();
				Location bl = pa.getBottomBounds();
				
				if(loc.getX() < tl.getX()) ((Entity) gh).kill();
				if(loc.getY() < tl.getY()) ((Entity) gh).kill();
				if(loc.getX() > bl.getX()) ((Entity) gh).kill();
				if(loc.getY() > bl.getY()) ((Entity) gh).kill();
				
				gh.render(g);
			}
			
			for(GameElement gh : controls) {
				gh.render(g);
			}
			
			// Render only the blocks that are within the play area. If they are not, don't worry about it
			for(GameElement gh : objects) {
				Location loc = gh.getLocation();
				Location tl = pa.getTopBounds();
				Location bl = pa.getBottomBounds();
				if(loc.getX() < tl.getX()) continue;
				if(loc.getY() < tl.getY()) continue;
				if(loc.getX() > bl.getX()) continue;
				if(loc.getY() > bl.getY()) continue;
				
				gh.render(g);
			}
		}
	}
	
	public void addGameElement(GameElement ge) {
		if(ge instanceof Projectile) {
			projectiles.add(ge);
			return;
		}
		if(ge instanceof Controllable) {
			controls.add(ge);
			return;
		}
		objects.add(ge);
	}
	
	public void removeGameElement(GameElement ge) {
		if(ge instanceof Projectile) {
			projectiles.remove(ge);
			return;
		}
		if(ge instanceof Controllable) {
			controls.remove(ge);
			return;
		}
		objects.remove(ge);
	}
	
	
	// Sets the object that the player is controlling
	public void setControlledEntity(GameElement ge) {
		if(ge instanceof Controllable) {
			focus = (Controllable)ge;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public void setCamera(Camera cam) {
		this.cam = cam;
	}
	
	public Camera getCamera() {
		return this.cam;
	}
	
	public void setPlayArea(PlayArea pa) {
		this.pa = pa;
	}
	
	public Controllable getControlledEntity() {
		return focus;
	}
	
	public LinkedList<GameElement> getGameElements() {
		return objects;
	}
	
}