package com.Archangels.ProjectSierra;

import com.Archangels.ProjectSierra.Window.GameLauncher;

public class ProjectSierra {

	private static GameLauncher launch;
	private static boolean debug = false;
	
	public static void main(String[] args) {
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("--debug")) debug = true;
		}
		
		launch = new GameLauncher();
	}
	
	public static GameLauncher getLauncher() {
		return launch;
	}
	
	public static boolean isDebug() {
		return debug;
	}
	
}