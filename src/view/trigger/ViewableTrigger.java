package view.trigger;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import model.area.Area;
import model.area.RadialArea;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.event.Event;
import model.trigger.Trigger;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Decal;
import view.Renderable;
import view.ViewTransform;

public class ViewableTrigger extends Trigger implements Saveable, Renderable {

	private Decal decal;
	private List<RealCoordinate> realCoordinates = new ArrayList<RealCoordinate>(); 
	private Trigger trigger;

	public ViewableTrigger(Trigger trigger, Decal decal) {
		this.trigger = trigger;
		this.decal = decal;

		for (TileCoordinate tileCoordinate: trigger.getArea().getCoveredLocations()) {
			realCoordinates.add(TileCoordinate.convertToRealCoordinate(tileCoordinate));
		}
	}
	
	public ViewableTrigger(Decal decal, List<RealCoordinate> realCoordinates) {
		this.realCoordinates.addAll(realCoordinates);
		this.decal = decal;
	}
	
	public ViewableTrigger(Decal decal) {
		for (TileCoordinate tileCoordinate: new RadialArea(1, new TileCoordinate(0, 0)).getCoveredLocations()) {
			realCoordinates.add(TileCoordinate.convertToRealCoordinate(tileCoordinate));
		}
		this.decal = decal;
	}
	
	public ViewableTrigger() {
		this.decal = new Decal();
	}
	
	public ViewableTrigger(StructuredMap map) {
		map.put("decal", decal.getStructuredMap());
		// TODO Fix the Save and Load
	}

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		for (RealCoordinate position: realCoordinates) {
			decal.setPosition(position);
			decal.render(graphics, transform);
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("decal", decal.getStructuredMap());
		// TODO: RealCoordinate
		return map;
	}

	public String getType() {
		return "viewableTrigger";
	}

	@Override
	public boolean hasExpired() {
		return trigger.hasExpired();
	}

	@Override
	public Trigger clone() {
		return trigger.clone();
	}
	
	@Override
	public Area getArea() {
        return trigger.getArea();
    }

    public void setArea(Area area) {
        trigger.setArea(area);
    }

    public Event getEvent() {
        return trigger.getEvent();
    }

    public void setEvent(Event event) {
    	trigger.setEvent(event);
    }
    
    public void handle(Entity entity){
    	if(this.isInRange(entity)){
    		this.perform(entity);
    	}
    }
    
    protected boolean isInRange(Entity entity){
    	return getArea().isInRange(entity.getLocation());
    }

    public void moveLocation(TileCoordinate location) {
        getArea().setStartLocation(location);
    }

}
