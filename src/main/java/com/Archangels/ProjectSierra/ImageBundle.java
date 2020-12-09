package com.Archangels.ProjectSierra;

import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ImageIcon;

public class ImageBundle extends ResourceBundle {

	private static final Vector<String> KEYS;
	private static Hashtable<String, ImageIcon> TABLE;
	
	static {
		KEYS = new Vector<String>();
		TABLE = new Hashtable<String, ImageIcon>();
	}
	
	private ImageIcon loadImageFromJar(String imageName) {
		String path = "Images/";
		String imagePath = path + imageName;
		ImageIcon icon;
		URL url;
		icon = (ImageIcon)TABLE.get(imageName);
		if(icon != null)
			return icon;
		
		url = ImageBundle.class.getResource(imagePath);
		icon = new ImageIcon(url);
		
		TABLE.put(imageName, icon);
		return icon;
	}
	
	@Override
	protected Object handleGetObject(String key) {
		return loadImageFromJar(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return KEYS.elements();
	}

	
	
}