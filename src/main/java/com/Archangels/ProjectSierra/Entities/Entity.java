package com.Archangels.ProjectSierra.Entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public abstract class Entity implements GameElement {

	private Location loc;
	private Velocity dir;
	private ImageIcon i;
	
	public Entity(Location loc) {
		this.loc = loc;
		this.dir = new Velocity(0, 0);
		createCollisionBox();
	}
	
	public void setTexture(ImageIcon i) {
		this.i = i;
	}
	
	public ImageIcon getTexture() {
		return this.i;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public Location getLocation() {
		return this.loc;
	}
	
	public void setDirection(Direction dir) {
		if(getVelocity().getDirection() == dir) return;
		Image image = i.getImage();
		BufferedImage img = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = img.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		img = op.filter(img, null);
		
		i = new ImageIcon(img);
		getVelocity().setDirection(dir);
	}
	
	public Velocity getVelocity() {
		return dir;
	}
	
	public abstract void createCollisionBox();
	
}