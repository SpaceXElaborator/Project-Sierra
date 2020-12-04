package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;
import java.util.LinkedList;

import com.Archangels.ProjectSierra.Entities.Controllable;

public class Handler {

	private LinkedList<GameElement> objects = new LinkedList<GameElement>();
	private LinkedList<GameElement> controls = new LinkedList<GameElement>();
	private GameElement focus = null;
	
	public void update() {
		for(GameElement gh : controls) {
			gh.update();
		}
		for(GameElement gh : objects) {
			gh.update();
		}
	}
	
	public void render(Graphics g) {
		for(GameElement gh : controls) {
			gh.render(g);
		}
		for(GameElement gh : objects) {
			gh.render(g);
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
	
	public GameElement getControlledEntity() {
		return focus;
	}
	
}