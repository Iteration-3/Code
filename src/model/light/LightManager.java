package model.light;

import java.util.ArrayList;

public class LightManager {
	
	private static LightManager _lightManager = new LightManager();
	private ArrayList<LightSource> lightSources = new ArrayList<LightSource>();
	private LightMap lightMap = new LightMap(100, 100); //TODO temp
	
	private LightManager() { 
	}
	
	public static LightManager getSingleton() {
		return _lightManager;
	}
	
	public void addLightSource(LightSource lightSource) {
		lightSource.addLighting();
		lightSources.add(lightSource);
	}
	
	public void removeLightSource(LightSource lightSource) {
		lightSource.removeLighting();
	}

	public LightMap getLightMap() {
		return lightMap;
	}
	
	public void clear() {
		for (LightSource l : lightSources) {
			l.remove();
		}
		lightMap = new LightMap(100, 100); //TODO temp
	}
}
