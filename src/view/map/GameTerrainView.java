package view.map;

import java.awt.Graphics;

import model.Camera;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ScreenCoordinate;

public class GameTerrainView {
	private TileView[][] tileViews;
	
	public GameTerrainView() {
		tileViews = new TileView[100][100]; //exact sizing just for testing purposes
	}
	
	public void render(Graphics graphics, Camera camera) {
		RealCoordinate realCoord = camera.getPosition();
		TileCoordinate tileCoord = RealCoordinate.convertToTileCoordinate(camera.getPosition());
		int thingsToTheSide = (int) (camera.getViewWidth()) / 2 + 2;
		int thingsToTheUpDown = (int) (camera.getViewHeight()) / 2 + 2;
		float tileWidth = camera.getTileWidth();
		for(int x = tileCoord.getX() - thingsToTheSide; x < tileCoord.getX() + thingsToTheSide; ++x) {
			for(int y = tileCoord.getY() - thingsToTheUpDown; y < tileCoord.getY() + thingsToTheUpDown; ++y) {	
				ScreenCoordinate renderPosition = camera.getTranslatedPosition(TileCoordinate.convertToRealCoordinate(new TileCoordinate(x, y)), realCoord);
				if(x >= 0 && x < tileViews.length && y >= 0 && y < tileViews[0].length && tileViews[x][y]!=null){
					tileViews[x][y].render(graphics, renderPosition.getX(), renderPosition.getY(), tileWidth);
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
