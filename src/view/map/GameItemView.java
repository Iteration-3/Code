package view.map;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import model.area.RealCoordinate;
import utilities.ScreenCoordinate;
import view.Renderable;
import view.ViewTransform;
import view.item.ItemView;

public class GameItemView implements Renderable {
	private Map<RealCoordinate, ItemView> itemViews = new HashMap<RealCoordinate, ItemView>();

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for(Map.Entry<RealCoordinate, ItemView> entry: itemViews.entrySet()) {
			ItemView itemView = entry.getValue();
			RealCoordinate coordinate = entry.getKey();
			ScreenCoordinate renderPosition = transform.getTranslatedPosition(coordinate);
			itemView.render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileHeight());
		}
	}

	public void addItemView(ItemView itemView, RealCoordinate position) {
		itemViews.put(position, itemView);
	}
	
	public void removeItemView(ItemView value) {
		while (itemViews.values().remove(value));
	}
}
