package view.item;

import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Renderable;

public abstract class ItemView implements Saveable, Renderable {
	private GameItemView container;
	private boolean onMap = false;
	private boolean visible = true;
	private RealCoordinate position;

	public ItemView(RealCoordinate position) {
		this.position = position;
	}

	public ItemView() {
		
	}
	
	public ItemView(StructuredMap map) {
		this.onMap = map.getBoolean("onMap");
		this.position = new RealCoordinate(map.getStructuredMap("position"));
	}

	public void registerWithGameItemView(GameItemView gv) {
		this.onMap = true;
		gv.addItemView(this);
		this.container = gv;
	}

	public void removeFromMap() {
		container.removeItemView(this);
	}
	
	public void showOnMap() {
	}

	public abstract BufferedImage getImage(int x, int y);
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("onMap", onMap);
		map.put("type", getType());
		map.put("position", position.getStructuredMap());
		return map;
	}
	
	public abstract String getType();
	
	public void toggle() {
		this.removeFromMap();
	}
	
	public boolean isVisible() {
		return this.visible;
	}
	
	public void setVisibility(boolean visiblity) {
		this.visible = visiblity;
	}
	
	public RealCoordinate getPosition() {
		return position;
	}
}
