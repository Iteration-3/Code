package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.Model;
import model.entity.Avatar;
import model.entity.Entity;
import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogTree;
import controller.listener.ToggleAction;

public class DialogMenuController extends Controller {
	private ArrayList<ToggleAction> toggleActions;
	private Model model;
	private Entity npc;
	private Avatar avatar;
	private DialogTree dialogTree;

	public DialogMenuController(Model model, Entity npc, Avatar avatar,DialogTree dialogTree) {
		setModel(model);
		setNPC(npc);
		setAvatar(avatar);
		setDialogTree(dialogTree);
		initActions();
	}
	
	private void setDialogTree(DialogTree dialogTree) {
		this.dialogTree = dialogTree;
	}

	public ToggleAction getActionListener(DialogEntry dialogEntry) {
		Collection<DialogEntry> dialogEntries = this.dialogTree.getDialogEntries();
		int i = 0;
		for (DialogEntry d : dialogEntries) {
			if (d.equals(dialogEntry)) {
				return toggleActions.get(i);
			}
			++i;
		}
		return null;
	}
	
	@Override
	public void toggle() {
		for (ToggleAction toggleAction : toggleActions) {
			toggleAction.toggle();
		}
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		Collection<DialogEntry> dialogEntries =
				this.dialogTree.getDialogEntries();
		this.toggleActions = new ArrayList<ToggleAction>(dialogEntries.size());
		Iterator<DialogEntry> entryIterator = dialogEntries.iterator();
		while (entryIterator.hasNext()) {
			final DialogEntry dialogEntry = entryIterator.next();
			this.toggleActions.add(new ToggleAction() {
				@Override
				public void action() {
					dialogEntry.getAction().perform(getModel(), getNPC(), getAvatar());
				}
			});
		}
	}
	
	private void setModel(Model model) {
		this.model = model;
	}
	
	private Model getModel() {
		return this.model;
	}
	
	private void setNPC(Entity npc) {
		this.npc = npc;
	}
	
	private Entity getNPC() {
		return this.npc;
	}
	
	private void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	private Avatar getAvatar() {
		return this.avatar;
	}

}
