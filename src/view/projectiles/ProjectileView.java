package view.projectiles;

import java.awt.Graphics;

import view.map.GameProjectileView;
import model.area.Area;
import model.area.RealCoordinate;
import model.area.TileCoordinate;

public abstract class ProjectileView {
	
	private Area area;
	
	public ProjectileView(Area area) {
		this.area = area;
	}

	public abstract void render(Graphics graphics, RealCoordinate location, float diam);
	
	public void registerWithGameProjectileView(GameProjectileView gv) {
		gv.addProjectileView(this);
	}
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		//this.area = area;
	}
}
