package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	public LinkedList<GameElement> objects = new LinkedList<GameElement>();
	
	public void update(double elapsed) {
		for(GameElement gh : objects) {
			gh.update(elapsed);
		}
	}
	
	public void render(Graphics g) {
		for(GameElement gh : objects) {
			gh.render(g);
		}
	}
	
	public void addGameElement(GameElement ge) {
		objects.add(ge);
	}
	
	public void removeGameElement(GameElement ge) {
		objects.remove(ge);
	}
	
}