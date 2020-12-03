package com.Archangels.ProjectSierra;

import com.Archangels.ProjectSierra.Window.GameLauncher;

public class ProjectSierra {

	private static GameLauncher launch;
	
	public static void main(String[] args) {
		launch = new GameLauncher();
	}
	
	public static GameLauncher getLauncher() {
		return launch;
	}
	
}