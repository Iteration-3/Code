package view.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class ItemView implements Saveable{
	private GameItemView container;
	private boolean onMap = false;

	public ItemView() {
		
	}
	
	public ItemView(StructuredMap map) {
		this.onMap = map.getBoolean("onMap");
	}

	public abstract void render(Graphics graphics, float x, float y, float diameter);

	public void registerWithGameItemView(GameItemView gv, RealCoordinate p) {
		this.onMap = true;
		gv.addItemView(this, p);
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
	
}
