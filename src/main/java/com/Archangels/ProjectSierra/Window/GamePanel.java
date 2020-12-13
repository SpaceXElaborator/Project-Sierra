package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Engine.GameLoop;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Engine.CameraControl.PlayArea;
import com.Archangels.ProjectSierra.Engine.Mouse.GameMouseEvents;
import com.Archangels.ProjectSierra.Engine.Mouse.GameMouseListener;
import com.Archangels.ProjectSierra.Entities.EntityPlayer;
import com.Archangels.ProjectSierra.Entities.Player.Classes;
import com.Archangels.ProjectSierra.Item.Weapons.Sword_1;
import com.Archangels.ProjectSierra.Levels.TestLevel;
import com.Archangels.ProjectSierra.Util.Location;

public class GamePanel extends GameLoop {

	private static final long serialVersionUID = -4583618417099095835L;
	private Handler handler = ProjectSierra.getLauncher().getHandler();
	private GameMouseEvents gme = new GameMouseEvents();
	
	public GamePanel() {
		registerDefaultKeys();
		setPreferredSize(new Dimension(1280, 720));
		setFocusable(true);
		
		new TestLevel(handler);
		
		EntityPlayer p = new EntityPlayer(new Location(200, 200), Classes.KNIGHT);

		//Gun g = new Gun("Gun", (ImageIcon)ProjectSierra.getResources().getObject("Blocks/stone.png"));
		Sword_1 g = new Sword_1("Short Sword");
		p.setMainHand(g);

		handler.setCamera(p.getCamera());
		handler.setPlayArea(new PlayArea(p));
		handler.addGameElement(p);
		handler.setControlledEntity(p);
		
		addMouseMotionListener(gme);
		addMouseListener(new GameMouseListener());
		new Thread(this).start();

		setFocusTraversalKeysEnabled(false);
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
		test.translate(handler.getCamera().getLocation().getX(), handler.getCamera().getLocation().getY());
		handler.render(g);
		test.translate(-handler.getCamera().getLocation().getX(), -handler.getCamera().getLocation().getY());
	}
	
	private void registerDefaultKeys() {
		Iterator<Entry<String, Action>> it = ProjectSierra.getKeyBindings().getKeyBindings().entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Action> pair = (Map.Entry<String, Action>)it.next();
			String s = pair.getKey();
			Action a = pair.getValue();
			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(s), s);
			getActionMap().put(s, a);
		}
	}

}