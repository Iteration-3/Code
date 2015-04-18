package view.map;

import java.awt.Color;
import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.light.LightManager;

public class GameLightView implements GameView{
	private static final int NUM_TILES_Y = 18;  // Defines how many tiles we display in the vertical dimension
												// Also implicitly defines how many we can see horizontally
	 
	private static final float TILE_DIMENSION_RATIO = (float) (Math.sqrt(3) / 2);
	
	// These values should come from elsewhere. Just here now for testing purposes.
	private int screenWidth;
	private int screenHeight;
	
	public void render(Graphics graphics, int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		
		for(int x = 0; x < numberOfHorizontalTiles(); ++x) {
			for(int y = 0; y < numberOfVerticalTiles(); ++y) {
			
				int renderX = (int) (x * tileWidth() * 0.75);
				int renderY = (int) (y * tileHeight() + (x % 2) * tileHeight() / 2);
				
				int vis = LightManager.getLightManager().strength(new TileCoordinate(x, y));
				Color col = new Color(84,84,84, 255-vis);
				Hexagon hex = new Hexagon(col);
				
				hex.render(graphics, new RealCoordinate(renderX, renderY), tileWidth());
			}
		}
	}
	
	private float tileHeight() {
		return (float) screenHeight / NUM_TILES_Y;
	}
	
	private float tileWidth() {
		return tileHeight() / TILE_DIMENSION_RATIO;
	}
	
	private float aspectRation() {
		return (float) screenWidth / screenHeight;
	}
	
	private int numberOfHorizontalTiles() {
	 	// +2 => +1 so we guarantee the screen is covered otherwise
		// the integer arithmetic might cause us to show blank space
	 	// +1 more because we start halfway through a tile at the moment
		return (int) (aspectRation() * NUM_TILES_Y / TILE_DIMENSION_RATIO + 2);
	}
	
	private int numberOfVerticalTiles() {
		return NUM_TILES_Y + 1;
	}
}