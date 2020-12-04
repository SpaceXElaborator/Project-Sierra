package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Engine.GameLoop;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Entities.Player;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;

public class GamePanel extends GameLoop {

	private static final long serialVersionUID = -4583618417099095835L;
	private Handler handler = ProjectSierra.getLauncher().getHandler();
	
	public GamePanel() {
		setPreferredSize(new Dimension(1280, 720));
		
		Player p = new Player(new Location(200, 200), new ImageIcon(getClass().getResource("../Images/Untitled-1.png")));
		p.getVelocity().setDirection(Direction.RIGHT);
		handler.addGameElement(p);
		handler.setControlledEntity(p);
		new Thread(this).start();
		
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