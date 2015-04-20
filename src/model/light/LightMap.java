package model.light;

import model.area.TileCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.light.GameLightView;
import view.light.LightView;

public class LightMap implements Saveable {
	
	private int[][] strengths;
	private int[][] lightsOn;
	private long[][] timeDimmed;
	private int[][] lastStrength;
	private LightView[][] lightViews;
	
	public LightMap(int x, int y) {
		strengths = new int[x][y];
		lastStrength = new int[x][y];
		lightsOn = new int[x][y];
		timeDimmed = new long[x][y];
		lightViews = new LightView[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				lightViews[i][j] = new LightView(new TileCoordinate(i, j));
			}
		}
	}
	
	public LightMap(StructuredMap map) {
		StructuredMap[] xValues = map.getStructuredMapArray("dimmedValues");
		int x = xValues.length;
		int y = xValues[0].getStructuredMapArray("array").length;
		strengths = new int[x][y];
		lightsOn = new int[x][y];
		timeDimmed = new long[x][y];
		lastStrength = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				lightViews[i][j] = new LightView(new TileCoordinate(i, j));
			}
		}
		
		for(int i = 0; i < x; i++) {
			StructuredMap[] yValues = xValues[i].getStructuredMapArray("array");
			for(int j = 0; j < y; j++) {
				timeDimmed[i][j] = yValues[j].getDouble("dimmed").longValue();
				lightViews[i][j].setTimed(timeDimmed[i][j]);
			}
		}
	}
	
	public void registerAll(GameLightView glv) {
		 for (LightView[] lvArr : lightViews) {
			 for (LightView lv : lvArr) {
				 lv.registerWithGameLightView(glv);
			 }
		 }
	}
	
	public void unregisterAll() {
		 for (LightView[] lvArr : lightViews) {
			 for (LightView lv : lvArr) {
				 lv.unregisterWithGameLightView();
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
				StructuredMap notNullMap = new StructuredMap();
				notNullMap.put("dimmed",(double) timeDimmed[i][j]);
				tempMap[j] = notNullMap;
			}
			StructuredMap notNullMap2 = new StructuredMap();
			notNullMap2.put("array", tempMap);
			array1[i] = notNullMap2;
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
		lightViews[loc.getX()][loc.getY()].setTimed(0);
		lightViews[loc.getX()][loc.getY()].setIsEmpty(false);
	}
	
	public void decrement(TileCoordinate loc) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return;
		lightsOn[loc.getX()][loc.getY()]--;
		if (lightsOn[loc.getX()][loc.getY()] == 0) {
			timeDimmed[loc.getX()][loc.getY()] = System.currentTimeMillis();
			lightViews[loc.getX()][loc.getY()].setTimed(System.currentTimeMillis());
			lightViews[loc.getX()][loc.getY()].setIsEmpty(true);
		}
	}
	
	public void setStrength(TileCoordinate loc, int val) {
		if (loc.getX() < 0 || loc.getY() < 0 || loc.getX() >= strengths.length || loc.getY() >= strengths[0].length) 
			return;
		lastStrength[loc.getX()][loc.getY()] = strengths[loc.getX()][loc.getY()];
		lightViews[loc.getX()][loc.getY()].setPrevStrength(strengths[loc.getX()][loc.getY()]);
		strengths[loc.getX()][loc.getY()] = val;
		lightViews[loc.getX()][loc.getY()].setStrength(strengths[loc.getX()][loc.getY()]);
	}

	
}
