package view.item;

import java.awt.Graphics;

import view.map.GameItemView;
import model.area.RealCoordinate;

public abstract class ItemView {
	public abstract void render(Graphics graphics, RealCoordinate location, float diameter);
	private boolean onMap = false;

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
	
}
