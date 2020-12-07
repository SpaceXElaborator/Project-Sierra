package com.Archangels.ProjectSierra.Block;

import java.awt.Rectangle;

import com.Archangels.ProjectSierra.Engine.GameElement;
import com.Archangels.ProjectSierra.Util.Location;

public abstract class Block implements GameElement {

	public abstract Location getLocation();
	public abstract boolean isPassable();
	public abstract Rectangle getCollision();
	
}