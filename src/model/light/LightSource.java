package model.light;

import java.util.List;

import factories.AreaFactory;
import model.area.Area;
import model.area.TileCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class LightSource implements Saveable {
	
	private Area area;
	private int strength;
	
	public LightSource(Area area, int strength) {
		setArea(area);
		this.strength = strength;
	}
	
	public LightSource(StructuredMap map) {
		this.area = AreaFactory.createArea(map.getStructuredMap("area"));
		this.strength = map.getInteger("strength");
	}
	
	public void addLighting() {
		List<TileCoordinate> locs = getArea().getCoveredLocations();
		for (TileCoordinate t : locs) {
			int strengthAt = LightManager.getSingleton().getLightMap().getStrength(t);
			LightManager.getSingleton().getLightMap().setStrength(t, strengthAt+strength);
			LightManager.getSingleton().getLightMap().increment(t);
			
		}
	}	
	
	public void removeLighting() {
		List<TileCoordinate> locs = getArea().getCoveredLocations();
		for (TileCoordinate t : locs) {
			int strengthAt = LightManager.getSingleton().getLightMap().getStrength(t);
			LightManager.getSingleton().getLightMap().setStrength(t, strengthAt-strength);
			LightManager.getSingleton().getLightMap().decrement(t);
		}
	}
	
	public void remove() {}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("area", area.getStructuredMap());
		map.put("strength", strength);
		map.put("type", getType());
		return map;
	}
	
	protected String getType() {
		return "lightSource";
	}
}
