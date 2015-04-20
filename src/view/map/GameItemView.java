package view.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.area.RealCoordinate;
import view.item.ItemView;

// Copied from GameTerrainView
public class GameItemView implements GameView {
	private Map<RealCoordinate, ItemView> itemViews = new HashMap<RealCoordinate, ItemView>();
	private int screenHeight;
	private static final int NUM_TILES_Y = 18;  
	private static final float TILE_DIMENSION_RATIO = (float) (Math.sqrt(3) / 2);

	@Override
	public void render(Graphics graphics, int width, int height) {
		this.screenHeight = height;
		
		for(Map.Entry<RealCoordinate, ItemView> entry: itemViews.entrySet()) {
			ItemView itemView = entry.getValue();
			RealCoordinate coordinate = entry.getKey();

			double tileHeight = screenHeight / 18.0f;
			double tileWidth = tileHeight / (float) (Math.sqrt(3) / 2);

			float renderX = (float) (coordinate.getX() * itemWidth() * 0.75);
			float renderY = (float) (coordinate.getY() * itemHeight() + (coordinate.getX() % 2) * itemHeight() / 2);
			itemView.render(graphics, new RealCoordinate(renderX, renderY), itemWidth());
		}
		
	}

	public void addItemView(ItemView itemView, RealCoordinate position) {
		itemViews.put(position, itemView);
	}
	
	public void removeItemView(ItemView value) {
		while (itemViews.values().remove(value));
	}

	private float itemHeight() {
		return (float) screenHeight / NUM_TILES_Y;
	}
	
	private float itemWidth() {
		return (itemHeight() / TILE_DIMENSION_RATIO);
	}
}
