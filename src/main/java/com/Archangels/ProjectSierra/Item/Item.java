package com.Archangels.ProjectSierra.Item;

public abstract class Item {
	
	private String name;
	private String texture;

	public Item(String s, String j) {
		texture = j;
	}

	public void setTexture(String j) {
		texture = j;
	}

	public String getTexture() {
		return texture;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}
	
}