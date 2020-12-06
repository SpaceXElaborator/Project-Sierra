package com.Archangels.ProjectSierra.Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Window.PlayArea;

public class Handler {

	private LinkedList<GameElement> objects = new LinkedList<GameElement>();
	private LinkedList<GameElement> controls = new LinkedList<GameElement>();
	private GameElement focus = null;
	private Camera cam = null;
	private PlayArea pa = null;
	
	public void update() {
		if(cam != null) {
			cam.update();
		}
		
		if(pa != null) {
			pa.update();
		}
		
		for(GameElement gh : controls) {
			gh.update();
		}
		
		for(GameElement gh : objects) {
			gh.update();
		}
	}
	
	public void render(Graphics g) {
		if(ProjectSierra.isDebug()) {
			if(pa != null) {
				g.setColor(Color.WHITE);
				g.drawRect((int)pa.getTopBounds().getX(), (int)pa.getTopBounds().getY(), 30, 30);
				g.drawRect((int)pa.getBottomBounds().getX(), (int)pa.getBottomBounds().getY(), 30, 30);
			}
		}
		
		if(pa != null) {
			for(GameElement gh : controls) {
				gh.render(g);
			}
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
	
	public void setPlayArea(PlayArea pa) {
		this.pa = pa;
	}
	
	public GameElement getControlledEntity() {
		return focus;
	}
	
	public LinkedList<GameElement> getGameElements() {
		return objects;
	}
	
}