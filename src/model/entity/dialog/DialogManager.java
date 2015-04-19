package model.entity.dialog;

import model.Model;
import model.entity.Avatar;
import model.entity.NPC;
import model.states.gamestates.DialogMenuState;

public final class DialogManager {
	private static DialogManager dialogManager = new DialogManager();
	private static Model model;
	
	private DialogManager() {
		
	}
	
	public void initDialog(NPC npc, Avatar avatar) {
		model.pushState(new DialogMenuState(npc, avatar));
	}
	
	public void exit() {
		model.popState();
	}
	
	public static DialogManager getSingleton() {
		return DialogManager.dialogManager;
	}
	
	public void setModel(Model model) {
		DialogManager.model = model;
	}
	
}
