package model.entity.dialog;

import model.Model;
import model.entity.Avatar;
import model.entity.Entity;
import model.states.gamestates.DialogMenuState;

public final class DialogManager {
	private static DialogManager dialogManager = new DialogManager();
	private static Model model;
	
	private DialogManager() {
		
	}
	
	public void initDialog(Entity npc, Avatar avatar, DialogTree dialogTree) {
		model.pushState(new DialogMenuState(npc, avatar, dialogTree));
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
