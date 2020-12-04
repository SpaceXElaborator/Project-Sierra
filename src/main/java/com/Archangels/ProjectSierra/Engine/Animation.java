package com.Archangels.ProjectSierra.Engine;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int frames;
	
	private int index = 0;
	
	// What frame we are on
	private int count = 0;
	
	private BufferedImage[] images;
	private BufferedImage currentImg;
	
	public Animation(int speed, BufferedImage... args) {
		this.speed = speed;
		images = new BufferedImage[args.length];
		for(int i = 0; i < args.length; i++) {
			images[i] = args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation() {
		index++;
		if(index > speed) {
			index = 0;
			nextFrame();
		}
	}
	
	private void nextFrame() {
		for(int i = 0; i < frames; i++) {
			if(count == i)
				currentImg = images[i];
		}
		
		count++;
		
		// Repeat animation once done
		if(count > frames)
			count = 0;
	}
	
	public void drawAnimation(Graphics g, int x, int y) {
		drawAnimation(g, x, y, 1, 1);
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY) {
		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
	}
	
}