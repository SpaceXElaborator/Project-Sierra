package com.Archangels.ProjectSierra.Window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.Archangels.ProjectSierra.ProjectSierra;

public class StartMenu extends JPanel {
	
	// Needed for the creation of this class
	private static final long serialVersionUID = -2527463417699088535L;
	
	public StartMenu(int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.BLACK);
		
		// Placeholders for our initial screen buttons
		JPanel start = new JPanel(), exit = new JPanel();
		
		// Stylize and place buttons
		start.setBounds(465, 360, 350, 100);
		JLabel startText = new JLabel("Start");
		startText.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
		start.setLayout(new GridBagLayout());
		start.add(startText);
		
		exit.setBounds(465, 500, 350, 100);
		JLabel exitText = new JLabel("Exit Game");
		exitText.setFont(new Font(Font.SERIF, Font.PLAIN, 50));
		exit.setLayout(new GridBagLayout());
		exit.add(exitText);
		
		// Add control to the bottons
		start.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ProjectSierra.getLauncher().setPane(new GamePanel());
			}
			
			public void mouseEntered(MouseEvent e) {
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(Color.GREEN);
				panel.revalidate();
			}
			
			public void mouseExited(MouseEvent e) {
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(Color.WHITE);
				panel.revalidate();
			}
		});
		
		exit.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				ProjectSierra.getLauncher().dispatchEvent(new WindowEvent(ProjectSierra.getLauncher(), WindowEvent.WINDOW_CLOSING));
			}
			
			public void mouseEntered(MouseEvent e) {
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(Color.GREEN);
				panel.revalidate();
			}
			
			public void mouseExited(MouseEvent e) {
				JPanel panel = (JPanel)e.getSource();
				panel.setBackground(Color.WHITE);
				panel.revalidate();
			}
		});
		
		add(start);
		add(exit);
		setLayout(null);
	}
	
}