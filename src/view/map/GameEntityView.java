package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;


import view.EntityView;

public class GameEntityView implements GameView {
	private Collection<EntityView> entityViews = new ArrayList<EntityView>();

	public void render(Graphics graphics, int width, int height) {
		for(EntityView i : entityViews) {
			//TODO(mbregg) Make this not hardcoded, EntityView really needs to be redone
			i.render(graphics, height/18);
		}
	}
	public void addEntityView(EntityView entityView) {
		entityViews.add(entityView);
	}
}
