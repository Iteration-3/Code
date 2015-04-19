package view.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.map.GameItemView;

public abstract class ItemView implements Saveable{
	private boolean onMap = false;

	public ItemView() {
		
	}
	
	public ItemView(StructuredMap map) {
		this.onMap = map.getBoolean("onMap");
	}

	public abstract void render(Graphics graphics, RealCoordinate location, float diameter);

	public void registerWithGameItemView(GameItemView gv, RealCoordinate p) {
		onMap = true;
		gv.addItemView(this, p);
	}

	public boolean onMap() {
		return onMap;
	}
	
	public void removeFromMap() {
		onMap = false;
	}
	
	public abstract BufferedImage getImage(int x, int y);
	
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
