package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

import view.ItemView;

public class GameItemView implements GameView {
	private Collection<ItemView> ItemViews = new ArrayList<ItemView>();
	@Override
	public void render(Graphics graphics, int width, int height) {
		// TODO(mbregg)		
	}
	public void addEntityView(ItemView itemView) {
		ItemViews.add(itemView);
	}
}
