package model.light;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import model.area.TileCoordinate;

public class LightMap implements Saveable {
	
	private int[][] strengths;
	private int[][] lightsOn;
	private long[][] timeDimmed;
	private int[][] lastStrength;
	
	public LightMap(int x, int y) {
		strengths = new int[x][y];
		lastStrength = new int[x][y];
		lightsOn = new int[x][y];
		timeDimmed = new long[x][y];
	}
	
	public LightMap(StructuredMap map) {
		StructuredMap[] xValues = map.getStructuredMapArray("dimmedValues");
		int x = xValues.length;
		int y = xValues[0].getStructuredMapArray("array").length;
		strengths = new int[x][y];
		lightsOn = new int[x][y];
		timeDimmed = new long[x][y];
		lastStrength = new int[x][y];
		
		for(int i = 0; i < x; i++) {
			StructuredMap[] yValues = map.getStructuredMapArray("array");
			for(int j = 0; j < y; j++) {
				timeDimmed[i][j] = yValues[j].getDouble("dimmed").longValue();
			}
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		StructuredMap[] array1 = new StructuredMap[timeDimmed.length];
		for(int i = 0; i < timeDimmed.length; i++) {
			StructuredMap tempMap[] = new StructuredMap[timeDimmed[i].length];
			for(int j = 0; j < timeDimmed[i].length; j++) {
				tempMap[j].put("dimmed", (double) timeDimmed[i][j]);
			}
			array1[i].put("array", tempMap);
		}
		map.put("dimmedValues", array1);
		return map;
	}
	
	public int getStrength(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return 0;
		return strengths[loc.getX()][loc.getY()];
	}
	
	public int getPrevStrength(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return 0;
		return lastStrength[loc.getX()][loc.getY()];
	}
	
	public boolean isEmpty(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return false;
		return lightsOn[loc.getX()][loc.getY()] == 0;
	}
	
	public long getTime(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return 0;
		return timeDimmed[loc.getX()][loc.getY()];
	}
	
	public void increment(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return;
		lightsOn[loc.getX()][loc.getY()]++;
		timeDimmed[loc.getX()][loc.getY()] = 0;
	}
	
	public void decrement(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return;
		lightsOn[loc.getX()][loc.getY()]--;
		if (lightsOn[loc.getX()][loc.getY()] == 0) {
			timeDimmed[loc.getX()][loc.getY()] = System.currentTimeMillis();
		}
	}
	
	public void setStrength(TileCoordinate loc, int val) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return;
		lastStrength[loc.getX()][loc.getY()] = strengths[loc.getX()][loc.getY()];
		strengths[loc.getX()][loc.getY()] = val;
	}

	
}
