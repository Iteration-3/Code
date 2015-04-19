package view.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.Area;
import model.area.RealCoordinate;
import model.area.TileCoordinate;

public class BasicProjectileView extends ProjectileView {

	private Hexagon hex;
	
	public BasicProjectileView(Area area, Color col) {
		super(area);
		this.hex = new Hexagon(col);
	}

	@Override
	public void render(Graphics graphics, RealCoordinate location, float diam) {
		hex.render(graphics, location, diam);
	}

}
