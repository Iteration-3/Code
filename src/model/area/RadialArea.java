package model.area;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class RadialArea extends Area {

    public RadialArea() {
        super();
    }
    
    private TileCoordinate lastStart;
    private List<TileCoordinate> coverCache;
    private HashSet<TileCoordinate> resCache;

    public RadialArea(int radius, TileCoordinate startLocation) {
        super(radius, startLocation);
    }

    @Override
    public boolean isInRange(TileCoordinate location) {
    	getCoveredLocations();
        return resCache.contains(location);
    }

    @Override
    public List<TileCoordinate> getCoveredLocations() {
    	if (lastStart != getStartLocation() || coverCache == null) {
	    	HashSet<TileCoordinate> res = new HashSet<TileCoordinate>();
	    	Queue<Pair> bfsQ = new LinkedList<Pair>();
	    	res.add(getStartLocation());
	    	bfsQ.add(new Pair(getStartLocation(), 0));
	    	while (!bfsQ.isEmpty()) {
	    		Pair poll = bfsQ.poll();
	    		int nextDist = poll.dist + 1;
	    		if (nextDist > getRadius()) continue;
	    		for (Angle ang : Angle.values()) {
	    			TileCoordinate next = poll.coord.nextLocation(ang);
	    			if (!res.contains(next)) {
	    				res.add(next);
	    				bfsQ.add(new Pair(next, nextDist));
	    			}
	    		}
	    	}
	    	coverCache = new ArrayList<TileCoordinate>(res);
	    	resCache = res;
	    	lastStart = getStartLocation();
    	}
        return coverCache;
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
