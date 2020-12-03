package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.Archangels.ProjectSierra.Engine.GameLoop;

public class GamePanel extends GameLoop {

	private static final long serialVersionUID = -4583618417099095835L;
	
	public GamePanel() {
		this.requestFocus();
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBackground(Color.WHITE);
		
		new Thread(this).start();
	}

	@Override
	public void update(double elapsed) {
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D test = (Graphics2D) g;
		
		test.dispose();
	}
	
}