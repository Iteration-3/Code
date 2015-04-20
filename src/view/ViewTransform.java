package view;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.ScreenCoordinate;

public class ViewTransform {
	private ScreenCoordinate screenTransformCenter;
	private RealCoordinate realTransformCenter;
	private TileCoordinate tileTransformCenter;
	private int widthInTiles;
	private int heightInTiles;
	private float tileWidth;
	private float tileHeight;
	
	public ViewTransform(ScreenCoordinate screenCenter, RealCoordinate transformPosition,
			int widthInTiles, int heightInTiles, float tileWidth, float tileHeight) {
		this.screenTransformCenter = screenCenter;
		this.realTransformCenter = transformPosition;
		this.tileTransformCenter = RealCoordinate.convertToTileCoordinate(transformPosition);
		this.widthInTiles = widthInTiles;
		this.heightInTiles = heightInTiles;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}

	public float getTileHeight() {
		return tileHeight;
	}

	public float getTileWidth() {
		return tileWidth;
	}

	public ScreenCoordinate getTranslatedPosition(RealCoordinate position) {
		float newX = (float) (position.getX() - realTransformCenter.getX())
				* getTileWidth() + screenTransformCenter.getX();
		float newY = (float) ((position.getY() - realTransformCenter.getY())
				* getTileHeight() * 2 / Math.sqrt(3) + screenTransformCenter.getY());
		return new ScreenCoordinate(newX, newY);
	}
	
	public int getUpperTileCoordinate() {
		return tileTransformCenter.getY() - heightInTiles / 2 - 2;
	}
	
	public int getLowerTileCoordinate() {
		return tileTransformCenter.getY() + heightInTiles / 2 + 2;
	}
	
	public int getLeftTileCoordinate() {
		return tileTransformCenter.getX() - widthInTiles / 2 - 2;
	}
	
	public int getRightTileCoordinate() {
		return tileTransformCenter.getX() + widthInTiles / 2 + 2;
	}
}
