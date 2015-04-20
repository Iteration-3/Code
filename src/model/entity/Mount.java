package model.entity;

import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.MountBehavior;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Mount extends NPC {
	private Avatar rider;
	
	public Mount(String name, EntityView view, TileCoordinate location) {
		super(name, "mount",  view, location, new MountBehavior());
	}

	public Mount(StructuredMap map) {
		super(map);
	}
	
	@Override
	public void move(Angle angle) {
		super.move(angle);
		if (this.rider != null) {
			// Rider will move with the avatar
			TileCoordinate riderLocation = this.getLocation();
			rider.setDirection(angle);
			rider.setLocation(riderLocation);
		}
	}
	
	@Override
	public void setLocation(TileCoordinate location) {
		super.setLocation(location);
		if (this.rider != null) {
			rider.setLocation(location);
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		return super.getStructuredMap();
	}
	
	public void setRider(Avatar rider) {
		this.rider = rider;
		this.rider.toggleView();
	}
	
	public void dismount() {
		if (this.rider != null) {
			this.rider.toggleView();
			this.rider = null;
			this.push(new MountBehavior());
		}
	}

	@Override
	public String getType() {
		return "mount";
	}
	
	@Override
	protected Behaviorable getBehavior(){
		return new MountBehavior();
	}
}
