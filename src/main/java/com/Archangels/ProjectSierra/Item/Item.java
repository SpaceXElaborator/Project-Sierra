package com.Archangels.ProjectSierra.Item;

import javax.swing.ImageIcon;

import com.Archangels.ProjectSierra.Engine.GameElement;

public abstract class Item implements GameElement {
	private String name;
	private ImageIcon texture;

	public Item(String s, ImageIcon j) {
		texture = j;
	}

	public void setTexture(ImageIcon j) {
		texture = j;
	}

	public ImageIcon getTexture() {
		return texture;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
}