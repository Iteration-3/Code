package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.Model;
import model.entity.Avatar;
import model.entity.NPC;
import model.entity.dialog.DialogEntry;
import controller.listener.ToggleAction;

public class DialogMenuController extends Controller {
	private ArrayList<ToggleAction> toggleActions;
	private Model model;
	private NPC npc;
	private Avatar avatar;

	public DialogMenuController(Model model, NPC npc, Avatar avatar) {
		setModel(model);
		setNPC(npc);
		setAvatar(avatar);
		initActions();
	}
	
	public ToggleAction getActionListener(DialogEntry dialogEntry) {
		Collection<DialogEntry> dialogEntries = getNPC().getDialogTree().getDialogEntries();
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
				this.getNPC().getDialogTree().getDialogEntries();
		this.toggleActions = new ArrayList<ToggleAction>(dialogEntries.size());
		Iterator<DialogEntry> entryIterator = dialogEntries.iterator();
		while (entryIterator.hasNext()) {
			DialogEntry dialogEntry = entryIterator.next();
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
	
	private void setNPC(NPC npc) {
		this.npc = npc;
	}
	
	private NPC getNPC() {
		return this.npc;
	}
	
	private void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	private Avatar getAvatar() {
		return this.avatar;
	}

}
