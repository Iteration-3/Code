package model.light;

import java.util.ArrayList;

public class LightManager {
	private static ArrayList<LightSource> lightSources;
	private static LightMap lightMap;
	
	public static void update() {
		lightMap.dimLights();
		for (LightSource lightSource : lightSources) {
			lightMap.illuminate(lightSource);
		}
	}
	
	public static void addLightSource(LightSource lightSource) {
		getLightSources().add(lightSource);
	}
	
	public static boolean removeLightSource(LightSource lightSource) {
		boolean contains = lightSources.contains(lightSource);
		if (contains) {
			lightSources.remove(lightSource);
		}
		return contains;
	}

	public static ArrayList<LightSource> getLightSources() {
		return lightSources;
	}

	public static void setLightSources(ArrayList<LightSource> lightSources) {
		LightManager.lightSources = lightSources;
	}

	public static LightMap getLightMap() {
		return LightManager.lightMap;
	}

	public static void setLightMap(LightMap lightMap) {
		LightManager.lightMap = lightMap;
	}

}
