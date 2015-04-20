package view.projectiles;

import java.awt.Graphics;
import java.util.ArrayList;

import view.map.GameProjectileView;
import model.area.Area;
import model.area.RealCoordinate;
import model.area.TileCoordinate;

public abstract class ProjectileView {
	
	private Area area;
	private ArrayList<GameProjectileView> registered;
	
	public ProjectileView(Area area) {
		this.area = area;
		registered = new ArrayList<GameProjectileView>();
	}

	public abstract void render(Graphics graphics, RealCoordinate location, float diam);
	
	public void registerWithGameProjectileView(GameProjectileView gv) {
		gv.addProjectileView(this);
		registered.add(gv);
	}
	
	public void dispose() {
		for (GameProjectileView gv : registered) {
			gv.removeProjectileView(this);
		}
	}
	
	public Area getArea() {
		return area;
	}
}
