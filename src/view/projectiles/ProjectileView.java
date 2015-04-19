package view.projectiles;

import java.awt.Graphics;

import view.map.GameProjectileView;
import model.area.RealCoordinate;
import model.area.TileCoordinate;

public abstract class ProjectileView {
	
	private TileCoordinate location;
	
	public ProjectileView(TileCoordinate location) {
		this.location = location;
	}

	public abstract void render(Graphics graphics, RealCoordinate location, float diam);
	
	public void registerWithGameProjectileView(GameProjectileView gv) {
		gv.addProjectileView(this);
	}
	
	public TileCoordinate getLocation() {
		return location;
	}
	
	public void setLocation(TileCoordinate location) {
		this.location = location;
	}
}
