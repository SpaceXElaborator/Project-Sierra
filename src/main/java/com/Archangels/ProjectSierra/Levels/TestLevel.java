package com.Archangels.ProjectSierra.Levels;

import com.Archangels.ProjectSierra.Block.BasicGround;
import com.Archangels.ProjectSierra.Block.PassableBlock;
import com.Archangels.ProjectSierra.Engine.Handler;
import com.Archangels.ProjectSierra.Util.Location;

public class TestLevel {

	public TestLevel(Handler handler) {
		/// Floor
				for (int i = 0; i < 1240; i += 40) {
					handler.addGameElement(new BasicGround(new Location(i, 680)));
				}
				// Left wall
				for (int i = 0; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(0, i)));
				}
				// Right Wall
				for (int i = 0; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(1240, i)));
				}
				// Far-Left Column
				for (int i = 520; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(40, i)));
				}
				// Left-Middle column
				for (int i = 560; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(80, i)));
				}
				// Right-middle column
				for (int i = 600; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(120, i)));
				}

				// Far right column
				for (int i = 640; i < 700; i += 40) {
					handler.addGameElement(new BasicGround(new Location(160, i)));
				}

				// Hanging single block on left wall
				handler.addGameElement(new BasicGround(new Location(40, 320)));

				// Middle left platform
				for (int i = 280; i < 400; i += 40) {
					handler.addGameElement(new BasicGround(new Location(i, 400)));
				}

				// Middle top platform
				for (int i = 540; i < 660; i += 40) {
					handler.addGameElement(new PassableBlock(new Location(i, 200)));
				}
				
				for (int i = 540; i < 660; i += 40) {
					handler.addGameElement(new PassableBlock(new Location(i, 400)));
				}

				for (int i = 900; i < 1020; i += 40) {
					handler.addGameElement(new BasicGround(new Location(i, 400)));
				}
	}
	
}