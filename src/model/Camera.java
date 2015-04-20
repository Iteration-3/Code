package model;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.observers.MobileListener;
import model.observers.MobileObject;
import utilities.ScreenCoordinate;

public class Camera implements MobileListener {
	private RealCoordinate cameraPosition; //the location of the camera
	// private float zoomFactor; // defines how many tiles we display in the y-axis
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
	
	public float getTileHeight() {
		return viewportHeight / TILES_TO_RENDER_Y;
	}
	
	public float getTileWidth() {
		return getTileHeight() * TILE_RATIO;
	}
	
	// we must pass in a position or else the camera position may be updated while we're drawing
	public ScreenCoordinate getTranslatedPosition(RealCoordinate position, RealCoordinate referencePoint) {
		float newX = (float)(position.getX() - referencePoint.getX()) * getTileWidth() + viewportWidth / 2;
		float newY = (float)((position.getY() - referencePoint.getY()) * getTileHeight() * 2 / Math.sqrt(3) + viewportHeight / 2);
		return new ScreenCoordinate(newX, newY);
	}

	public float getViewHeight() {
		return TILES_TO_RENDER_Y; // zoomFactor;
	}
	
	public float getViewWidth() {
		return getViewHeight() * getAspectRatio() * TILE_RATIO;
	}
	
	private float getAspectRatio() {
		return viewportWidth / viewportHeight;
	}
	
	public void setViewportBounds(int viewportWidth, int viewportHeight) {
		this.viewportWidth = viewportWidth;
		this.viewportHeight = viewportHeight;
	}

	public void notify(MobileObject sourceObject) {
		cameraPosition = TileCoordinate.convertToRealCoordinate(sourceObject.getLocation());
	}
}
