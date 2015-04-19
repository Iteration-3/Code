package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.NPC;

public abstract class DialogAction {
	public abstract void perform(Model model, NPC npc, Avatar avatar);
}
