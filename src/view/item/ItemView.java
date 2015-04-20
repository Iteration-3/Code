package view.item;

import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Renderable;

public abstract class ItemView implements Saveable, Renderable {
	private GameItemView container;
	private boolean onMap = false;
	private RealCoordinate position;

	public ItemView(RealCoordinate position) {
		this.position = position;
	}

	public ItemView() {
		
	}
	
	public ItemView(StructuredMap map) {
		this.onMap = map.getBoolean("onMap");
	}

	public void registerWithGameItemView(GameItemView gv) {
		this.onMap = true;
		gv.addItemView(this);
		this.container = gv;
	}

	public void removeFromMap() {
		container.removeItemView(this);
		container = null;
	}
	
	public abstract BufferedImage getImage(int x, int y);
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("onMap", onMap);
		map.put("type", getType());
		return map;
	}
	
	public abstract String getType();
	
	public void toggle() {
		this.removeFromMap();
	}
	
	public RealCoordinate getPosition() {
		return position;
	}
}
