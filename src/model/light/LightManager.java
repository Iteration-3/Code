package model.light;

import java.util.ArrayList;

import model.area.TileCoordinate;

public class LightManager {
	
	private static LightManager _lightManager = new LightManager();
	private ArrayList<LightSource> lightSources = new ArrayList<LightSource>();
	private LightMap lightMap = new LightMap(100, 100); //TODO temp
	
	private LightManager() { 
	}
	
	public int strength(TileCoordinate loc) {
		int baseStrength = getLightMap().getVisibility(loc).getValue();
		
		int sum = 0;
		for (LightSource l : lightSources) {
			if (l.getArea().isInRange(loc)) {
				sum += l.getVisibility().getValue();
			}
		}
		if (sum > 255) sum = 255;
		return Math.max(sum, baseStrength);
	}
	
	public void updateSeen() {
		for (LightSource s : lightSources) {
			for (TileCoordinate t : s.getArea().getCoveredLocations()) {
				getLightMap().see(t);
			}
		}
	}
	
	public static LightManager getLightManager() {
		return _lightManager;
	}
	
	public void addLightSource(LightSource lightSource) {
		lightSources.add(lightSource);
		updateSeen();
	}
	
	public boolean removeLightSource(LightSource lightSource) {
		return lightSources.remove(lightSource);
	}

	public LightMap getLightMap() {
		return lightMap;
	}
}
