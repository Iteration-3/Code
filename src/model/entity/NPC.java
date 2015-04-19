package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.area.TileCoordinate;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogManager;
import model.entity.dialog.DialogTree;
import model.entity.dialog.action.ExitAction;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class NPC extends Entity {
	private DialogTree dialogTree;
	
	public NPC(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
		DialogEntry dialogEntry = new DialogEntry("Exit", new ExitAction());
		Collection<DialogEntry> dialogEntries = new ArrayList<DialogEntry>(1);
		dialogEntries.add(dialogEntry);
		setDialogTree(new DialogTree(dialogEntries));
	}
	
	public NPC(String name, EntityView view, TileCoordinate location, DialogTree dialogTree) {
		super(name, view, location);
		setDialogTree(dialogTree);
	}
	
	public void interact(Avatar avatar) {
		DialogManager.getSingleton().initDialog(this, avatar);
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
		// TODO Auto-generated method stub
		return null;
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

}
