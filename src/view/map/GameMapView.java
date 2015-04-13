package view.map;

import java.awt.Graphics;
import java.awt.Color;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import utilities.Point;
import model.area.Location;
import view.EntityView;

public class GameMapView {
	private TileView[][] tileViews;
	private static final int NUM_TILES_Y = 18;  // Defines how many tiles we display in the vertical dimension
												// Also implicitly defines how many we can see horizontally
	private Map<Location,EntityView> entityViews;
	 
	private static final float TILE_DIMENSION_RATIO = (float) (Math.sqrt(3) / 2);
	
	// These values should come from elsewhere. Just here now for testing purposes.
	private int screenWidth;
	private int screenHeight;
	
	public GameMapView() {
		tileViews = new TileView[100][100]; //exact sizing just for testing purposes
		entityViews = new HashMap<Location,EntityView>();

	}
	
	public void render(Graphics graphics, int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		
		for(int x = 0; x < numberOfHorizontalTiles(); ++x) {
			for(int y = 0; y < numberOfVerticalTiles(); ++y) {
				int renderX = (int) (x * tileWidth() * 0.75);
				int renderY = (int) (y * tileHeight() + (x % 2) * tileHeight() / 2);
				if(tileViews[x][y]!=null){
					tileViews[x][y].render(graphics, new Location(renderX, renderY), tileWidth());
				}
			}
		}
		for( Entry<Location, EntityView> i : entityViews.entrySet()){
			i.getValue().render(graphics, i.getKey(), tileWidth());
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
	
	private void initDummyTileViews() {
		for(int x = 0; x < tileViews.length; ++x) {
			for(int y = 0; y < tileViews[0].length; ++y) {
				tileViews[x][y] = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
			}
		}
	}

	public void addTileView(TileView tileView, Point loc) {
		//Are we using location or point?
		tileViews[loc.getX()][loc.getY()]=tileView;	
	}
	public void addEntityView(EntityView entityView, Location loc){
		entityViews.put(loc,entityView);
	}
}