package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.area.TileCoordinate;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogTree;
import model.entity.dialog.action.ExitAction;
import model.entity.dialog.action.MountAction;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Mount extends NPC {
	private Avatar rider;
	
	public Mount(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
		Collection<DialogEntry> dialogEntries = new ArrayList<DialogEntry>();
		dialogEntries.add(new DialogEntry("Mount", new MountAction()));
		dialogEntries.add(new DialogEntry("Exit", new ExitAction()));
		setDialogTree(new DialogTree(dialogEntries));
	}
	
	public Mount(String name, EntityView view, TileCoordinate location, DialogTree dialogTree) {
		super(name, view, location, dialogTree);
	}

	public Mount(StructuredMap map) {
		super(map);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void interact(Avatar avatar) {
		 if (this.rider == null) {
			 super.interact(avatar);
		 }
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
		}
	}

	@Override
	public String getType() {
		return "mount";
	}
}
