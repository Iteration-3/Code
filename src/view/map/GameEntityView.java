package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import model.Camera;
import view.EntityView;

public class GameEntityView {
	private Collection<EntityView> entityViews = new ArrayList<EntityView>();

	public void render(Graphics graphics, Camera camera) {
		for(EntityView entityView : entityViews) {
			entityView.render(graphics, camera);
			
		}
	}
	public void addEntityView(EntityView entityView) {
		entityViews.add(entityView);
	}
}
