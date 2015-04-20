package view.map;

import java.awt.Graphics;

import javax.crypto.spec.IvParameterSpec;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ScreenCoordinate;
import view.Renderable;
import view.ViewTransform;

public class GameTerrainView implements Renderable {
	private TileView[][] tileViews;
	public GameTerrainView() {
		tileViews = new TileView[100][100]; //exact sizing just for testing purposes
	}
	
	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for(int x = transform.getLeftTileCoordinate(); x < transform.getRightTileCoordinate(); ++x) {
			for(int y = transform.getUpperTileCoordinate(); y < transform.getLowerTileCoordinate(); ++y) {
				ScreenCoordinate renderPosition = transform.getTranslatedPosition(TileCoordinate.convertToRealCoordinate(new TileCoordinate(x, y)));
				if(x >= 0 && x < tileViews.length && y >= 0 && y < tileViews[0].length && tileViews[x][y]!=null){
					tileViews[x][y].render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileHeight());
				}
			}
		}
	}
	
	public void addTileView(TileView tileView, RealCoordinate p) {
		//Are we using location or point?
		//I assume this array is a temp thing and will just cast for now, but this needs to change eventually.
		//To be consistent, I'm going to use location + cast.
		tileViews[(int) p.getX()][(int) p.getY()] = tileView;	
	}
}
