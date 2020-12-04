package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.Archangels.ProjectSierra.Engine.GameLoop;
import com.Archangels.ProjectSierra.Engine.Handler;

public class GamePanel extends GameLoop {

	private static final long serialVersionUID = -4583618417099095835L;
	private Handler handler;
	
	public GamePanel() {
		handler = new Handler();
		
		this.requestFocus();
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBackground(Color.WHITE);
		
		new Thread(this).start();
	}

	@Override
	public void update(double elapsed) {
		handler.update(elapsed);
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D test = (Graphics2D) g;
		
		// Background stuff here
		
		// Everything else
		handler.render(g);
		
		test.dispose();
	}
	
}