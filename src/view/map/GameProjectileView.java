package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import view.EntityView;
import view.projectiles.ProjectileView;

public class GameProjectileView implements GameView {

	private static final int NUM_TILES_Y = 18;  // Defines how many tiles we display in the vertical dimension
												// Also implicitly defines how many we can see horizontally
	 
	private static final float TILE_DIMENSION_RATIO = (float) (Math.sqrt(3) / 2);
	
	// These values should come from elsewhere. Just here now for testing purposes.
	private int screenWidth;
	private int screenHeight;
	private Collection<ProjectileView> projectileViews = new ArrayList<ProjectileView>();
	private ArrayList<ProjectileView> toAdd = new ArrayList<ProjectileView>();

	public void render(Graphics graphics, int width, int height) {
		this.screenHeight = height;
		if (!toAdd.isEmpty()) {
			projectileViews.addAll(toAdd);
			toAdd.clear();
		}
		for (ProjectileView projView : projectileViews) {		
			//Sysem.out.println("RENDERING@: " + projView.getLocation());
			System.out.println("SUP");
			for (TileCoordinate loc : projView.getArea().getCoveredLocations()) {
				System.out.println("LOC: " + loc);
				float renderX = (float) (loc.getX() * tileWidth() * 0.75);
				float renderY = (float) (loc.getY() * tileHeight() + (loc.getX() % 2) * tileHeight() / 2);
				projView.render(graphics, new RealCoordinate(renderX, renderY), tileWidth());
			}
		}
	}
	
	private float tileHeight() {
		return (float) screenHeight / NUM_TILES_Y;
	}
	
	private float tileWidth() {
		return tileHeight() / TILE_DIMENSION_RATIO;
	}
	
	public void addProjectileView(ProjectileView entityView) {
		toAdd.add(entityView);
	}
}
