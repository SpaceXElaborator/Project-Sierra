package com.Archangels.ProjectSierra.Block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Util.Location;

public class BackgroundBlock extends Block{

	public BackgroundBlock(Location loc, int x, int y) {
		super(loc, x, y);
	}

	public void update() {}

	public void render(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D)g;
		BlockTextures bt = BlockTextures.valueOf("CHEST");
		ImageIcon icon = (ImageIcon)ProjectSierra.getResources().getObject(bt.getTexture());
		g2d.drawImage(icon.getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
		if(ProjectSierra.isDebug())
			g2d.draw(getCollision());
	}

	public boolean isPassable() {
		return true;
	}

	public boolean walkable() {
		return false;
	}

}