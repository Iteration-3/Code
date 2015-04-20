package view.projectiles;

import java.awt.Graphics;
import java.util.ArrayList;

import model.area.Area;

public abstract class ProjectileView {
	
	private Area area;
	private ArrayList<GameProjectileView> registered;
	
	public ProjectileView(Area area) {
		this.area = area;
		registered = new ArrayList<GameProjectileView>();
	}

	public abstract void render(Graphics graphics, float x, float y, float diam);
	
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
