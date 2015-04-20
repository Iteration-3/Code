package model.entity.behavior.npc.interact;

import java.util.ArrayList;
import java.util.Collection;

import model.entity.Avatar;
import model.entity.Entity;
import model.entity.NPC;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogManager;
import model.entity.dialog.DialogTree;
import model.entity.dialog.action.ExitAction;
import model.entity.dialog.action.MountAction;

public class MountInteract implements InteractableBehaviorState {
	private Entity mount;
	private Entity rider;
	private DialogTree dialogTree;
	
	public MountInteract(Entity entity){
		this.mount = entity;
		Collection<DialogEntry> dialogEntries = new ArrayList<DialogEntry>();
		dialogEntries.add(new DialogEntry("Mount", new MountAction()));
		dialogEntries.add(new DialogEntry("Exit", new ExitAction()));
		setDialogTree(new DialogTree(dialogEntries));
	}
	
	public void setDialogTree(DialogTree dialogTree){
		this.dialogTree = dialogTree;
	}

	@Override
	public void accept(NPC entity) {
	}

	@Override
	public void accept(Avatar avatar) {
		 if (this.rider == null) {
			 this.rider = avatar;
			 DialogManager.getSingleton().initDialog(this.mount , avatar, this.dialogTree);
		 }
	}

	@Override
	public void interact(Entity entity) {
		entity.accept(this);
	}
}
