package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameLoop extends JPanel implements Runnable {

	private static final long serialVersionUID = 4758152417294442505L;
	private boolean isRunning;
	protected Handler handler;
	
	public GameLoop() {
		handler = new Handler();
		isRunning = true;
	}
	
	public void run() {
		double lastTime = System.nanoTime();
		double ticks = 60.0;
		double ns = 1000000000 / ticks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(isRunning) {
			double current = System.nanoTime();
			delta += (current - lastTime) / ns;
			lastTime = current;
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			repaint();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	public abstract void update();
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		render(g);
		g.dispose();
	}
	
	public abstract void render(Graphics g);
	
	public Handler getHandler() {
		return handler;
	}
	
}