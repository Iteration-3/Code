package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import view.Camera;
import view.ViewTransform;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ScreenCoordinate;
import view.projectiles.ProjectileView;

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

		RealCoordinate cameraPosition = transform.getPosition();
		for (ProjectileView projView : projectileViews) {		
			for (TileCoordinate loc : projView.getArea().getCoveredLocations()) {
				RealCoordinate coordinate = TileCoordinate.convertToRealCoordinate(loc);
				ScreenCoordinate renderPosition = transform.getTranslatedPosition(coordinate, cameraPosition);
				projView.render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileHeight());
			}
		}
	}
	
	public void addProjectileView(ProjectileView entityView) {
		toAdd.add(entityView);
	}
	
	public void removeProjectileView(ProjectileView entityView) {
		toRemove.add(entityView);
	}
}
