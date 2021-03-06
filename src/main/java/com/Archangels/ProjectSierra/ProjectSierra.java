package com.Archangels.ProjectSierra;

import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.Archangels.ProjectSierra.Engine.KeyBindings;
import com.Archangels.ProjectSierra.Window.GameLauncher;

public class ProjectSierra {

	private static GameLauncher launch;
	private static boolean debug = false;
	private static KeyBindings bindings;
	private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
	private static ResourceBundle rb;
	
	public static void main(String[] args) {
		if(args.length > 0) {
			for(String s : args) {
				if(s.equalsIgnoreCase("--debug")) debug = true;
			}
		}
		rb = ResourceBundle.getBundle("com.Archangels.ProjectSierra.ImageBundle");
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
	
	public static ResourceBundle getResources() {
		return rb;
	}
	
	public static boolean isDebug() {
		return debug;
	}
	
}