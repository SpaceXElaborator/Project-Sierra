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
		///Floor
		for(int i = 0; i < 1240; i += 40) {
			handler.addGameElement(new BasicGround(new Location(i, 680)));
		}
		//Left wall
		for(int i = 0; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(0, i)));
		}
		//Right Wall
		for(int i = 0; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(1240, i)));
		}
		//Far-Left Column
		for(int i = 520; i < 700; i += 40) {
		handler.addGameElement(new BasicGround(new Location(40, i)));
		}
		//Left-Middle column
		for(int i = 560; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(80, i)));
		}
		//Right-middle column 
		for(int i = 600; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(120, i)));
		}
		
		//Far right column
		for(int i = 640; i < 700; i += 40) {
			handler.addGameElement(new BasicGround(new Location(160, i)));
		}
		
		//Hanging single block on left wall
		handler.addGameElement(new BasicGround(new Location(40, 320)));
		
		//Middle left platform
		for(int i = 280; i < 400 ; i+=40) {
		handler.addGameElement(new BasicGround(new Location(i, 400)));
		}
		
		//Middle top platform 
		for(int i = 540; i < 660 ; i+=40) {
			handler.addGameElement(new BasicGround(new Location(i, 200)));
			}
		
		
		for(int i = 900; i < 1020 ; i+=40) {
			handler.addGameElement(new BasicGround(new Location(i, 400)));
			}
		
		
			
			
		
		
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