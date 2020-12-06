package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;
import java.util.LinkedList;

import com.Archangels.ProjectSierra.Entities.Controllable;

public class Handler {

	private LinkedList<GameElement> objects = new LinkedList<GameElement>();
	private LinkedList<GameElement> controls = new LinkedList<GameElement>();
	private GameElement focus = null;
	private Camera cam = null;
	
	public void update() {
		if(cam != null) {
			cam.update();
		}
		
		for(GameElement gh : controls) {
			gh.update();
		}
		
		for(GameElement gh : objects) {
			gh.update();
		}
	}
	
	public void render(Graphics g) {
		if(cam != null) {
			for(GameElement gh : controls) {
				gh.render(g);
			}
			for(GameElement gh : objects) {
				//Location loc = gh.getLocation();
				//Location camLocTop = cam.getTopBounds();
				//Location camLocBottom = cam.getBottomBounds();
				
				gh.render(g);
			}
		}
	}
	
	public void addGameElement(GameElement ge) {
		if(ge instanceof Controllable) {
			controls.add(ge);
			return;
		}
		objects.add(ge);
	}
	
	public void removeGameElement(GameElement ge) {
		if(ge instanceof Controllable) {
			controls.remove(ge);
			return;
		}
		objects.remove(ge);
	}
	
	public void setControlledEntity(GameElement ge) {
		if(ge instanceof Controllable) {
			focus = ge;
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
	
	public GameElement getControlledEntity() {
		return focus;
	}
	
	public LinkedList<GameElement> getGameElements() {
		return objects;
	}
	
}