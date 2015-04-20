package view.projectiles;

import java.awt.Color;
import java.awt.Graphics;

import model.area.Area;
import view.map.components.Hexagon;

public class BasicProjectileView extends ProjectileView {

	private Hexagon hex;
	
	public BasicProjectileView(Area area, Color col) {
		super(area);
		this.hex = new Hexagon(col);
	}

	@Override
	public void render(Graphics graphics, float x, float y, float diam) {
		hex.render(graphics, x, y, diam);
	}

}
