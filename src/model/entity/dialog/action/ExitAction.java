package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.Entity;
import model.entity.dialog.DialogManager;

public final class ExitAction extends DialogAction {

	@Override
	public void perform(Model model, Entity npc, Avatar avatar) {
		DialogManager.getSingleton().exit();
	}

	@Override
	public String getType() {
		return "exit";
	}

}
