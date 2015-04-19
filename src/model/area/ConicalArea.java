package model.area;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class ConicalArea extends DirectionalArea {

    public ConicalArea() {
        super();
    }

    public ConicalArea(int radius, TileCoordinate startLocation, Angle angle) {
        super(radius, startLocation, angle);
    }  
    
    private TileCoordinate lastStart;
    private List<TileCoordinate> coverCache;
    private HashSet<TileCoordinate> resCache;
    private Angle lastDir;

    @Override
    public boolean isInRange(TileCoordinate location) {
    	getCoveredLocations();
    	return resCache.contains(location);
    }

    @Override
    public List<TileCoordinate> getCoveredLocations() {
    	if (lastStart == null || coverCache == null || lastStart != getStartLocation() || lastDir != getDirection()) {
	    	HashSet<TileCoordinate> res = new HashSet<TileCoordinate>();
	    	TileCoordinate curCenter = getStartLocation();
	    	int distFromCenter = 0;
	    	for (int rad = 0; rad <= getRadius(); rad++) {
	    		
	    		
	    		HashSet<TileCoordinate> atRad = getAtRadius(rad);
	    		res.add(curCenter);
	    		Queue<Pair> bfsQ = new LinkedList<Pair>();
	    		bfsQ.add(new Pair(curCenter, 0));
	    		
	    		while (!bfsQ.isEmpty()) {
	    			Pair poll = bfsQ.poll();
	    			int nextDist = poll.dist+1;
	    			if (nextDist > distFromCenter) continue;
	    			for (Angle ang : Angle.values()) {
	    				TileCoordinate next = poll.coord.nextLocation(ang);
	    				if (atRad.contains(next)) {
	    					if (!res.contains(next)) {
	    						res.add(next);
	    						bfsQ.add(new Pair(next, nextDist));
	    					}
	    				}
	    			}
	    		}
	    		
	    		curCenter = curCenter.nextLocation(getDirection());
	    		if (rad % 2 != 0) {
	    			distFromCenter++;
	    		}
	    	}
	    	lastStart = getStartLocation();
	    	coverCache = new ArrayList<TileCoordinate>(res);
	    	resCache = res;
	    	lastDir = getDirection();
    	}
        return coverCache;
    }
    
    private HashSet<TileCoordinate> getAtRadius(int radius) {
    	HashSet<TileCoordinate> res = new HashSet<TileCoordinate>();
    	HashSet<TileCoordinate> atRad = new HashSet<TileCoordinate>();
    	Queue<Pair> bfsQ = new LinkedList<Pair>();
    	res.add(getStartLocation());
    	if (radius == 0) atRad.add(getStartLocation());
    	bfsQ.add(new Pair(getStartLocation(), 0));
    	while (!bfsQ.isEmpty()) {
    		Pair poll = bfsQ.poll();
    		int nextDist = poll.dist + 1;
    		if (nextDist > radius) continue;
    		for (Angle ang : Angle.values()) {
    			TileCoordinate next = poll.coord.nextLocation(ang);
    			if (!res.contains(next)) {
    				res.add(next);
    				if (nextDist == radius) {
    					atRad.add(next);
    				}
    				bfsQ.add(new Pair(next, nextDist));
    			}
    		}
    	}
        return atRad;
    }
    
    private class Pair {
    	TileCoordinate coord;
    	int dist;
    	public Pair(TileCoordinate coord, int dist) {
    		this.coord = coord;
    		this.dist = dist;
    	}
    }

    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void load(StructuredMap map) {
        // TODO Auto-generated method stub

    }

}
