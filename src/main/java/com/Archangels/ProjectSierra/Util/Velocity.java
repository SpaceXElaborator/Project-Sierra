package com.Archangels.ProjectSierra.Util;

public class Velocity {

	private double dx;
	private double dy;
	private Direction dir;
	
	public Velocity(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
		dir = null;
	}
	
	public double getX() {
		return dx;
	}
	
	public double getY() {
		return dy;
	}
	
	public void setX(double x) {
		this.dx = x;
	}
	
	public void setY(double y) {
		this.dy = y;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}
	
}