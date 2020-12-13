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
import com.Archangels.ProjectSierra.Block.Block;
import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Entities.Collision.CollisionBox;
import com.Archangels.ProjectSierra.Item.Item;
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
	
	private Item mainHandItem;
	private Item offHandItem;
	
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
		dir.setDirection(Direction.RIGHT);
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
		
		drawDirection(g, getVelocity().getDirection());
		
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
					if(!((Block) ge).walkable()) continue;
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
	
	public Item getMainHand() {
		return mainHandItem;
	}
	
	public void setMainHand(Item u) {
		mainHandItem = u;
	}
	
	public Item getOffHandItem() {
		return offHandItem;
	}
	
	public void setOffHandItem(Item u) {
		offHandItem = u;
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
	private void drawDirection(Graphics g, Direction dir) {
		
		if(dir == Direction.RIGHT) {
			if(mainHandItem != null)
				g.drawImage(((ImageIcon)ProjectSierra.getResources().getObject(mainHandItem.getTexture())).getImage(), (int)getLocation().getX() + 50, (int)getLocation().getY() + 50, null);
			g.drawImage(getTexture(), (int)getLocation().getX(), (int)getLocation().getY(), null);
			if(offHandItem != null)
				g.drawImage(((ImageIcon)ProjectSierra.getResources().getObject(offHandItem.getTexture())).getImage(), (int)getLocation().getX() + 10, (int)getLocation().getY() + 50, null);
		} else {
			// Create a new image canvas to draw the player too
			BufferedImage img = new BufferedImage(i.getWidth(null), i.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics big = img.createGraphics();
			big.drawImage(i, 0, 0, null);
			big.dispose();
			// Keep the scale but flip it on the X axis
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-i.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			
			if(mainHandItem != null) {
				BufferedImage img2 = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
				Graphics g3 = img2.getGraphics();
				g3.drawImage(((ImageIcon)ProjectSierra.getResources().getObject(mainHandItem.getTexture())).getImage(), 0, 0, null);
				g3.dispose();
				AffineTransform tx2 = AffineTransform.getScaleInstance(-1, 1);
				tx2.translate(-32, 0);
				AffineTransformOp op2 = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
				g.drawImage(op2.filter(img2, null), (int)getLocation().getX() - 50, (int)getLocation().getY() + 50, null);
			}
			
			g.drawImage(op.filter(img, null), (int)getLocation().getX(), (int)getLocation().getY(), null);
			
			if(offHandItem != null) {
				BufferedImage img2 = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
				Graphics g3 = img2.getGraphics();
				g3.drawImage(((ImageIcon)ProjectSierra.getResources().getObject(offHandItem.getTexture())).getImage(), 0, 0, null);
				g3.dispose();
				AffineTransform tx2 = AffineTransform.getScaleInstance(-1, 1);
				tx2.translate(-32, 0);
				AffineTransformOp op2 = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
				g.drawImage(op2.filter(img2, null), (int)getLocation().getX() - 10, (int)getLocation().getY() + 50, null);
			}
		}
	}
	
	public Velocity getVelocity() {
		return dir;
	}
	
}