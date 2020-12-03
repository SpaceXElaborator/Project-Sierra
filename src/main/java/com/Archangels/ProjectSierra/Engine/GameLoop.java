package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameLoop extends JPanel implements Runnable {

	private static final long serialVersionUID = 4758152417294442505L;
	private boolean isRunning;
	
	public GameLoop() {
		isRunning = true;
	}
	
	public void run() {
		double lastTime = System.currentTimeMillis();
		while(isRunning) {
			double current = System.currentTimeMillis();
			double elapsed = current-lastTime;
			update(elapsed);
			repaint();
			lastTime = current;
		}
	}
	
	public abstract void update(double elapsed);
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
	}
	
	public abstract void render(Graphics g);
	
}