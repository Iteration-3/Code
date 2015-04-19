package model;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.observers.MobileListener;
import model.observers.MobileObject;

public class Camera implements MobileListener {
	private RealCoordinate cameraPosition; //the location of the camera
	private float zoomFactor; // defines how many tiles we display in the y-axis
	private static final int TILES_TO_RENDER_Y = 20;

	private static final float SCREEN_WIDTH = 1024f;
	private static final float SCREEN_HEIGHT = 768f;
	
	
	public Camera() {
		zoomFactor = 1f;
	}
//
//	private void calculateTransform() {
//		
//	}
	
	public float getViewHeight() {
		return TILES_TO_RENDER_Y / zoomFactor;
	}
	
	public float getViewWidth() {
		return getViewHeight() * getAspectRatio();
	}
	
	public float getAspectRatio() {
		return SCREEN_WIDTH / SCREEN_HEIGHT;
	}
	
	public float tileHeight() {
		return getViewHeight();
	}

	public void notify(MobileObject sourceObject) {
		cameraPosition = TileCoordinate.convertToRealCoordinate(sourceObject.getLocation());
	}
}
