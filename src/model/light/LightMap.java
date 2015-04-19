package model.light;

import model.area.TileCoordinate;

public class LightMap {
	
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
