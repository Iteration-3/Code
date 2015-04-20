package view.map;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import model.Camera;
import model.area.RealCoordinate;
import utilities.ScreenCoordinate;
import view.item.ItemView;

// Copied from GameTerrainView
public class GameItemView {
	private Map<RealCoordinate, ItemView> itemViews = new HashMap<RealCoordinate, ItemView>();

	public void render(Graphics graphics, Camera camera) {
		RealCoordinate cameraPosition = camera.getPosition();
		for(Map.Entry<RealCoordinate, ItemView> entry: itemViews.entrySet()) {
			ItemView itemView = entry.getValue();
			RealCoordinate coordinate = entry.getKey();
			ScreenCoordinate renderPosition = camera.getTranslatedPosition(coordinate, cameraPosition);
			itemView.render(graphics, renderPosition.getX(), renderPosition.getY(), camera.getTileHeight());
		}
	}

	public void addItemView(ItemView itemView, RealCoordinate position) {
		itemViews.put(position, itemView);
	}
	
	public void removeItemView(ItemView value) {
		while (itemViews.values().remove(value));
	}
}
