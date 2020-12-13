package com.Archangels.ProjectSierra.Block;

// Class to store all blocks textures and their friendly name
public enum BlockTextures {

	STONE("Stone", "Blocks/Stone.png"),
	WOOD_LEDGE("Wood Ledge", "Blocks/WoodLedge.png"),
	CHEST("Chest", "Blocks/Chest.png");
	
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