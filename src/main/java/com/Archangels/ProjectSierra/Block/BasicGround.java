package com.Archangels.ProjectSierra.Block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Util.Location;

public class BasicGround extends Block {
	
	public BasicGround(Location loc) {
		super(loc, 40, 40);
	}
	
	public void update() {}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		Graphics2D g2d = (Graphics2D)g;
		BlockTextures bt = BlockTextures.valueOf("STONE");
		ImageIcon icon = (ImageIcon)ProjectSierra.getResources().getObject(bt.getTexture());
		g2d.drawImage(icon.getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
		if(ProjectSierra.isDebug())
			g2d.draw(getCollision());
	}

	public boolean isPassable() {
		return false;
	}

	public boolean walkable() {
		return true;
	}
	
}