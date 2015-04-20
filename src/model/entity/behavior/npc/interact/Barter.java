package model.entity.behavior.npc.interact;

import java.util.ArrayList;
import java.util.Collection;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogManager;
import model.entity.dialog.DialogTree;
import model.entity.dialog.action.BarterAction;
import model.entity.dialog.action.ExitAction;

public class Barter implements InteractableBehaviorState {
	private Entity barter;
	private Collection<DialogEntry> dialogEntries = new ArrayList<DialogEntry>(1);
	private DialogTree dialogTree;
	
	public Barter(Entity entity){
		this.barter = entity;
		this.dialogEntries.add(new DialogEntry("Barter", new BarterAction()));
		this.dialogEntries.add(new DialogEntry("Exit", new ExitAction()));
		this.setDialogTree(new DialogTree(dialogEntries));
	}
	
	private void setDialogTree(DialogTree dialogTree) {
		this.dialogTree = dialogTree;
	}

	@Override
	public void interact(Entity entity) {
		// can only barter with the avatar
		entity.accept(this);
	}
	
	
	public DialogTree getDialogTree() {
		return this.dialogTree;
	}

	@Override
	public void accept(NPC entity) {
		// NPC dont barter
	}

	@Override
	public void accept(Avatar avatar) {
		DialogManager.getSingleton().initDialog(this.barter, avatar, this.dialogTree);
	}
	
}
