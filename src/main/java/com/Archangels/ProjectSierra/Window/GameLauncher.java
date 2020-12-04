package com.Archangels.ProjectSierra.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Archangels.ProjectSierra.Engine.GameKeyListener;
import com.Archangels.ProjectSierra.Engine.Handler;

// Main game window (Main Menu. Will make the Exit and Start Game button)
public class GameLauncher extends JFrame {

	// Needed for the creation of this class. This is a random serialNumber
	private static final long serialVersionUID = -3645753859634135062L;
	private JPanel panel;
	private Handler handler;
	
	public GameLauncher() {
		handler = new Handler();
		setTitle("Project Sierra");
		
		if(panel == null) panel = new StartMenu(1280, 720);
		setContentPane(panel);
		
		addKeyListener(new GameKeyListener(handler));
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusTraversalKeysEnabled(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public void setPane(JPanel panel) {
		setContentPane(panel);
		revalidate();
	}

	public Handler getHandler() {
		return handler;
	}
	
}