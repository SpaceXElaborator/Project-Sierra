package com.Archangels.ProjectSierra.Util;

public class Direction {

	private double dx;
	private double dy;
	
	public Direction(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
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
	
}