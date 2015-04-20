package model.light;

import java.util.ArrayList;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.light.GameLightView;
import factories.LightSourceFactory;

public class LightManager implements Saveable {
	
	private static LightManager _lightManager = new LightManager();
	private ArrayList<LightSource> lightSources = new ArrayList<LightSource>();
	private LightMap lightMap = new LightMap(0, 0);

	public void setLightMap(LightMap lm) {
		lightMap = lm;
	}
	
	public static LightManager getSingleton() {
		return _lightManager;
	}
	
	public void addLightSource(LightSource lightSource) {
		System.out.println("ADD LIGHT SOURCE");
		lightSource.addLighting(lightSource.getArea());
		lightSources.add(lightSource);
	}
	
	public void removeLightSource(LightSource lightSource) {
		lightSource.removePrevLighting(lightSource.getArea());
		lightSource.removeLighting(lightSource.getArea());
		lightSources.remove(lightSource);
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

	public void load(StructuredMap map, GameLightView glv) {
		this.lightSources = new ArrayList<LightSource>();
		this.lightMap = new LightMap(map.getStructuredMap("lightMap"));
        lightMap.registerAll(glv);
        
		StructuredMap[] array = map.getStructuredMapArray("sources");
		for(StructuredMap temp : array) {
			//lightSources.add(LightSourceFactory.createLightSource(temp));
		}
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
