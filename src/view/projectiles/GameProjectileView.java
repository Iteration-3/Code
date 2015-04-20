package view.projectiles;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ScreenCoordinate;
import view.ViewTransform;

public class GameProjectileView {
	
	private Collection<ProjectileView> projectileViews = new ArrayList<ProjectileView>();
	private ArrayList<ProjectileView> toAdd = new ArrayList<ProjectileView>();
	private ArrayList<ProjectileView> toRemove = new ArrayList<ProjectileView>();

	public void render(Graphics graphics, ViewTransform transform) {
		if (!toAdd.isEmpty()) {
			projectileViews.addAll(toAdd);
			toAdd.clear();
		}
		if (!toRemove.isEmpty()) {
			projectileViews.removeAll(toRemove);
			toRemove.clear();
		}

		for (ProjectileView projView : projectileViews) {		
			for (TileCoordinate loc : projView.getArea().getCoveredLocations()) {
				RealCoordinate coordinate = TileCoordinate.convertToRealCoordinate(loc);
				ScreenCoordinate renderPosition = transform.getTranslatedPosition(coordinate);
				projView.render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileHeight());
			}
		}
	}
	
	/*public void lock() {
		for (ProjectileView pv : projectileViews) {
			pv.lock();
		}
		for (ProjectileView pv : toAdd) {
			pv.lock();
		}
	}
	
	public void release() {
		for (ProjectileView pv : projectileViews) {
			pv.release();
		}
		for (ProjectileView pv : toAdd) {
			pv.release();
		}
	}*/
	
	public void addProjectileView(ProjectileView entityView) {
		toAdd.add(entityView);
	}
	
	public void removeProjectileView(ProjectileView entityView) {
		toRemove.add(entityView);
	}
}
