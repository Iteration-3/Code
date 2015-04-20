package view.light;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import model.area.TileCoordinate;
import utilities.ScreenCoordinate;
import view.Renderable;
import view.ViewTransform;

public class GameLightView implements Renderable {
	
	public final static long TIME_TO_DIM = 800;
	private Map<TileCoordinate, LightView> lightViewMap = new HashMap<TileCoordinate, LightView>();

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		long time = System.currentTimeMillis();
		for(int x = transform.getLeftTileCoordinate(); x < transform.getRightTileCoordinate(); ++x) {
			for(int y = transform.getUpperTileCoordinate(); y < transform.getLowerTileCoordinate(); ++y) {	
				LightView lv = lightViewMap.get(new TileCoordinate(x, y));
				if (lv == null) continue;
				ScreenCoordinate renderPosition = transform.getTranslatedPosition(TileCoordinate.convertToRealCoordinate(new TileCoordinate(x, y)));
				lv.render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileWidth() * 1.05f, time);
			}
		}
	}
	
	public void lock() {
		for (LightView val : lightViewMap.values()) {
			val.lock();
		}
	}
	
	public void release() {
		for (LightView val : lightViewMap.values()) {
			val.release();
		}
	}
	
	public void addLightView(TileCoordinate tile, LightView lv) {
		lightViewMap.put(tile, lv);
	}
	
	public void removeLightView(TileCoordinate tile, LightView lv) {
		lightViewMap.remove(tile);
	}
}