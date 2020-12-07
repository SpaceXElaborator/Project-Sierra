package com.Archangels.ProjectSierra.Engine.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Entities.Controllable;
import com.Archangels.ProjectSierra.Entities.Projectiles.Projectile;
import com.Archangels.ProjectSierra.Util.Velocity;

public class GameMouseListener implements MouseListener {
	
	private Controllable cont;
	private Handler handler;
	
	public GameMouseListener() {
		handler = ProjectSierra.getLauncher().getHandler();
		cont = (Controllable) handler.getControlledEntity();
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Projectile p = new Projectile(new ImageIcon(ProjectSierra.class.getResource("Images/Projectiles/Bullet.png")), new Velocity(10, 0), handler.getControlledEntity().getLocation());
			cont.fireProjectile(p);
			System.out.println(e.getX() + " | " + e.getY());
		}
	}
	
}