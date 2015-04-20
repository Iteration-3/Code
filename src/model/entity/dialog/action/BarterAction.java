package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.Entity;
import model.states.gamestates.BarterState;

public class BarterAction extends DialogAction {

	@Override
	public void perform(Model model, Entity npc, Avatar avatar) {
		model.pushState(new BarterState(npc, avatar));
	}

}
