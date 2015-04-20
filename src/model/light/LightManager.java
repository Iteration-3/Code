package model.light;

import java.util.ArrayList;

import factories.LightSourceFactory;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class LightManager implements Saveable {
	
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

	public void load(StructuredMap map) {
		this.lightSources = new ArrayList<LightSource>();
		StructuredMap[] array = map.getStructuredMapArray("sources");
		for(StructuredMap temp : array) {
			lightSources.add(LightSourceFactory.createLightSource(temp));
		}
		this.lightMap = new LightMap(map.getStructuredMap("lightMap"));
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("lightMap", lightMap.getStructuredMap());
		StructuredMap[] array = new StructuredMap[lightSources.size()];
		for(int i = 0; i < array.length; i++) {
			array[i] = lightSources.get(i).getStructuredMap();
		}
		map.put("sources" , array);
		return map;
	}
}
