package view;

import java.awt.Color;
import java.awt.Graphics;

import model.area.RealCoordinate;
import view.map.GameEntityView;
import view.tiles.components.Hexagon;

public class EntityView {
	//COPY AND PASTED SHIT FROM HEXAGON PLACE HOLDER
	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private RealCoordinate location;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	
	public EntityView(Color fillColor, Color outlineColor, RealCoordinate location) {
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	public void registerWithGameMapView(GameEntityView gv, RealCoordinate location) {
		gv.addEntityView(this);
		this.location = location;
	}
	
	public void render(Graphics graphics, float diameter) {
		backgroundHexagon.render(graphics, location, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, location, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);
	}
	public void setLocation(RealCoordinate location) {
		this.location = location;
	}
}
