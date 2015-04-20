package view.map;

import java.awt.Graphics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import model.area.RealCoordinate;
import utilities.ScreenCoordinate;
import view.Renderable;
import view.ViewTransform;
import view.item.ItemView;

public class GameItemView implements Renderable {
	private List<ItemView> itemViews = new CopyOnWriteArrayList<ItemView>();

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for(ItemView itemView: itemViews) {
			itemView.render(graphics, transform);
		}
	}

	public void addItemView(ItemView itemView) {
		itemViews.add(itemView);
	}
	
	public void removeItemView(ItemView view) {
		itemViews.remove(view);
	}
}
