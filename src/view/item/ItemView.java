package view.item;

import java.awt.Graphics;

import view.map.GameItemView;
import model.area.RealCoordinate;

public abstract class ItemView {
	public abstract void render(Graphics graphics, RealCoordinate location, float diameter);

	public void registerWithGameItemView(GameItemView gv, RealCoordinate p) {
		gv.addItemView(this,p);
	}
}
