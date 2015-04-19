package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.NPC;
import model.entity.dialog.DialogManager;

public final class ExitAction extends DialogAction {

	@Override
	public void perform(Model model, NPC npc, Avatar avatar) {
		System.out.println("It worked!!! You just popped the dialog state.");
		DialogManager.getSingleton().exit();
	}
	

}
