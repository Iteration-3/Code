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
	private int screenWidth;
	private int screenHeight;
	private static final int NUM_TILES_Y = 18;  
	private static final float TILE_DIMENSION_RATIO = (float) (Math.sqrt(3) / 2);

	@Override
	public void render(Graphics graphics, int width, int height) {
		this.screenWidth = width;
		this.screenHeight = height;
		
		List<RealCoordinate> toRemove = new ArrayList<RealCoordinate>();
		for(Map.Entry<RealCoordinate, ItemView> entry: itemViews.entrySet()) {
			ItemView itemView = entry.getValue();
			RealCoordinate coordinate = entry.getKey();
			if (!itemView.onMap()) {
				toRemove.add(entry.getKey());
				continue;
			}
			int renderX = (int) (coordinate.getX() * itemWidth() * .75);
			int renderY = (int) (coordinate.getY() * (coordinate.getX() % 2) * itemHeight() / 2);
			itemView.render(graphics, new RealCoordinate(renderX, renderY), itemWidth() / 1.5f);
		}
		for (RealCoordinate coordinate: toRemove)
			itemViews.remove(coordinate);
		
	}

	public void addItemView(ItemView itemView, RealCoordinate position) {
		itemViews.put(position, itemView);
	}

	private float itemHeight() {
		return (float) screenHeight / NUM_TILES_Y;
	}
	
	private float itemWidth() {
		return (itemHeight() / TILE_DIMENSION_RATIO);
	}
	
	private float aspectRation() {
		return (float) screenWidth / screenHeight;
	}

}
