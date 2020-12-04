package com.Archangels.ProjectSierra.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Block.BasicGround;
import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

public abstract class Entity implements GameElement {

	private Location loc;
	private Velocity dir;
	private ImageIcon i;
	
	private double gravity = 0.5;
	private final double MAX_SPEED = 10;
	
	private boolean falling = false;
	private boolean jumping = false;
	
	private CollisionBox cb;
	private Handler handler;
	
	public Entity(Location loc, ImageIcon i) {
		this.loc = loc;
		this.dir = new Velocity(0, 0);
		this.i = i;
		handler = ProjectSierra.getLauncher().getHandler();
		
		cb = new CollisionBox(this);
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
	
	public CollisionBox getCollisionBox() {
		return cb;
	}
	
	public void update() {
		getLocation().setX(getLocation().getX() + getVelocity().getX());
		getLocation().setY(getLocation().getY() + getVelocity().getY());
		
		if(falling || jumping) {
			getVelocity().setY(getVelocity().getY() + gravity);
			if(getVelocity().getY() > MAX_SPEED) getVelocity().setY(MAX_SPEED);
		}
		
		CheckCollision();
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture().getImage(), (int)getLocation().getX(), (int)getLocation().getY(), null);
		if(ProjectSierra.isDebug()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			g2d.draw(getCollisionBox().getBoundsTop());
			g2d.draw(getCollisionBox().getBoundsBottom());
			g2d.draw(getCollisionBox().getBoundsLeft());
			g2d.draw(getCollisionBox().getBoundsRight());
		}
	}
	
	private void CheckCollision() {
		for(GameElement ge : handler.getGameElements()) {
			if(ge instanceof BasicGround) {
				ge = (BasicGround)ge;
				if(getCollisionBox().getBoundsBottom().intersects(((BasicGround) ge).getCollision())) {
					getLocation().setY(((BasicGround) ge).getLocation().getY() - i.getIconHeight());
					getVelocity().setY(0);
					if(jumping)
						getVelocity().setX(0);
					falling = false;
					jumping = false;
				} else {
					falling = true;
				}
			}
		}
	}
	
	public void setJumping(boolean b) {
		jumping = b;
	}
	
	public boolean isJumping() {
		return jumping;
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
	
}