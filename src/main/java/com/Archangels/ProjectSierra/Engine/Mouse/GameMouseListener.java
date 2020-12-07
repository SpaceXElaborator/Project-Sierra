package com.Archangels.ProjectSierra.Engine.Mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.Archangels.ProjectSierra.ProjectSierra;
import com.Archangels.ProjectSierra.Engine.Handler;

public class GameMouseListener implements MouseListener {
	
	private Handler handler;
	
	public GameMouseListener() {
		handler = ProjectSierra.getLauncher().getHandler();
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
			if(handler.getControlledEntity().getMainHand() != null)
				handler.getControlledEntity().getMainHand().onLeftClick();
		}
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			if(handler.getControlledEntity().getMainHand() != null)
				handler.getControlledEntity().getMainHand().onRightClick();
		}
	}
	
}