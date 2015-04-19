package model.light;

import java.util.ArrayList;

import model.area.TileCoordinate;

public class LightManager {
	
	private static LightManager _lightManager = new LightManager();
	private LightMap lightMap = new LightMap(100, 100); //TODO temp
	
	private LightManager() { 
	}
	
	public static LightManager getSingleton() {
		return _lightManager;
	}
	
	public void addLightSource(LightSource lightSource) {
		lightSource.addLighting();
	}
	
	public void removeLightSource(LightSource lightSource) {
		lightSource.removeLighting();
	}

	public LightMap getLightMap() {
		return lightMap;
	}
	
	public void clear() {
		//lightMap = new LightMap(100, 100); //TODO temp
		//right now lightsources manage themselves. TODO: fix :(
	}
}
