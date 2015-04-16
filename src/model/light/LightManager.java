package model.light;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LightManager {
	
	private static LightManager _lightManager = new LightManager();
	private ArrayList<LightSource> lightSources;
	private LightMap lightMap;
	
	private LightManager() { }
	
	public static LightManager getLightManager() {
		return _lightManager;
	}
	 
	public void update() {
		lightMap.dimLights();
		for (LightSource lightSource : lightSources) {
			lightMap.illuminate(lightSource);
		}
	}
	
	public void addLightSource(LightSource lightSource) {
		lightSources.add(lightSource);
	}
	
	public boolean removeLightSource(LightSource lightSource) {
		return lightSources.remove(lightSource);
	}

	public Collection<LightSource> getLightSources() {
		return Collections.unmodifiableCollection(lightSources);
	}

	public LightMap getLightMap() {
		return lightMap;
	}

	public void setLightMap(LightMap lightMap) {
		this.lightMap = lightMap;
	}
}
