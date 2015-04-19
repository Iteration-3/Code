package model.light;

import java.util.List;

import model.area.Area;
import model.area.TileCoordinate;

public class LightSource {
	
	private Area area;
	private int strength;
	
	public LightSource(Area area, int strength) {
		setArea(area);
		this.strength = strength;
	}
	
	public void addLighting() {
		//System.out.println("ADD: " + area.getStartLocation());
		List<TileCoordinate> locs = getArea().getCoveredLocations();
		for (TileCoordinate t : locs) {
			int strengthAt = LightManager.getSingleton().getLightMap().getStrength(t);
			LightManager.getSingleton().getLightMap().setStrength(t, strengthAt+strength);
			LightManager.getSingleton().getLightMap().increment(t);
			//System.out.println("INCREMENT: " + LightManager.getSingleton().getLightMap().getAmt(t));
			
		}
	}	
	
	public void removeLighting() {
		//System.out.println("REMOVE " + area.getStartLocation());
		List<TileCoordinate> locs = getArea().getCoveredLocations();
		for (TileCoordinate t : locs) {
			int strengthAt = LightManager.getSingleton().getLightMap().getStrength(t);
			LightManager.getSingleton().getLightMap().setStrength(t, strengthAt-strength);
			LightManager.getSingleton().getLightMap().decrement(t);
			//System.out.println("DECREMENT: " + LightManager.getSingleton().getLightMap().getAmt(t));
		}
	}

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
}
