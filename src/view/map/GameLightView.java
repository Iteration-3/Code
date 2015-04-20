package view.map;

import java.awt.Color;
import java.awt.Graphics;

import model.area.TileCoordinate;
import model.light.LightManager;
import utilities.ScreenCoordinate;
import view.Renderable;
import view.ViewTransform;
import view.tiles.components.Hexagon;

public class GameLightView implements Renderable {
	public static long TIME_TO_DIM = 800;

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		long time = System.currentTimeMillis();
		for(int x = transform.getLeftTileCoordinate(); x < transform.getRightTileCoordinate(); ++x) {
			for(int y = transform.getUpperTileCoordinate(); y < transform.getLowerTileCoordinate(); ++y) {	
				ScreenCoordinate renderPosition = transform.getTranslatedPosition(TileCoordinate.convertToRealCoordinate(new TileCoordinate(x, y)));
				renderTile(graphics, x, y, renderPosition.getX(), renderPosition.getY(), transform.getTileWidth() * 1.05f, time);
			}
		}
	}
	
	private void renderTile(Graphics graphics, int x, int y, float renderX,
			float renderY, float tileSize, long time) {
		if (LightManager.getSingleton().getLightMap()
				.isEmpty(new TileCoordinate(x, y))) {
			// do dim sum
			long timeDelta = time
					- LightManager.getSingleton().getLightMap()
							.getTime(new TileCoordinate(x, y));
			double percentage;
			if (timeDelta > TIME_TO_DIM) {
				percentage = 1.0;
			} else {
				percentage = ((double) timeDelta) / TIME_TO_DIM;
			}
			percentage = 1 - percentage;
			int strength = LightManager.getSingleton().getLightMap()
					.getPrevStrength(new TileCoordinate(x, y));
			if (strength > 255)
				strength = 255;
			if (strength > 80) {
				int delt = strength - 80;
				int amt = (int) (delt * percentage);
				strength = strength - Math.abs(delt - amt);
				if (strength > 255)
					strength = 255;
				if (strength < 0)
					strength = 0;
			} else {
				if (timeDelta != time) // seen
					strength = 80;
			}
			Color col = new Color(84, 84, 84, 255 - strength);
			Hexagon hex = new Hexagon(col);

			hex.render(graphics, renderX, renderY, tileSize);
		} else {
			int strength = LightManager.getSingleton().getLightMap()
					.getStrength(new TileCoordinate(x, y));

			if (strength > 255)
				strength = 255;
			if (strength < 0)
				strength = 0;
			Color col = new Color(84, 84, 84, 255 - strength);
			Hexagon hex = new Hexagon(col);

			hex.render(graphics, renderX, renderY, tileSize);
		}
	}
}