package com.Archangels.ProjectSierra.Block;

public enum BlockTextures {

	STONE("Stone", "Blocks/Stone.png");
	
	private String name;
	private String texture;
	
	BlockTextures(String name, String texture) {
		this.name = name;
		this.texture = texture;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTexture() {
		return texture;
	}
	
}