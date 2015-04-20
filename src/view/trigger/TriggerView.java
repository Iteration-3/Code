package view.trigger;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import model.area.Area;
import model.area.RadialArea;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ImageProcessing;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Decal;
import view.Renderable;
import view.ViewTransform;

public class TriggerView implements Saveable, Renderable {

	private Decal decal;
	private List<RealCoordinate> realCoordinates = new ArrayList<RealCoordinate>(); 

	public TriggerView(Area area, Decal decal) {
		this.decal = decal;
	}
	
	public TriggerView(Decal decal, List<RealCoordinate> realCoordinates) {
		this.realCoordinates.addAll(realCoordinates);
		this.decal = decal;
	}
	
	public TriggerView(Decal decal) {
		for (TileCoordinate tileCoordinate: new RadialArea(1, new TileCoordinate(0, 0)).getCoveredLocations()) {
			realCoordinates.add(TileCoordinate.convertToRealCoordinate(tileCoordinate));
		}
		this.decal = decal;
	}
	
	public TriggerView() {
		this.decal = new Decal("/images/item.jpg");
	}
	
	public TriggerView(StructuredMap map) {
		map.put("decal", decal.getStructuredMap());
		// TODO Fix the Save and Load
	}

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for (RealCoordinate position: realCoordinates) {
			decal.setPosition(position);
			decal.render(graphics, transform);
		}
	}
	
	public BufferedImage getImage(int width, int height) {
		BufferedImage image = ImageProcessing.scaleImage(width, height, decal.getImageResourcePath());
		return image;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("decal", decal.getStructuredMap());
		// TODO: 
		return map;
	}

	public String getType() {
		return "triggerView";
	}

}
