package view;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.observers.MobileListener;
import model.observers.MobileObject;
import utilities.Direction;
import utilities.ScreenCoordinate;

public class Camera implements MobileListener {
	private RealCoordinate cameraPosition;
	private static final int TILES_TO_RENDER_Y = 20;
	private static final float TILE_RATIO = (float) (2 / Math.sqrt(3));
	private float viewportWidth = 1024f;
	private float viewportHeight = 768f;
	
	public Camera() {
		cameraPosition = new RealCoordinate();
	}
	
	public RealCoordinate getPosition() {
		return cameraPosition;
	}
	
	public ViewTransform getTransform() {
		ScreenCoordinate screenCenter = new ScreenCoordinate(viewportWidth / 2, viewportHeight /2);
		return new ViewTransform(screenCenter, cameraPosition, getViewWidth(), getViewHeight(), getTileWidth(), getTileHeight());
	}

	public void setViewportBounds(int viewportWidth, int viewportHeight) {
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
	}
	
	public void move(Direction dir) {
		cameraPosition = TileCoordinate.convertToRealCoordinate(getMove(dir));
	}
	
	public TileCoordinate getMove(Direction dir) {
		TileCoordinate tileCoord = RealCoordinate.convertToTileCoordinate(cameraPosition);
		return tileCoord.nextLocation(dir);
	}

	public void notify(MobileObject sourceObject) {
		cameraPosition = TileCoordinate.convertToRealCoordinate(sourceObject.getLocation());
	}
	
	private float getTileHeight() {
		return viewportHeight / TILES_TO_RENDER_Y;
	}
	
	private float getTileWidth() {
		return getTileHeight() * TILE_RATIO;
	}

	private int getViewHeight() {
		return TILES_TO_RENDER_Y; // zoomFactor;
	}
	
	private int getViewWidth() {
		return Math.round(getViewHeight() * getAspectRatio() * TILE_RATIO);
	}
	
	private float getAspectRatio() {
		return viewportWidth / viewportHeight;
	}
}