package view.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.RealCoordinate;
import model.area.TileCoordinate;

public class BasicProjectileView extends ProjectileView {

	private Hexagon hex;
	private float radius;
	
	public BasicProjectileView(TileCoordinate location, Color col, float radius) {
		super(location);
		this.hex = new Hexagon(col);
		this.radius = radius;
	}

	@Override
	public void render(Graphics graphics, RealCoordinate location, float diam) {
		hex.render(graphics, location, diam);
	}

}
