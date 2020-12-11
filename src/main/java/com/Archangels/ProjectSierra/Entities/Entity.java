package com.Archangels.ProjectSierra.Entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Block.Block;
import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Entities.Collision.CollisionBox;
import com.Archangels.ProjectSierra.Util.Direction;
import com.Archangels.ProjectSierra.Util.Location;
import com.Archangels.ProjectSierra.Util.Velocity;

// The basic class for any living object in the game
public class Entity implements GameElement {

	private Location loc;
	private Velocity dir;
	private Image i;
	
	private double gravity = 0.5;
	private final double MAX_SPEED = 10;
	
	private boolean falling = false;
	private boolean jumping = false;
	private boolean fallingThrough = false;
	
	private CollisionBox cb;
	private Handler handler;
	private boolean alive;
	
	// loc = Starting location
	// i = Image to be represented on the screen at the given location
	public Entity(Location loc, Image i) {
		this.loc = loc;
		this.dir = new Velocity(0, 0);
		this.i = i;
		handler = ProjectSierra.getLauncher().getHandler();
		
		cb = new CollisionBox(this);
		dir.setDirection(Direction.LEFT);
	}
	
	public void setTexture(Image i) {
		this.i = i;
	}
	
	public Image getTexture() {
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
		// Move the entity each frame by the vector stored in the velocity
		getLocation().setX(getLocation().getX() + getVelocity().getX());
		getLocation().setY(getLocation().getY() + getVelocity().getY());
		
		// Check for if the block they are on is air
		if(!isOnSolidBlock()) {
			falling = true;
		}
		
		// Create fake gravity to drop the entity at a given speed
		if(falling || jumping) {
			getVelocity().setY(getVelocity().getY() + gravity);
			if(getVelocity().getY() > MAX_SPEED) getVelocity().setY(MAX_SPEED);
		}
		
		// Check for top/bottom/left/right collisions of the entity
		CheckCollision();
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture(), (int)getLocation().getX(), (int)getLocation().getY(), null);
		
		// Draw collision boxes
		if(ProjectSierra.isDebug()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.WHITE);
			g2d.draw(getCollisionBox().getBoundsTop());
			g2d.draw(getCollisionBox().getBoundsBottom());
			g2d.draw(getCollisionBox().getBoundsLeft());
			g2d.draw(getCollisionBox().getBoundsRight());
		}
	}
	
	private boolean isOnSolidBlock() {
		for(GameElement ge : handler.getGameElements()) {
			if(ge instanceof Block) {
				if(getCollisionBox().getBoundsBottom().intersects(((Block) ge).getCollision())) {
					if(((Block)ge).isPassable()) {
						if(fallingThrough) continue;
					}
					getLocation().setY(((Block) ge).getLocation().getY() - i.getHeight(null) + 1);
					getVelocity().setY(0);
					falling = false;
					jumping = false;
					return true;
				}
			} else {
				continue;
			}
		}
		return false;
	}
	
	private void CheckCollision() {
		for(GameElement ge : handler.getGameElements()) {
			if(ge instanceof Block) {
				if(!((Block) ge).isPassable()) {
					if(getCollisionBox().getBoundsLeft().intersects(((Block) ge).getCollision())) {
						getLocation().setX(getLocation().getX() + 5);
					}
					if(getCollisionBox().getBoundsRight().intersects(((Block) ge).getCollision())) {
						getLocation().setX(getLocation().getX() - 5);
					}
					if(getCollisionBox().getBoundsTop().intersects(((Block) ge).getCollision())) {
						getVelocity().setY(1);
					}
				}
			}
		}
	}
	
	public void setFallingThrough(boolean b) {
		fallingThrough = b;
	}
	
	public boolean isFallingThrough() {
		return fallingThrough;
	}
	
	public void setJumping(boolean b) {
		jumping = b;
	}
	
	public boolean isJumping() {
		return jumping;
	}
	
	public void setFalling(boolean b) {
		falling = b;
	}
	
	public boolean isFalling() {
		return falling;
	}
	
	public void kill() {
		alive = false;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	// Flip the image on the X axis to either left or right depending on the way they are traveling
	public void setDirection(Direction dir) {
		if(getVelocity().getDirection() == dir) return;
		
		// Created a buffered image and paint the image onto its surface
		BufferedImage img = new BufferedImage(i.getWidth(null), i.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = img.createGraphics();
		g.drawImage(i, 0, 0, null);
		g.dispose();
		
		// Keep the scale but flip it on the X axis
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-i.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		
		//Set the image
		i = op.filter(img, null);
		getVelocity().setDirection(dir);
	}
	
	public Velocity getVelocity() {
		return dir;
	}
	
}