package model.area;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utilities.Direction;

public class GrowingConicalArea extends GrowingArea {
    
    private TileCoordinate lastStart;
    private List<TileCoordinate> coverCache;
    private HashSet<TileCoordinate> resCache;
    private Direction lastDir;
    private int lastRadius = -1;
	
	public GrowingConicalArea(TileCoordinate location, Direction dir, int maxRadius) {
		super(maxRadius);
		setStartLocation(location);
		setDirection(dir);
	}

	@Override
	protected String getType() {
		return "growingConicalArea";
	}    
	
	@Override
    public boolean isInRange(TileCoordinate location) {
    	getCoveredLocations();
    	return resCache.contains(location);
    }

    @Override
    public List<TileCoordinate> getCoveredLocations() {
    	if (getCurRadius() > getMaxRadius()) {
    		return new ArrayList<TileCoordinate>();
    	}
    	if (lastStart == null || coverCache == null || lastStart != getStartLocation() || lastDir != getDirection() || lastRadius != getCurRadius()) {
	    	HashSet<TileCoordinate> res = new HashSet<TileCoordinate>();
	    	TileCoordinate curCenter = getStartLocation();
	    	int distFromCenter = 0;
	    	for (int rad = 0; rad <= getCurRadius(); rad++) {
	    		
	    		if (rad == getCurRadius()) {
		    		HashSet<TileCoordinate> atRad = getAtRadius(rad);
		    		res.add(curCenter);
		    		Queue<Pair> bfsQ = new LinkedList<Pair>();
		    		bfsQ.add(new Pair(curCenter, 0));
		    		
		    		while (!bfsQ.isEmpty()) {
		    			Pair poll = bfsQ.poll();
		    			int nextDist = poll.dist+1;
		    			if (nextDist > distFromCenter) continue;
		    			for (Direction ang : Direction.values()) {
		    				TileCoordinate next = poll.coord.nextLocation(ang);
		    				if (atRad.contains(next)) {
		    					if (!res.contains(next)) {
		    						res.add(next);
		    						bfsQ.add(new Pair(next, nextDist));
		    					}
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
    		for (Direction ang : Direction.values()) {
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