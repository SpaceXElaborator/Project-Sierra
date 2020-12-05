package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Block.BasicGround;
import com.Archangels.ProjectSierra.Engine.GameLoop;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Entities.EntityPlayer;
import com.Archangels.ProjectSierra.Entities.Player.Classes;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;

public class GamePanel extends GameLoop {

	private static final long serialVersionUID = -4583618417099095835L;
	private Handler handler = ProjectSierra.getLauncher().getHandler();
	
	public GamePanel() {
		setPreferredSize(new Dimension(1280, 720));

		EntityPlayer p = null;
		
		try {
			p = new EntityPlayer(new Location(200, 200), Classes.KNIGHT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.setDirection(Direction.RIGHT);
		handler.addGameElement(p);
		handler.setControlledEntity(p);
		new Thread(this).start();
		
		for(int i = 0; i < 1240; i += 40) {
			handler.addGameElement(new BasicGround(new Location(i, 680)));
		}
		
		for(int i = 0; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(0, i)));
		}
		
		for(int i = 0; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(1240, i)));
		}
		
		for(int i = 520; i < 700; i += 40) {
		handler.addGameElement(new BasicGround(new Location(40, i)));
		}
		
		for(int i = 520; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(80, i)));
		}
		
		for(int i = 520; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(120, i)));
		}
		
		handler.addGameElement(new BasicGround(new Location(280, 520)));
		
		handler.addGameElement(new BasicGround(new Location(40, 320)));
			
			
		
		
		this.setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void update() {
		handler.update();
	}
	
	@Override
	public void render(Graphics g) {
		Graphics2D test = (Graphics2D) g;
		
		// Background stuff here
		test.setColor(Color.BLACK);
		test.fillRect(0, 0, 1280, 720);
		test.drawRect(0, 0, 1280, 720);
		
		// Everything else
		handler.render(g);
		
		test.dispose();
	}
	
}