package model.area;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.Angle;

public class GrowingRadialArea extends GrowingArea {
    
    private TileCoordinate lastStart;
    private List<TileCoordinate> coverCache;
    private HashSet<TileCoordinate> resCache;
    private Angle lastDir;
    private int lastRadius = -1;
	
	public GrowingRadialArea(TileCoordinate location, Angle dir, int maxRadius) {
		super(maxRadius);
		setStartLocation(location);
		setDirection(dir);
	}

	@Override
	protected String getType() {
		return "growingRadialArea";
	}    
	
	@Override
    public boolean isInRange(TileCoordinate location) {
    	getCoveredLocations();
    	return resCache.contains(location);
    }

    @Override
    public List<TileCoordinate> getCoveredLocations() {
    	if (lastStart == null || coverCache == null || lastStart != getStartLocation() || lastDir != getDirection() || lastRadius != getCurRadius()) {
	    	HashSet<TileCoordinate> res = getAtRadius(getCurRadius());
	    	coverCache = new ArrayList<TileCoordinate>(res);
	    	resCache = res;
	    	lastDir = getDirection();
	    	lastRadius = getCurRadius();
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
}