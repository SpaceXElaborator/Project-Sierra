package com.Archangels.ProjectSierra.Engine;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Action;

public class KeyBindings {

	public Map<String, Action> keyBindings;
	
	public KeyBindings() {
		keyBindings = new HashMap<String, Action>();
	}
	
	public void addKeyBinding(String c, Action a) {
		keyBindings.put(c, a);
	}
	
	public Map<String, Action> getKeyBindings() {
		return keyBindings;
	}
	
}