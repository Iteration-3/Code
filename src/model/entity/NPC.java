package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.Patroling;
import model.entity.behavior.npc.PursueAvatar;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogManager;
import model.entity.dialog.DialogTree;
import model.entity.dialog.action.BarterAction;
import model.entity.dialog.action.ExitAction;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class NPC extends Entity {
	private DialogTree dialogTree;
	
	public NPC(String name, EntityView view, TileCoordinate location) {
		super(name, view, location,new PursueAvatar());
		Collection<DialogEntry> dialogEntries = new ArrayList<DialogEntry>(1);
		dialogEntries.add(new DialogEntry("Barter", new BarterAction()));
		dialogEntries.add(new DialogEntry("Exit", new ExitAction()));
		setDialogTree(new DialogTree(dialogEntries));
	}
	
	public NPC(String name, EntityView view, TileCoordinate location, DialogTree dialogTree) {
		super(name, view, location);
		setDialogTree(dialogTree);
	}
	
	public void interact(Avatar avatar) {
		DialogManager.getSingleton().initDialog(this, avatar);
	}

	// Needs behavior shit!
	// Behavior shit will be overridden by subclasses

	public NPC(StructuredMap map) {
		super(map);
	}

	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}

	@Override
	public StructuredMap getStructuredMap() {
		return super.getStructuredMap();
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	
	public DialogTree getDialogTree() {
		return this.dialogTree;
	}
	
	protected void setDialogTree(DialogTree dialogTree) {
		this.dialogTree = dialogTree;
	}

	@Override
	public String getType() {
		return "npc";
	}

}
