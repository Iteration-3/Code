package view.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import view.Renderable;
import view.ViewTransform;

public class GameEntityView implements Renderable {
	private Collection<EntityView> entityViews = new ArrayList<EntityView>();

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for(EntityView entityView : entityViews) {
			entityView.render(graphics, transform);
			
		}
	}
	
	public void addEntityView(EntityView entityView) {
		entityViews.add(entityView);
	}
	
	public void remove(EntityView entityView) {
		entityViews.remove(entityView);
	}
	
	public void lock() {
		for (EntityView entView : entityViews) {
			entView.lock();
		}
	}
	
	public void release() {
		for (EntityView entView : entityViews) {
			entView.release();
		}
	}
}
