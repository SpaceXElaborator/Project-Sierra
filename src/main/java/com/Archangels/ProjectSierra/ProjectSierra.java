package com.Archangels.ProjectSierra;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.Archangels.ProjectSierra.Engine.KeyBindings;
import com.Archangels.ProjectSierra.Window.GameLauncher;

public class ProjectSierra {

	private static GameLauncher launch;
	private static boolean debug = false;
	private static KeyBindings bindings;
	private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	
	public static void main(String[] args) {
		if(args.length > 0) {
			for(String s : args) {
				if(s.equalsIgnoreCase("--debug")) debug = true;
			}
		}
		bindings = new KeyBindings();
		launch = new GameLauncher();
	}
	
	public static GameLauncher getLauncher() {
		return launch;
	}
	
	public static KeyBindings getKeyBindings() {
		return bindings;
	}
	
	public static ScheduledExecutorService getScheduler() {
		return service;
	}
	
	public static boolean isDebug() {
		return debug;
	}
	
}