package com.Archangels.ProjectSierra.Entities.Player;

public enum Classes {

	KNIGHT("Knight", "CharacterImages/Knight_1.png");

	private String name;
	private String image;
	
	Classes(String name, String image) {
		this.name = name;
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	
	public String getImage() {
		return image;
	}
	
}