package view.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.ImageProcessing;
import utilities.structuredmap.StructuredMap;
import view.Decal;
import view.Renderable;
import view.ViewTransform;

public class BasicItemView extends ItemView implements Renderable {
	
	private Decal decal;
	
	public BasicItemView(RealCoordinate position, Decal decal) {
		super(position);
		this.decal = decal;
	}
	
	public BasicItemView(Decal decal) {
		super(new RealCoordinate(0.0, 0.0));
		this.decal = decal;
	}
	
	public BasicItemView() {
		super(new RealCoordinate(0.0, 0.0));
		this.decal = new Decal("/images/item.jpg");
	}
	
	public BasicItemView(StructuredMap map) {
		super(map);
		this.decal = new Decal(map.getStructuredMap("decal"));
	}

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		decal.setPosition(getPosition());
		decal.render(graphics, transform);
	}
	
	public BufferedImage getImage(int width, int height) {
		BufferedImage image = ImageProcessing.scaleImage(width, height, decal.getImageResourcePath());
		return image;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("decal", decal == null ? null : decal.getStructuredMap());
		return map;
	}

	@Override
	public String getType() {
		return "basicItem";
	}

}
