package com.Archangels.ProjectSierra.Block;

import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Engine.GameElement;

public abstract class Block implements GameElement {
	
	// Whether or not the block can be passed through using 'S' or if it can be jumped through from below
	public abstract boolean isPassable();
	
	// Used to set the bounds of the block and where to the player will hit
	public abstract Rectangle getCollision();
	
}