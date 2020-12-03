package com.Archangels.ProjectSierra.Physics;
private static final double GRAVITY = 9.8;
private static final double TERMINAL_VELOCITY = 100;
private double speed;
private int current_y;

public class Gravity() {
	
    speed = speed + GRAVITY;

    if (speed > TERMINAL_VELOCITY) { speed = TERMINAL_VELOCITY; }

    if (current_y >= bottomOfScreen)
    {
    //Bounce effect
     speed = -speed/4; 
    } 
    current_y += speed; 
}